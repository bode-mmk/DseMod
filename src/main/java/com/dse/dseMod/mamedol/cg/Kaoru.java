package com.dse.dseMod.mamedol.cg;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Kaoru extends MamedolBase{

	public Kaoru() {
		super();
		setUnlocalizedName("mamedol_cg_kaoru");
		setRegistryName("mamedol_cg_kaoru");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/cg/kaoru");
	}
}
