package me.kaloyankys.tropical.block;

import me.kaloyankys.tropical.init.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import java.util.Random;

public class BananaLeavesBlock extends LeavesBlock {
    public BananaLeavesBlock(Settings settings) {
        super(settings);
    }
    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(100) == 0 && world.getBlockState(pos.offset(Direction.Axis.Y, -1)) == (BlockState) Blocks.AIR.getDefaultState()) {
            world.setBlockState(pos.down(), (BlockState) ModBlocks.BANANA_VINE.getDefaultState());
        }
    }
}