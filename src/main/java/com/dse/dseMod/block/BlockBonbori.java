package com.dse.dseMod.block;

import com.dse.dseMod.DseMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockBonbori extends Block {
	public static final AxisAlignedBB FROG_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.6D, 1.0D);

	public BlockBonbori() {
		super(Material.WOOD);
		this.setHardness(0.1f);
		this.setCreativeTab(CreativeTabs.DECORATIONS);
		//this.setDefaultState(this.getStateFromMeta(0));
		this.setUnlocalizedName("bonbori");
		this.setRegistryName("bonbori");
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return FROG_AABB;
	}

	/*
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
	*/

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
	public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		drops.add(new ItemStack(DseMod.BLOCK_ITEMS.bonbori_tile_item, 1, 0));
	}

	/*
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {POWER, DIRECTION});
	}*/
}
