package com.dse.dseMod.block;

import java.util.Random;

import com.dse.dseMod.DseMod;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class BlockDirectionedSlab extends BlockSlab {
	public static final PropertyEnum<Variant> VARIANT = PropertyEnum.<Variant>create("variant", Variant.class);

	public BlockDirectionedSlab() {
		super(Material.ROCK);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		IBlockState iblockstate = this.blockState.getBaseState().withProperty(VARIANT, Variant.DEFAULT);

		if(!this.isDouble()) {
			iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
		}

		this.setDefaultState(iblockstate);
		this.useNeighborBrightness = !this.isDouble();
	}

	@Override
	public String getUnlocalizedName(int meta) {
		// TODO 自動生成されたメソッド・スタブ
		return this.getUnlocalizedName();
	}

	@Override
	public boolean isDouble() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public IProperty<?> getVariantProperty() {
		// TODO 自動生成されたメソッド・スタブ
		return VARIANT;
	}

	@Override
	public Comparable<?> getTypeForItem(ItemStack stack) {
		// TODO 自動生成されたメソッド・スタブ
		return Variant.byMetadata(stack.getMetadata() & 1);
	}

	public Comparable<?> getTypeForItemByDirection(EnumFacing facing){
		return Variant.byEnumFacing(facing);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(DseMod.BLOCKS.aodatami_slab);
	}

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(DseMod.BLOCKS.aodatami_slab);
	}

	@Override
	public final IBlockState getStateFromMeta(final int meta) {
		IBlockState blockstate = this.blockState.getBaseState().withProperty(VARIANT, Variant.byMetadata(meta & 1));
		if(!this.isDouble()) {
			blockstate = blockstate.withProperty(HALF, ((meta&8)!=0)?EnumBlockHalf.TOP:EnumBlockHalf.BOTTOM);
		}

		return blockstate;
	}

	@Override
	public final int getMetaFromState(final IBlockState state) {
		int meta = 0;

		if(!this.isDouble()&& state.getValue(HALF)==EnumBlockHalf.TOP) {
			meta |= 8;
		}

		if(state.getValue(VARIANT) == Variant.ROTATE) {
			meta |= 1;
		}

		return meta;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		if(!this.isDouble()){
			return new BlockStateContainer(this, new IProperty[] {VARIANT, HALF});
		}
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}

	//@Override
    //public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    //{
    //}

	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        IBlockState state = super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);

        if(placer.getHorizontalFacing() == EnumFacing.EAST || placer.getHorizontalFacing() == EnumFacing.WEST) {
        	state = state.withProperty(VARIANT, Variant.DEFAULT);
        }else {
        	state = state.withProperty(VARIANT, Variant.ROTATE);
        }

        return state;
    }

	public static enum Variant implements IStringSerializable
	{
		DEFAULT("default"),
		ROTATE("rotate");

		private String direction;

		private Variant(String name) {
			this.direction = name;
		}

        public static Variant byMetadata(int meta)
        {
            if (meta == 0) {
            	return Variant.DEFAULT;
            }

            return Variant.ROTATE;
        }

        public static Variant byEnumFacing(EnumFacing facing) {
        	if(facing == EnumFacing.EAST || facing == EnumFacing.WEST) {
        		return Variant.DEFAULT;
        	}else {
        		return Variant.ROTATE;
        	}
        }

		@Override
		public String getName() {
			return this.direction;
		}
	}
}
