package me.kaloyankys.tropical.block;

import me.kaloyankys.tropical.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.Random;

public class CoconutLeavesBlock extends LeavesBlock {
    public CoconutLeavesBlock(Settings settings) {
        super(settings);
    }
    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(100) == 0 && world.getBlockState(pos.offset(Direction.Axis.Y, -1)) == (BlockState) Blocks.AIR.getDefaultState()) {
            world.setBlockState(pos.down(), (BlockState) ModBlocks.COCONUT_FRUIT.getDefaultState());
        }
    }
}