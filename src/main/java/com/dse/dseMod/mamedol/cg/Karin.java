package com.dse.dseMod.mamedol.cg;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Karin extends MamedolBase{

	public Karin() {
		super();
		setUnlocalizedName("mamedol_cg_karin");
		setRegistryName("mamedol_cg_karin");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/cg/karin");
	}
}
