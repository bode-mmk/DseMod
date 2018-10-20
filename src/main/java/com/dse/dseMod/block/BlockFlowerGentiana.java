package com.dse.dseMod.block;

import java.util.Random;

import com.dse.dseMod.DseMod;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFlowerGentiana extends BlockCrops{
	public static final PropertyInteger FLOWER_AGE = PropertyInteger.create("age", 0, 1);
	private static final AxisAlignedBB[] FLOWER_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.15D, 0.0D, 0.15D, 0.85D, 0.8D, 0.85D), new AxisAlignedBB(0.15D, 0.0D, 0.15D, 0.85D, 0.8D, 0.85D)};
	private static final int MORNING_TICK_TIME = 1000;
	private static final int NIGHT_TICK_TIME = 12517;

	public BlockFlowerGentiana() {
		super();
	}

	// 積み上げられるかどうか
	@Override
	protected boolean canSustainBush(IBlockState state) {
		return false;
	}

	@Override
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
		return true;
	}

	@Override
	protected PropertyInteger getAgeProperty() {
		return FLOWER_AGE;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FLOWER_AGE});
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos ) {
		return FLOWER_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
	}

	@Override
	public int getMaxAge() {
		return 1;
	}

	@Override
	public boolean isMaxAge(IBlockState state) {
		return true;
	}

	@Override
	//public void updateTick(World worldIn,BlockPos pos, IBlockState state, Random rand) {
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand){
		long time = worldIn.getWorldTime();
		if(BlockFlowerGentiana.MORNING_TICK_TIME < time && time < BlockFlowerGentiana.NIGHT_TICK_TIME) {
			// 朝は花開き
			worldIn.setBlockState(pos,  this.withAge(1), 2);
		}else {
			// 夜は閉じる
			worldIn.setBlockState(pos,  this.withAge(0), 2);
		}
	}

	@Override
	public int tickRate(World worldIn) {
		return 7000;
	}

	@Override
	public void grow(World worldIn, BlockPos pos, IBlockState state) {
		// 成長は何もしない
	}

	@Override
	public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		drops.add(new ItemStack(DseMod.BLOCK_ITEMS.flower_gentiala_tile_item, 1, 0));
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return false;
	}
}
