package com.dse.dseMod.mamedol.ml;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Momoko extends MamedolBase {

	public Momoko() {
		super();
		setUnlocalizedName("mamedol_ml_momoko");
		setRegistryName("mamedol_ml_momoko");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		// TODO 自動生成されたメソッド・スタブ
		return new ModelResourceLocation("dsemod:mamedols/ml/momoko");
	}

}
