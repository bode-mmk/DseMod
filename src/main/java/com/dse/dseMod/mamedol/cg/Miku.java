package com.dse.dseMod.mamedol.cg;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Miku extends MamedolBase {

	public Miku() {
		super();
		setUnlocalizedName("mamedol_cg_miku");
		setRegistryName("mamedol_cg_miku");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		// TODO 自動生成されたメソッド・スタブ
		return new ModelResourceLocation("dsemod:mamedols/cg/miku");
	}

}
