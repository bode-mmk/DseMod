package com.dse.dseMod.mamedol.cg;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Takumi extends MamedolBase{

	public Takumi() {
		super();
		setUnlocalizedName("mamedol_cg_takumi");
		setRegistryName("mamedol_cg_takumi");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/cg/takumi");
	}
}
