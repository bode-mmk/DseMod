package com.dse.dseMod.mamedol.ml;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Tomoka extends MamedolBase{

	public Tomoka() {
		super();
		setUnlocalizedName("mamedol_ml_tomoka");
		setRegistryName("mamedol_ml_tomoka");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/ml/tomoka");
	}
}
