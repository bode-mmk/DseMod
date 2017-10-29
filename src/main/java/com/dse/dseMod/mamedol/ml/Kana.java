package com.dse.dseMod.mamedol.ml;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Kana extends MamedolBase{

	public Kana() {
		super();
		setUnlocalizedName("mamedol_ml_kana");
		setRegistryName("mamedol_ml_kana");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/ml/kana");
	}
}
