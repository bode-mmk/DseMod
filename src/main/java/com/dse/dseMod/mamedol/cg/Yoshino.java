package com.dse.dseMod.mamedol.cg;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Yoshino extends MamedolBase{

	public Yoshino() {
		super();
		setUnlocalizedName("mamedol_cg_yoshino");
		setRegistryName("mamedol_cg_yoshino");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/cg/yoshino");
	}
}
