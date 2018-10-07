package com.dse.dseMod.mamedol.ml;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Serika extends MamedolBase {

	public Serika() {
		super();
		setUnlocalizedName("mamedol_ml_serika");
		setRegistryName("mamedol_ml_serika");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		// TODO 自動生成されたメソッド・スタブ
		return new ModelResourceLocation("dsemod:mamedols/ml/serika");
	}

}
