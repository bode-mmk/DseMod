package com.dse.dseMod.mamedol;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

abstract public class MamedolBase extends Item {
	public MamedolBase() {
		this.setCreativeTab(CreativeTabs.MISC);
		this.setMaxStackSize(64);
	}

	abstract public ModelResourceLocation getModelResourceLocation();
}
