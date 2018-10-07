package com.dse.dseMod.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemStack;

public class MamedolSeedsIrimame extends ItemSeedFood {
	public MamedolSeedsIrimame(int healAmount, float saturation, Block crops, Block soil) {
		super(healAmount, saturation, crops, soil);
	}

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 16;
    }
}
