package me.kaloyankys.tropical.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class FrondBlock extends Block {

    public static final DirectionProperty FROND_SIDE = DirectionProperty.of("frond_side");

    public FrondBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(FROND_SIDE);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        Block palmCrown = new PalmCrownBlock(settings);
        if (world.getBlockState(pos.north()) != palmCrown.getDefaultState()) {
            world.breakBlock(pos, false);
        }
        else if (world.getBlockState(pos.east()) != palmCrown.getDefaultState()) {
            world.breakBlock(pos, false);
        }
        else if (world.getBlockState(pos.south()) != palmCrown.getDefaultState()) {
            world.breakBlock(pos, false);
        }
        else if (world.getBlockState(pos.west()) != palmCrown.getDefaultState()) {
            world.breakBlock(pos, false);
        }
        super.scheduledTick(state, world, pos, random);
    }
}
