package com.dse.dseMod.mamedol.cg;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Sae extends MamedolBase{

	public Sae() {
		super();
		setUnlocalizedName("mamedol_cg_sae");
		setRegistryName("mamedol_cg_sae");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/cg/sae");
	}

	/*
	@Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		if(!worldIn.isRemote && entityIn instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entityIn;
			if(player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() instanceof Sae ||
					player.getHeldItemOffhand() != null && player.getHeldItemOffhand().getItem() instanceof Sae
					) {
				player.addPotionEffect(new PotionEffect(DseMod.potion_hannari, 50));
			}
		}
    }*/
}
