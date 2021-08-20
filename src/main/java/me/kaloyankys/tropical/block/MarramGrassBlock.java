package me.kaloyankys.tropical.block;

import me.kaloyankys.tropical.init.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class MarramGrassBlock extends PlantBlock {
    public MarramGrassBlock(Settings settings) {
        super(settings);
    }

    public static final VoxelShape SHAPE = Block.createCuboidShape(0D, 0D, 0D, 16D, 1D, 16D);

    @Override
    public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.SAND)|| floor.isOf(ModBlocks.DRIFTWOOD) || floor.isOf(Blocks.GRASS_BLOCK);
    }
    @Override
    public boolean isTranslucent(BlockState state, BlockView world, BlockPos pos) {
        return state.getFluidState().isEmpty();
    }
    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return type == NavigationType.AIR && !this.collidable ? true : super.canPathfindThrough(state, world, pos, type);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}