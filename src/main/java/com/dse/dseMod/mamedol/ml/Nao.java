package com.dse.dseMod.mamedol.ml;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Nao extends MamedolBase {

	public Nao() {
		super();
		setUnlocalizedName("mamedol_ml_nao");
		setRegistryName("mamedol_ml_nao");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		// TODO 自動生成されたメソッド・スタブ
		return new ModelResourceLocation("dsemod:mamedols/ml/nao");
	}

}
