package com.example.examplemod.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class MatterStabilizerBlock extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(15, 6, 15, 16, 14, 16),
            Block.makeCuboidShape(15, 6, 0, 16, 14, 1),
            Block.makeCuboidShape(0, 6, 0, 1, 14, 1),
            Block.makeCuboidShape(0, 6, 15, 1, 14, 16),
            Block.makeCuboidShape(0, 5, 0, 16, 6, 16),
            Block.makeCuboidShape(0, 14, 0, 16, 15, 16),
            Block.makeCuboidShape(1, 15, 1, 15, 16, 15),
            Block.makeCuboidShape(2, 0, 2, 14, 5, 14),
            Block.makeCuboidShape(1, 6, 1, 15, 14, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(0, 6, 15, 1, 14, 16),
            Block.makeCuboidShape(15, 6, 15, 16, 14, 16),
            Block.makeCuboidShape(15, 6, 0, 16, 14, 1),
            Block.makeCuboidShape(0, 6, 0, 1, 14, 1),
            Block.makeCuboidShape(0, 5, 0, 16, 6, 16),
            Block.makeCuboidShape(0, 14, 0, 16, 15, 16),
            Block.makeCuboidShape(1, 15, 1, 15, 16, 15),
            Block.makeCuboidShape(2, 0, 2, 14, 5, 14),
            Block.makeCuboidShape(1, 6, 1, 15, 14, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(0, 6, 0, 1, 14, 1),
            Block.makeCuboidShape(0, 6, 15, 1, 14, 16),
            Block.makeCuboidShape(15, 6, 15, 16, 14, 16),
            Block.makeCuboidShape(15, 6, 0, 16, 14, 1),
            Block.makeCuboidShape(0, 5, 0, 16, 6, 16),
            Block.makeCuboidShape(0, 14, 0, 16, 15, 16),
            Block.makeCuboidShape(1, 15, 1, 15, 16, 15),
            Block.makeCuboidShape(2, 0, 2, 14, 5, 14),
            Block.makeCuboidShape(1, 6, 1, 15, 14, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(15, 6, 0, 16, 14, 1),
            Block.makeCuboidShape(0, 6, 0, 1, 14, 1),
            Block.makeCuboidShape(0, 6, 15, 1, 14, 16),
            Block.makeCuboidShape(15, 6, 15, 16, 14, 16),
            Block.makeCuboidShape(0, 5, 0, 16, 6, 16),
            Block.makeCuboidShape(0, 14, 0, 16, 15, 16),
            Block.makeCuboidShape(1, 15, 1, 15, 16, 15),
            Block.makeCuboidShape(2, 0, 2, 14, 5, 14),
            Block.makeCuboidShape(1, 6, 1, 15, 14, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public MatterStabilizerBlock() {
        super(AbstractBlock.Properties.create(Material.IRON)
                .hardnessAndResistance(3.5f, 4.0f)
                .sound(SoundType.ANVIL)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool());
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.5f;
    }
}
