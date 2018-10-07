package com.dse.dseMod.mamedol.ml;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Anna extends MamedolBase {

	public Anna() {
		super();
		setUnlocalizedName("mamedol_ml_anna");
		setRegistryName("mamedol_ml_anna");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		// TODO 自動生成されたメソッド・スタブ
		return new ModelResourceLocation("dsemod:mamedols/ml/anna");
	}

}
