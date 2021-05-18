package me.kaloyankys.tropical.block.coconut;

import me.kaloyankys.tropical.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import java.util.Random;

public class CoconutFruitBlock extends Block {

    public CoconutFruitBlock(Settings settings) {
        super(settings);
    }

    public static final VoxelShape SHAPE = Block.createCuboidShape(4D, 8D, 4D, 12D, 16D, 12D);
    public static final IntProperty AGE = IntProperty.of("age", 0, 2);

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(AGE);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return (Integer)state.get(AGE) < 3;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int i = (Integer)state.get(AGE);
        if (i < 2 && random.nextInt(100) == 0) {
            world.setBlockState(pos, (BlockState)state.with(AGE, i + 1), 2);
        }
        if (i == 2) {
            world.setBlockState(pos, (BlockState) ModBlocks.COCONUT_FRUIT_GRAVITY.getDefaultState());
        }
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
