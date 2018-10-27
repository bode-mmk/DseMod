package com.dse.dseMod.block;

import com.dse.dseMod.DseMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockBonbori extends Block {
	public static final PropertyEnum<LightMode> LIGHT_MODE = PropertyEnum.<LightMode>create("light_mode", LightMode.class);
	public static final AxisAlignedBB FROG_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.6D, 1.0D);

	public BlockBonbori() {
		super(Material.WOOD);
		this.setHardness(0.1f);
		this.setCreativeTab(CreativeTabs.DECORATIONS);
		this.setDefaultState(this.getStateFromMeta(0));
		this.setUnlocalizedName("bonbori");
		this.setRegistryName("bonbori");
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return FROG_AABB;
	}

	@Override
	public IBlockState getStateFromMeta(final int meta) {
		return this.blockState.getBaseState().withProperty(LIGHT_MODE, LightMode.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(final IBlockState state) {
		return LightMode.metaFromLightMode(state.getValue(LIGHT_MODE));
	}

	/*
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

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {LIGHT_MODE});
	}

	public static enum LightMode implements IStringSerializable
	{
		ON("on"),
		OFF("off"),
		AUTO_ON("auto_on"),
		AUTO_OFF("auto_off");

		private String mode;

		private LightMode(String mode) {
			this.mode = mode;
		}

		public static LightMode byMetadata(int meta)
		{
			if(meta == 0) {
				return LightMode.OFF;
			}else if(meta == 1) {
				return LightMode.ON;
			}else if(meta == 2){
				return LightMode.AUTO_OFF;
			}else {
				return LightMode.AUTO_ON;
			}
		}

		public static int metaFromLightMode(LightMode mode) {
			if(mode == LightMode.OFF) {
				return 0;
			}else if(mode == LightMode.ON) {
				return 1;
			}else if(mode == LightMode.AUTO_OFF){
				return 2;
			}else {
				return 3;
			}
		}

		public static LightMode toggleLightMode(LightMode mode) {
			if(mode == LightMode.OFF) {
				return LightMode.ON;
			}else if(mode == LightMode.ON) {
				return LightMode.AUTO_OFF;
			}else {
				return LightMode.OFF;
			}
		}

		@Override
		public String getName() {
			return mode;
		}
	}
}
