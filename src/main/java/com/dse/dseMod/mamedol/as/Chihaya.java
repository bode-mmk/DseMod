package com.dse.dseMod.mamedol.as;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Chihaya extends MamedolBase {
	public Chihaya() {
		super();
		setUnlocalizedName("mamedol_as_chihaya");
		setRegistryName("mamedol_as_chihaya");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		// TODO 自動生成されたメソッド・スタブ
		return new ModelResourceLocation("dsemod:mamedols/as/chihaya");
	}

}
