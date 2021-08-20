package me.kaloyankys.tropical.block.coconut;

import me.kaloyankys.tropical.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class CoconutBlock extends FallingBlock {
    public CoconutBlock(Settings settings) {
        super(settings);
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        Random random = new Random();
        if (itemStack.getItem() == Items.IRON_SWORD) {
            if (!world.isClient) {
                if (random.nextInt(5) == 0) {
                    player.spawnSweepAttackParticles();
                    world.playSound((PlayerEntity) null, pos, SoundEvents.BLOCK_BONE_BLOCK_BREAK, SoundCategory.BLOCKS, 0.3F, 0.5F);
                    world.breakBlock(pos, false);
                    world.setBlockState(pos, (BlockState) ModBlocks.COCONUT_OPEN.getDefaultState());
                    itemStack.damage(1, random, (ServerPlayerEntity) player);
                }
            if (random.nextInt(5) > 0) { // Coconut fails to open innit lol
                player.spawnSweepAttackParticles();
                world.playSound((PlayerEntity) null, pos, SoundEvents.BLOCK_BONE_BLOCK_PLACE, SoundCategory.BLOCKS, 0.3F, 0.5F);
                player.damage(DamageSource.MAGIC, 1.0f);
                itemStack.damage(1, random, (ServerPlayerEntity) player);
                }
            }
            if (itemStack.getItem() == Items.IRON_AXE) {
                if (!world.isClient) {
                    player.spawnSweepAttackParticles();
                    world.playSound((PlayerEntity) null, pos, SoundEvents.BLOCK_BONE_BLOCK_BREAK, SoundCategory.BLOCKS, 0.3F, 0.5F);
                    world.breakBlock(pos, false);
                    world.setBlockState(pos, (BlockState) ModBlocks.COCONUT_OPEN.getDefaultState());
                    itemStack.damage(1, random, (ServerPlayerEntity) player);
                }
            }
            return ActionResult.success(world.isClient);
        } else {
            return super.onUse(state, world, pos, player, hand, hit);
        }
    }
}
