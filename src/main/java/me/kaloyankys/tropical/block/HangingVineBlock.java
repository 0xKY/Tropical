package me.kaloyankys.tropical.block;

import me.kaloyankys.tropical.init.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class HangingVineBlock extends LadderBlock {
    public HangingVineBlock(Settings settings) {
        super(settings);
    }
    public static final VoxelShape SHAPE = Block.createCuboidShape(0D, 0D, 0D, 14D, 16D, 14D);

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(100) == 0 && world.getBlockState(pos.offset(Direction.Axis.Y, -1)) == (BlockState) Blocks.AIR.getDefaultState()) {
            world.setBlockState(pos.down(), (BlockState) ModBlocks.BANANA_VINE.getDefaultState());
        }
        if (random.nextInt(100) == 1 && world.getBlockState(pos.offset(Direction.Axis.Y, -1)) == (BlockState) Blocks.AIR.getDefaultState()) {
            world.setBlockState(pos.down(), (BlockState) ModBlocks.BANANA_BUNCH.getDefaultState());
        }
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
