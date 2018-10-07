package com.dse.dseMod.mamedol.ml;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Matsuri extends MamedolBase {

	public Matsuri() {
		super();
		setUnlocalizedName("mamedol_ml_matsuri");
		setRegistryName("mamedol_ml_matsuri");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		// TODO 自動生成されたメソッド・スタブ
		return new ModelResourceLocation("dsemod:mamedols/ml/matsuri");
	}

}
