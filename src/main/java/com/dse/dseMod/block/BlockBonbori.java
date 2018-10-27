package com.dse.dseMod.block;

import com.dse.dseMod.DseMod;
import com.dse.dseMod.tileentity.TileEntityBonbori;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBonbori extends Block {
	public static final PropertyEnum<LightMode> LIGHT_MODE = PropertyEnum.<LightMode>create("light_mode", LightMode.class);
	public static final AxisAlignedBB FROG_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.6D, 1.0D);
	private final boolean isLight;
	private static final int MORNING_TICK_TIME = 1000;
	private static final int NIGHT_TICK_TIME = 12517;

	public BlockBonbori(boolean isLight) {
		super(Material.WOOD);
		this.setHardness(0.1f);
		this.setCreativeTab(CreativeTabs.DECORATIONS);
		this.setDefaultState(this.getStateFromMeta(0));
		this.isLight = isLight;
		if(isLight) {
			this.setUnlocalizedName("bonbori_on");
			this.setRegistryName("bonbori_on");
			this.setLightLevel(1.0f);
		}else {
			this.setUnlocalizedName("bonbori_off");
			this.setRegistryName("bonbori_off");
			this.setLightLevel(0.0f);
		}
	}

	public void updateLightPower(World world, BlockPos pos) {
		long time = world.getWorldTime();

		if(world.getBlockState(pos).getValue(LIGHT_MODE) == LightMode.AUTO_ON) {
			if(BlockBonbori.MORNING_TICK_TIME < time && time < BlockBonbori.NIGHT_TICK_TIME){
				world.setBlockState(pos, DseMod.BLOCKS.bonbori_off.getDefaultState().withProperty(LIGHT_MODE, LightMode.AUTO_ON), 2);
			}else {
				world.setBlockState(pos, DseMod.BLOCKS.bonbori_on.getDefaultState().withProperty(LIGHT_MODE, LightMode.AUTO_ON), 2);
			}
		}
	}

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    	if(!worldIn.isRemote) {
    		LightMode mode = state.getValue(LIGHT_MODE);
    		if(!this.isLight && mode == LightMode.AUTO_OFF) {
    			worldIn.setBlockState(pos,  DseMod.BLOCKS.bonbori_on.getDefaultState(), 2);
    		}else if(this.isLight && mode == LightMode.AUTO_OFF){
    			worldIn.setBlockState(pos, DseMod.BLOCKS.bonbori_off.getDefaultState().withProperty(LIGHT_MODE, LightMode.AUTO_ON), 2);
    		}else {
    			worldIn.setBlockState(pos, DseMod.BLOCKS.bonbori_off.getDefaultState(), 2);
    		}
    	}
    	return true;
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

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityBonbori();
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
	public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		drops.add(new ItemStack(DseMod.BLOCK_ITEMS.bonbori_tile_item, 1, 0));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {LIGHT_MODE});
	}

	public static enum LightMode implements IStringSerializable
	{
		AUTO_ON("auto_on"),
		AUTO_OFF("auto_off");

		private String mode;

		private LightMode(String mode) {
			this.mode = mode;
		}

		public static LightMode byMetadata(int meta)
		{
			if(meta == 0) {
				return LightMode.AUTO_OFF;
			}else {
				return LightMode.AUTO_ON;
			}
		}

		public static int metaFromLightMode(LightMode mode) {
			if(mode == LightMode.AUTO_OFF){
				return 0;
			}else {
				return 1;
			}
		}

		@Override
		public String getName() {
			return mode;
		}
	}
}
