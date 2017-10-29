package com.dse.dseMod.mamedol.cg;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Momoka extends MamedolBase{
	public Momoka() {
		super();
		setUnlocalizedName("mamedol_cg_momoka");
		setRegistryName("mamedol_cg_momoka");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/cg/momoka");
	}
}
