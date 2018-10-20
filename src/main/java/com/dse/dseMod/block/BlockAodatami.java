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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class BlockAodatami extends BlockSlab {
	public static final PropertyEnum<Variant> VARIANT = PropertyEnum.<Variant>create("variant", Variant.class);

	public BlockAodatami() {
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
		return Variant.DEFAULT;
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
		IBlockState blockstate = this.blockState.getBaseState().withProperty(VARIANT, Variant.DEFAULT);

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

		return meta;
	}

	public static class Double extends BlockAodatami
	{

		public Double() {
			super();
			this.setUnlocalizedName("aodatami_slab_double");
			this.setRegistryName("aodatami_slab_double");
		}

		@Override
		public boolean isDouble() {
			return true;
		}

	}

	public static class Half extends BlockAodatami
	{

		public Half() {
			super();
			this.setUnlocalizedName("aodatami_slab");
			this.setRegistryName("aodatami_slab");
		}

		@Override
		public boolean isDouble() {
			return false;
		}

	}

	@Override
	protected BlockStateContainer createBlockState() {
		if(!this.isDouble()){
			return new BlockStateContainer(this, new IProperty[] {VARIANT, HALF});
		}
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}

	public static enum Variant implements IStringSerializable
	{
		DEFAULT;

		@Override
		public String getName() {
			return "default";
		}
	}
}
