package com.dse.dseMod.mamedol.cg;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Kanako extends MamedolBase{

	public Kanako() {
		super();
		setUnlocalizedName("mamedol_cg_kanako");
		setRegistryName("mamedol_cg_kanako");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/cg/kanako");
	}
	/*
	@Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		if(!worldIn.isRemote && entityIn instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entityIn;
			if(player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() instanceof Kanako ||
					player.getHeldItemOffhand() != null && player.getHeldItemOffhand().getItem() instanceof Kanako
					) {
				player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 50));
			}
		}
    }

	@Override
    public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
    {
		if(!Minecraft.getMinecraft().world.isRemote) {
			Minecraft.getMinecraft().world.createExplosion(player, player.posX, player.posY, player.posZ, 12.0f, true);
		}
        return true;
    }*/
}
