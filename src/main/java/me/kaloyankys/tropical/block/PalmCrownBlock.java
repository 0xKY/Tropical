package me.kaloyankys.tropical.block;

import me.kaloyankys.tropical.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.Random;

public class PalmCrownBlock extends LeavesBlock {

    public PalmCrownBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        Block frond = new FrondBlock(settings);
        if (world.getBlockState(pos.north()) == Blocks.AIR.getDefaultState()) {
            world.setBlockState(pos.north(), frond.getDefaultState()
                    .with(FrondBlock.FROND_SIDE, Direction.NORTH));
        }
        else if (world.getBlockState(pos.east()) == Blocks.AIR.getDefaultState()) {
            world.setBlockState(pos.north(), frond.getDefaultState()
                    .with(FrondBlock.FROND_SIDE, Direction.EAST));
        }
        else if (world.getBlockState(pos.south()) == Blocks.AIR.getDefaultState()) {
            world.setBlockState(pos.north(), frond.getDefaultState()
                    .with(FrondBlock.FROND_SIDE, Direction.SOUTH));
        }
        else if (world.getBlockState(pos.west()) == Blocks.AIR.getDefaultState()) {
            world.setBlockState(pos.north(), frond.getDefaultState()
                    .with(FrondBlock.FROND_SIDE, Direction.WEST));
        }
        super.scheduledTick(state, world, pos, random);
    }
}