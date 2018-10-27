package com.dse.dseMod.block;

import com.dse.dseMod.tileentity.TileEntityWeatherFrog;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockWeatherFrog extends BlockDirectionedBlock {
	public static final PropertyInteger POWER = PropertyInteger.create("power", 0, 2);

	public BlockWeatherFrog() {
		super(Material.ANVIL);
		this.setCreativeTab(CreativeTabs.DECORATIONS);
		this.setDefaultState(this.getStateFromMeta(0));
		this.setUnlocalizedName("weather_frog");
		this.setRegistryName("weather_frog");
	}

	@Override
	public IBlockState getStateFromMeta(final int meta) {
		IBlockState blockstate = super.getStateFromMeta(meta & 3);
		blockstate.withProperty(POWER, metaToPower(meta));
		return blockstate;
	}

	@Override
	public int getMetaFromState(final IBlockState state) {
		return ((EnumFacing)state.getValue(DIRECTION)).getHorizontalIndex() + powerToMeta(((Integer)state.getValue(POWER)).intValue());
	}


	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityWeatherFrog();
	}

	@Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
    public boolean canProvidePower(IBlockState state)
    {
        return true;
    }

	@Override
    public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
		return ((Integer)blockState.getValue(POWER)).intValue() * 2;
    }

	public void updatePower(World worldIn, BlockPos pos, int power) {
		IBlockState state = worldIn.getBlockState(pos);
		if(((Integer)state.getValue(POWER)).intValue() != power) {
			worldIn.setBlockState(pos, state.withProperty(POWER, Integer.valueOf(power)), 3);
		}
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {POWER, DIRECTION});
	}

	public static int metaToPower(int meta) {
		return meta >> 2;
	}

	public static int powerToMeta(int power) {
		return power << 2;
	}
}
