package com.dse.dseMod.mamedol.cg;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Nina extends MamedolBase{

	public Nina() {
		super();
		setUnlocalizedName("mamedol_cg_nina");
		setRegistryName("mamedol_cg_nina");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/cg/nina");
	}
}
