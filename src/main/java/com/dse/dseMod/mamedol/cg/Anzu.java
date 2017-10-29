package com.dse.dseMod.mamedol.cg;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Anzu extends MamedolBase{

	public Anzu() {
		super();
		setUnlocalizedName("mamedol_cg_anzu");
		setRegistryName("mamedol_cg_anzu");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/cg/anzu");
	}
}
