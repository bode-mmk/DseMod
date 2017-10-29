package com.dse.dseMod.mamedol.cg;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Yuko extends MamedolBase{

	public Yuko() {
		super();
		setUnlocalizedName("mamedol_cg_yuko");
		setRegistryName("mamedol_cg_yuko");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/cg/yuko");
	}
}
