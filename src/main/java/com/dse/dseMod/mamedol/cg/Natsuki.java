package com.dse.dseMod.mamedol.cg;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Natsuki extends MamedolBase{

	public Natsuki() {
		super();
		setUnlocalizedName("mamedol_cg_natsuki");
		setRegistryName("mamedol_cg_natsuki");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/cg/natsuki");
	}
}
