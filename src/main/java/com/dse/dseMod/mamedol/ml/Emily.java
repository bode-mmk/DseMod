package com.dse.dseMod.mamedol.ml;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Emily extends MamedolBase{

	public Emily() {
		super();
		setUnlocalizedName("mamedol_ml_emily");
		setRegistryName("mamedol_ml_emily");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/ml/emily");
	}
}
