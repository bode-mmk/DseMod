package com.dse.dseMod.mamedol.ml;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Arisa extends MamedolBase {

	public Arisa() {
		super();
		setUnlocalizedName("mamedol_ml_arisa");
		setRegistryName("mamedol_ml_arisa");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		// TODO 自動生成されたメソッド・スタブ
		return new ModelResourceLocation("dsemod:mamedols/ml/arisa");
	}

}
