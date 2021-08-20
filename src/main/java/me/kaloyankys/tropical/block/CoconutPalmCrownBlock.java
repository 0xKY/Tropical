package me.kaloyankys.tropical.block;

import me.kaloyankys.tropical.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class CoconutPalmCrownBlock extends LeavesBlock {
    public CoconutPalmCrownBlock(Settings settings) {
        super(settings);
    }
    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(100) == 0 &&
                world.getBlockState(pos.east()) == (BlockState) Blocks.AIR.getDefaultState() ||
                world.getBlockState(pos.west()) == (BlockState) Blocks.AIR.getDefaultState() ||
                world.getBlockState(pos.south()) == (BlockState) Blocks.AIR.getDefaultState() ||
                world.getBlockState(pos.north()) == (BlockState) Blocks.AIR.getDefaultState()) {
            world.setBlockState(pos.down(), (BlockState) ModBlocks.COCONUT_FRUIT.getDefaultState());
        }
    }
}