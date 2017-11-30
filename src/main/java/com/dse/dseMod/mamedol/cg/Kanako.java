package com.dse.dseMod.mamedol.cg;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Kanako extends MamedolBase{

	public Kanako() {
		super();
		setUnlocalizedName("mamedol_cg_kanako");
		setRegistryName("mamedol_cg_kanako");
		this.setMaxDamage(2);
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/cg/kanako");
	}

    /**
     * Called when a Block is destroyed using this Item. Return true to trigger the "Use Item" statistic.
     */
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
        if (!worldIn.isRemote && (double)state.getBlockHardness(worldIn, pos) != 0.0D)
        {
           // stack.damageItem(1, entityLiving);
            //this.decreaseStamina(stack, 1);
        }

        return true;
    }

	@Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		if(!worldIn.isRemote && entityIn instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entityIn;

			if(player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() instanceof Kanako ||
					player.getHeldItemOffhand() != null && player.getHeldItemOffhand().getItem() instanceof Kanako
						) {
				// プレイヤーの空腹度が20を切った時
				// スタミナ1につき
				if(player.getFoodStats().getFoodLevel() < 20) {
					if(this.decreaseStamina(stack, 1)) {
						this.increaseLikability(stack, 1);
						player.getFoodStats().addStats(1, 0.0f);
					}
				}
			}
		}
    }

	/*
	@Override
    public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
    {
		if(!Minecraft.getMinecraft().world.isRemote) {
			Minecraft.getMinecraft().world.createExplosion(player, player.posX, player.posY, player.posZ, 12.0f, true);
		}
        return true;
    }*/
}
