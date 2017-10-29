package com.dse.dseMod.mamedol.ml;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Iku extends MamedolBase{

	public Iku() {
		super();
		setUnlocalizedName("mamedol_ml_iku");
		setRegistryName("mamedol_ml_iku");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/ml/iku");
	}
}
