package com.dse.dseMod.mamedol.cg;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Lyla extends MamedolBase{

	public Lyla() {
		super();
		setUnlocalizedName("mamedol_cg_lyla");
		setRegistryName("mamedol_cg_lyla");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/cg/lyla");
	}
}
