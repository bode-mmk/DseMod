package com.dse.dseMod.mamedol.cg;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Kirari extends MamedolBase{

	public Kirari() {
		super();
		setUnlocalizedName("mamedol_cg_kirari");
		setRegistryName("mamedol_cg_kirari");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/cg/kirari");
	}
}
