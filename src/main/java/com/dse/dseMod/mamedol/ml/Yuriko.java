package com.dse.dseMod.mamedol.ml;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Yuriko extends MamedolBase {

	public Yuriko() {
		super();
		setUnlocalizedName("mamedol_ml_yuriko");
		setRegistryName("mamedol_ml_yuriko");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		// TODO 自動生成されたメソッド・スタブ
		return new ModelResourceLocation("dsemod:mamedols/ml/yuriko");
	}

}
