package com.dse.dseMod.mamedol.cg;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Syuko extends MamedolBase{

	public Syuko() {
		super();
		setUnlocalizedName("mamedol_cg_syuko");
		setRegistryName("mamedol_cg_syuko");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/cg/syuko");
	}
}
