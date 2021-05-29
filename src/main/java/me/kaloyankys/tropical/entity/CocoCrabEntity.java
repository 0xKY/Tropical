package me.kaloyankys.tropical.entity;

import com.google.common.collect.Lists;
import me.kaloyankys.tropical.init.ModBlocks;
import me.kaloyankys.tropical.init.ModEntities;
import me.kaloyankys.tropical.init.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableShoulderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.EnumSet;
import java.util.List;

public class CocoCrabEntity extends TameableShoulderEntity {
    public static final TrackedData<Boolean> EATING = DataTracker.registerData(CocoCrabEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public static final TrackedData<Boolean> PASSIVE = DataTracker.registerData(CocoCrabEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public Ingredient TEMPT_ITEM = Ingredient.ofItems(ModBlocks.COCONUT);
    private AttributeContainer attributeContainer;
    private int eatCooldown = 100;
    public int eatTime = 0;
    private TemptGoal temptGoal;

    public CocoCrabEntity(World world) {
        super(ModEntities.COCONUT_CRAB, world);
    }

    @Override
    protected void initGoals() {
        TEMPT_ITEM = Ingredient.ofItems(ModBlocks.COCONUT);

        this.temptGoal = new TemptGoal(this, 1.0D, TEMPT_ITEM, false);

        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, temptGoal);
        this.goalSelector.add(2, new SitOnOwnerShoulderGoal(this));
        this.goalSelector.add(3, new EscapeDangerGoal(this, 1.25D));
        this.goalSelector.add(4, new AnimalMateGoal(this, 1.0D));
        this.goalSelector.add(5, new FleeEntityGoal<>(this, PlayerEntity.class, 16.0F, 1.6D, 1.4D, (livingEntity) -> !isPassive()));
        this.goalSelector.add(6, new FollowParentGoal(this, 1.1D));
        this.goalSelector.add(6, new FollowMobGoal(this, 1.1D, 1.0f, 10.0f));
        this.goalSelector.add(7, new EatCoconutGoal());
        this.goalSelector.add(8, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(9, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(10, new LookAroundGoal(this));
    }

    @Override
    public boolean isReadyToSitOnPlayer() {
        return true;
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(EATING, false);
        this.dataTracker.startTracking(PASSIVE, false);
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        Item item = itemStack.getItem();
        if (this.world.isClient) {
            if (this.isBreedingItem(itemStack)) {
                return ActionResult.SUCCESS;
            }
        } else {
            if (dataTracker.get(PASSIVE)) {
                if (item.isFood() && this.isBreedingItem(itemStack) && this.getHealth() < this.getMaxHealth()) {
                    this.eat(player, itemStack);
                    this.heal((float) item.getFoodComponent().getHunger());
                    this.setTamed(true);
                    return ActionResult.CONSUME;
                }
            } else if (this.isBreedingItem(itemStack)) {
                this.eat(player, itemStack);
                if (this.random.nextInt(3) == 0) {
                    dataTracker.set(PASSIVE, true);
                    this.setTamed(true);
                    this.world.sendEntityStatus(this, (byte) 7);
                } else {
                    this.world.sendEntityStatus(this, (byte) 6);
                }
                this.setPersistent();
                return ActionResult.CONSUME;
            }
        }
        return super.interactMob(player, hand);
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damageSource) {
        if (damageSource == DamageSource.DROWN) return true;

        return super.isInvulnerableTo(damageSource);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return TEMPT_ITEM.test(stack);
    }

    @Override
    public boolean canBeLeashedBy(PlayerEntity player) {
        return super.canBeLeashedBy(player) && isPassive();
    }

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        CocoCrabEntity cocoBebe = ModEntities.COCONUT_CRAB.create(world);
        cocoBebe.setPassive(true);
        return cocoBebe;
    }

    @Override
    public void onTrackedDataSet(TrackedData<?> data) {
        super.onTrackedDataSet(data);
    }

    public boolean isPassive() {
        return dataTracker.get(PASSIVE);
    }

    public void setPassive(boolean passive) {
        dataTracker.set(PASSIVE, passive);
    }

    @Override
    public void writeCustomDataToTag(CompoundTag tag) {
        super.writeCustomDataToTag(tag);
        tag.putBoolean("Passive", isPassive());
        tag.putInt("EatCooldown", eatCooldown);
    }

    @Override
    public void readCustomDataFromTag(CompoundTag tag) {
        super.readCustomDataFromTag(tag);
        setPassive(tag.getBoolean("Passive"));
        eatCooldown = tag.getInt("EatCooldown");
    }

    @Override
    public AttributeContainer getAttributes() {
        if (attributeContainer == null)
            attributeContainer = new AttributeContainer(MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D).build());
        return attributeContainer;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        if (!state.getMaterial().isLiquid()) {
            playSound(ModSoundEvents.CRAB_WALK, 0.10F, 1.25F + random.nextFloat());
            spawnSprintingParticles();
        }
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSoundEvents.CRAB_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSoundEvents.CRAB_HURT;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSoundEvents.CRAB_AMBIENT;
    }

    @Override
    public int getMinAmbientSoundDelay() {
        return super.getMinAmbientSoundDelay() * 3;
    }

    @Override
    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 0.2F;
    }

    @Override
    public boolean canSpawn(WorldAccess world, SpawnReason spawnReason) {
        return world.getRandom().nextBoolean() && world.getEntitiesByClass(CocoCrabEntity.class, new Box(new BlockPos(getX(), getY(), getZ())).expand(50), (e) -> true).isEmpty() && super.canSpawn(world, spawnReason);
    }
    public class EatCoconutGoal extends Goal
    {
        private BlockPos targetPos;

        public EatCoconutGoal()
        {
            this.setControls(EnumSet.of(Goal.Control.MOVE, Control.LOOK));
        }

        @Override
        public boolean canStart()
        {

            BlockPos eatPos = findCoconut();
            if(eatPos != null)
            {
                targetPos = eatPos;
                return true;
            }
            return false;
        }

        @Override
        public void tick()
        {
            if(squaredDistanceTo(targetPos.getX() + 0.5F, targetPos.getY() + 0.5F, targetPos.getZ() + 0.5F) > 2F)
            {
                getMoveControl().moveTo(targetPos.getX() + 0.1F, targetPos.getY() + 0.8F, targetPos.getZ() + 0.1F, 0.1F);
            }
            getLookControl().lookAt(targetPos.getX() + 1.0F, targetPos.getY() + 0.0F, targetPos.getZ() + 0.0F);
            {
                BlockState st = world.getBlockState(targetPos);
                if(st.isOf(ModBlocks.COCONUT))
                {
                    world.breakBlock(targetPos, false);
                    world.setBlockState(targetPos, ModBlocks.COCONUT_OPEN.getDefaultState());
                }
                if(st.isOf(ModBlocks.COCONUT_OPEN))
                {
                    world.breakBlock(targetPos, false);
                    world.setBlockState(targetPos, ModBlocks.COCONUT_OPEN_EMPTY.getDefaultState());
                }
            }
        }

        @Override
        public boolean shouldContinue()
        {
            BlockState st = world.getBlockState(targetPos);
            if(!st.isOf(ModBlocks.COCONUT)) return false;

            return squaredDistanceTo(targetPos.getX() + 0.5F, targetPos.getY() + 0.5F, targetPos.getZ() + 0.5F) <= 2;
        }

        @Override
        public void start()
        {
            dataTracker.set(EATING, true);
            eatTime = 40 + random.nextInt(40);
        }

        @Override
        public void stop()
        {
            dataTracker.set(EATING, false);
        }

        private BlockPos findCoconut()
        {
            BlockPos startPos = getBlockPos();
            List<BlockPos> spots = Lists.newArrayList();

            BlockPos.Mutable m = new BlockPos.Mutable(startPos.getX(), startPos.getY(), startPos.getZ());
            for(int x = startPos.getX() - 2; x < startPos.getX() + 2; x++)
            {
                for(int z = startPos.getZ() - 2; z < startPos.getZ() + 2; z++)
                {
                    m.set(x, startPos.getY(), z);
                    BlockState checkState = world.getBlockState(m);
                    if(checkState.isOf(ModBlocks.COCONUT))
                    {
                        spots.add(new BlockPos(m.getX(), m.getY(), m.getZ()));
                    }
                }
            }
            if(spots.isEmpty()) return null;
            return spots.get(world.random.nextInt(spots.size()));
        }
    }
}