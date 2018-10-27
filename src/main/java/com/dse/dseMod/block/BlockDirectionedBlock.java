package com.dse.dseMod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockDirectionedBlock extends Block {
	public static final PropertyDirection DIRECTION = PropertyDirection.create("direction", EnumFacing.Plane.HORIZONTAL);

	public BlockDirectionedBlock(Material materialIn) {
		super(materialIn);
		IBlockState iblockstate = this.blockState.getBaseState().withProperty(DIRECTION, EnumFacing.NORTH);
		this.setDefaultState(iblockstate);
	}


	@Override
	public IBlockState getStateFromMeta(final int meta) {
		IBlockState blockstate = this.blockState.getBaseState().withProperty(DIRECTION, EnumFacing.getHorizontal(meta));
		return blockstate;
	}

	@Override
	public int getMetaFromState(final IBlockState state) {
		return ((EnumFacing)state.getValue(DIRECTION)).getHorizontalIndex();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {DIRECTION});
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		IBlockState state = super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
		state = state.withProperty(DIRECTION, placer.getHorizontalFacing().getOpposite());

		return state;
	}
}
