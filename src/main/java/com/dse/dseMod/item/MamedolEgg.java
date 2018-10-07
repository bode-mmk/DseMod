package com.dse.dseMod.item;

import java.util.Random;

import com.dse.dseMod.DseMod;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class MamedolEgg extends ItemEgg{
	private Random rnd;

	public MamedolEgg() {
		super();
		rnd = new Random();
	}

	@Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
		Item list[] =
			{
				DseMod.MAMEDOLS.as_azusa,
				DseMod.MAMEDOLS.as_hibiki,
				DseMod.MAMEDOLS.as_iori,
				DseMod.MAMEDOLS.as_yayoi,
				DseMod.MAMEDOLS.as_yukiho,

				DseMod.MAMEDOLS.cg_anzu,
				DseMod.MAMEDOLS.cg_ayame,
				DseMod.MAMEDOLS.cg_chieri,
				DseMod.MAMEDOLS.cg_emi,
				DseMod.MAMEDOLS.cg_kaede,
				DseMod.MAMEDOLS.cg_kanako,
				DseMod.MAMEDOLS.cg_kaoru,
				DseMod.MAMEDOLS.cg_karin,
				DseMod.MAMEDOLS.cg_kirari,
				DseMod.MAMEDOLS.cg_lyla,
				DseMod.MAMEDOLS.cg_miku,
				DseMod.MAMEDOLS.cg_momoka,
				DseMod.MAMEDOLS.cg_nanami,
				DseMod.MAMEDOLS.cg_natsuki,
				DseMod.MAMEDOLS.cg_nina,
				DseMod.MAMEDOLS.cg_sachiko,
				DseMod.MAMEDOLS.cg_sae,
				DseMod.MAMEDOLS.cg_syuko,
				DseMod.MAMEDOLS.cg_takumi,
				DseMod.MAMEDOLS.cg_tamami,
				DseMod.MAMEDOLS.cg_yoshino,
				DseMod.MAMEDOLS.cg_yuko,

				DseMod.MAMEDOLS.ml_anna,
				DseMod.MAMEDOLS.ml_arisa,
				DseMod.MAMEDOLS.ml_emily,
				DseMod.MAMEDOLS.ml_iku,
				DseMod.MAMEDOLS.ml_kana,
				DseMod.MAMEDOLS.ml_matsuri,
				DseMod.MAMEDOLS.ml_momoko,
				DseMod.MAMEDOLS.ml_serika,
				DseMod.MAMEDOLS.ml_tomoka,
				DseMod.MAMEDOLS.ml_yuriko
			};

		ItemStack itemstack = playerIn.getHeldItem(handIn);
		itemstack.shrink(1);

		worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if(!worldIn.isRemote) {
			Item item = list[rnd.nextInt(list.length)];
			ItemStack drop_item_stack =  new ItemStack(item);
			EntityItem entityitem = new EntityItem(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ,  drop_item_stack);

			if(drop_item_stack.hasTagCompound()) {
				entityitem.getItem().setTagCompound((NBTTagCompound)drop_item_stack.getTagCompound().copy());
			}

			entityitem.setLocationAndAngles(playerIn.posX, playerIn.posY,playerIn.posZ, 1.0F, 0.0F);
			entityitem.setDefaultPickupDelay();
			if(worldIn.spawnEntity(entityitem)) {
				System.out.println("spawn ok");
			}
		}

		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
}
