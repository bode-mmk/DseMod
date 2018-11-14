package com.dse.dseMod.block;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class BlockNormalSlab extends BlockSlab {
	public static final PropertyEnum<Dummy> DUMMY = PropertyEnum.<Dummy>create("dummy",Dummy.class);

	public BlockNormalSlab(Material type) {
		super(type);
		IBlockState iblockstate = this.blockState.getBaseState();

		if(!this.isDouble()) {
			iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
		}

		this.setDefaultState(iblockstate);
		this.useNeighborBrightness = !this.isDouble();
	}

	public BlockNormalSlab() {
		this(Material.WOOD);
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
	public final IBlockState getStateFromMeta(final int meta) {
		IBlockState blockstate = this.blockState.getBaseState();
		if(!this.isDouble()) {
			blockstate = blockstate.withProperty(HALF, ((meta&8)!=0)?EnumBlockHalf.TOP:EnumBlockHalf.BOTTOM);
		}

		return blockstate;
	}

	@Override
	public Comparable<?> getTypeForItem(ItemStack stack) {
		// TODO 自動生成されたメソッド・スタブ
		return Dummy.DEFAULT;
	}

	@Override
	public IProperty<?> getVariantProperty() {
		// TODO 自動生成されたメソッド・スタブ
		return DUMMY;
	}

	@Override
	public final int getMetaFromState(final IBlockState state) {
		int meta = 0;

		if(!this.isDouble()&& state.getValue(HALF)==EnumBlockHalf.TOP) {
			meta |= 8;
		}

		return meta;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		if(!this.isDouble()){
			return new BlockStateContainer(this, new IProperty[] {DUMMY, HALF});
		}
		return new BlockStateContainer(this, new IProperty[] {DUMMY});
	}

	//@Override
    //public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    //{
    //}

	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        IBlockState state = super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);

        return state;
    }

	public static enum Dummy implements IStringSerializable
	{
		DEFAULT;

		@Override
		public String getName() {
			// TODO 自動生成されたメソッド・スタブ
			return "default";
		}

	}
}
