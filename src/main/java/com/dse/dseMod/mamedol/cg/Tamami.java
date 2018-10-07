package com.dse.dseMod.mamedol.cg;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Tamami extends MamedolBase {

	public Tamami() {
		super();
		setUnlocalizedName("mamedol_cg_tamami");
		setRegistryName("mamedol_cg_tamami");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		// TODO 自動生成されたメソッド・スタブ
		return new ModelResourceLocation("dsemod:mamedols/cg/tamami");
	}

}
