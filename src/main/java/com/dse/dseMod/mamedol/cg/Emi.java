package com.dse.dseMod.mamedol.cg;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Emi extends MamedolBase {

	public Emi() {
		super();
		setUnlocalizedName("mamedol_cg_emi");
		setRegistryName("mamedol_cg_emi");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		// TODO 自動生成されたメソッド・スタブ
		return new ModelResourceLocation("dsemod:mamedols/cg/emi");
	}

}
