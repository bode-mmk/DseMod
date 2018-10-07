package com.dse.dseMod.mamedol.cg;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Ayame extends MamedolBase {

	public Ayame() {
		super();
		setUnlocalizedName("mamedol_cg_ayame");
		setRegistryName("mamedol_cg_ayame");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/cg/ayame");
	}
}
