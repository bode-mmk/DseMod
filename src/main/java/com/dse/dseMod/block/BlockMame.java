package com.dse.dseMod.block;

import com.dse.dseMod.DseMod;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

public class BlockMame extends BlockCrops{
	public BlockMame() {
	}

	//@Override
	protected Item getSeed() {
		return DseMod.ITEMS.mamedol_seeds;
	}

	//@Override
	protected Item getCrop() {
		return DseMod.ITEMS.mamedol_seeds;
	}

    @Override
    public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        super.getDrops(drops, world, pos, state, fortune);
        if (this.isMaxAge(state) && RANDOM.nextInt(100) == 0)
            drops.add(new ItemStack(DseMod.ITEMS.mamedol_egg));
    }
}
