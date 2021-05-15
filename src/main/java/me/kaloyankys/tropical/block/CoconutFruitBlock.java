package me.kaloyankys.tropical.block;

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
    private int i = 0;

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(AGE);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return (Integer)state.get(AGE) == 0;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if ((Integer)state.get(AGE) > 2) {
            i++;
            world.setBlockState(pos, state.with(AGE, i));
        }
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
