package com.example.examplemod.block;

import com.example.examplemod.setup.ModBlocks;
import com.example.examplemod.setup.ModTags;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.stream.Stream;

public class PhoesisMushroomBlock extends BushBlock implements IGrowable {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(7, 0, 7, 9, 5, 9),
            Block.makeCuboidShape(5, 5, 5, 11, 6, 11),
            Block.makeCuboidShape(5.5, 6, 5.5, 10.5, 7, 10.5),
            Block.makeCuboidShape(6, 7, 6, 10, 8, 10)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(7, 0, 7, 9, 5, 9),
            Block.makeCuboidShape(5, 5, 5, 11, 6, 11),
            Block.makeCuboidShape(5.5, 6, 5.5, 10.5, 7, 10.5),
            Block.makeCuboidShape(6, 7, 6, 10, 8, 10)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(7, 0, 7, 9, 5, 9),
            Block.makeCuboidShape(5, 5, 5, 11, 6, 11),
            Block.makeCuboidShape(5.5, 6, 5.5, 10.5, 7, 10.5),
            Block.makeCuboidShape(6, 7, 6, 10, 8, 10)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(7, 0, 7, 9, 5, 9),
            Block.makeCuboidShape(5, 5, 5, 11, 6, 11),
            Block.makeCuboidShape(5.5, 6, 5.5, 10.5, 7, 10.5),
            Block.makeCuboidShape(6, 7, 6, 10, 8, 10)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public PhoesisMushroomBlock() {
        super(AbstractBlock.Properties.create(Material.PLANTS)
                .zeroHardnessAndResistance()
                .doesNotBlockMovement()
                .sound(SoundType.FUNGUS));
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

    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.isIn(ModBlocks.PHOESIS_GRASS_BLOCK.get()) || super.isValidGround(state, worldIn, pos);
    }

    //what?
    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return false;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return (double)rand.nextFloat() < 0.4D;
    }

    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {

    }
}

