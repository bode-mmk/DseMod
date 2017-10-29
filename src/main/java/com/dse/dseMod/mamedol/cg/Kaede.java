package com.dse.dseMod.mamedol.cg;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Kaede extends MamedolBase{

	public Kaede() {
		super();
		setUnlocalizedName("mamedol_cg_kaede");
		setRegistryName("mamedol_cg_kaede");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/cg/kaede");
	}
}
