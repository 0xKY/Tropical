package me.kaloyankys.tropical.block.coconut;

import me.kaloyankys.tropical.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class CoconutOpenBlock extends FallingBlock {
    public CoconutOpenBlock(Settings settings) {
        super(settings);
    }

    public static final VoxelShape SHAPE = Block.createCuboidShape(4D, 0D, 4D, 12D, 8D, 12D);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (!world.isClient) {
            world.playSound((PlayerEntity) null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 0.3F, 0.5F);
            world.setBlockState(pos, (BlockState) ModBlocks.COCONUT_OPEN_EMPTY.getDefaultState());
            player.heal(1.0f);
            return ActionResult.success(true);
        } else {
            return super.onUse(state, world, pos, player, hand, hit);
        }
    }
}