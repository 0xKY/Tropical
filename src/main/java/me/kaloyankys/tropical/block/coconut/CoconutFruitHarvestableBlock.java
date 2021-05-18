package me.kaloyankys.tropical.block.coconut;

import me.kaloyankys.tropical.block.coconut.CoconutEmptyBlock;
import me.kaloyankys.tropical.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CoconutFruitHarvestableBlock extends CoconutEmptyBlock {
    public CoconutFruitHarvestableBlock(Settings settings) {
        super(settings);
    }
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.getItem() == Items.IRON_SWORD) {
            if (!world.isClient) {
                world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_BONE_BLOCK_BREAK, SoundCategory.BLOCKS, 0.3F, 0.5F);
                world.breakBlock(pos, false);
                world.setBlockState(pos, (BlockState) ModBlocks.COCONUT_OPEN.getDefaultState());
            }
            return ActionResult.success(world.isClient);
        } else {
            return super.onUse(state, world, pos, player, hand, hit);
        }
    }
}
