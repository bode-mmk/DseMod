package com.dse.dseMod.proxy;

import com.dse.dseMod.DseMod;
import com.dse.dseMod.event.MobDropsHandler;
import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new MobDropsHandler());
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
	}

	// set mamedols resource
	private static void setMamedolResource(Item mamedol) {
		ModelLoader.setCustomModelResourceLocation(mamedol, 0, ((MamedolBase)mamedol).getModelResourceLocation());
	}

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
		// mamedols resource set
    	setMamedolResource(DseMod.MAMEDOLS.as_azusa);
    	setMamedolResource(DseMod.MAMEDOLS.as_hibiki);
    	setMamedolResource(DseMod.MAMEDOLS.as_iori);
		setMamedolResource(DseMod.MAMEDOLS.as_yayoi);
		setMamedolResource(DseMod.MAMEDOLS.as_yukiho);

		setMamedolResource(DseMod.MAMEDOLS.cg_anzu);
		setMamedolResource(DseMod.MAMEDOLS.cg_ayame);
		setMamedolResource(DseMod.MAMEDOLS.cg_chieri);
		setMamedolResource(DseMod.MAMEDOLS.cg_clarice);
		setMamedolResource(DseMod.MAMEDOLS.cg_emi);
		setMamedolResource(DseMod.MAMEDOLS.cg_kaede);
		setMamedolResource(DseMod.MAMEDOLS.cg_kanako);
		setMamedolResource(DseMod.MAMEDOLS.cg_kaoru);
		setMamedolResource(DseMod.MAMEDOLS.cg_karin);
		setMamedolResource(DseMod.MAMEDOLS.cg_kirari);
		setMamedolResource(DseMod.MAMEDOLS.cg_lyla);
		setMamedolResource(DseMod.MAMEDOLS.cg_miku);
		setMamedolResource(DseMod.MAMEDOLS.cg_momoka);
		setMamedolResource(DseMod.MAMEDOLS.cg_nanami);
		setMamedolResource(DseMod.MAMEDOLS.cg_natsuki);
		setMamedolResource(DseMod.MAMEDOLS.cg_nina);
		setMamedolResource(DseMod.MAMEDOLS.cg_sachiko);
		setMamedolResource(DseMod.MAMEDOLS.cg_sae);
		setMamedolResource(DseMod.MAMEDOLS.cg_syuko);
		setMamedolResource(DseMod.MAMEDOLS.cg_takumi);
		setMamedolResource(DseMod.MAMEDOLS.cg_tamami);
		setMamedolResource(DseMod.MAMEDOLS.cg_yoshino);
		setMamedolResource(DseMod.MAMEDOLS.cg_yuko);

		setMamedolResource(DseMod.MAMEDOLS.ml_anna);
		setMamedolResource(DseMod.MAMEDOLS.ml_arisa);
		setMamedolResource(DseMod.MAMEDOLS.ml_emily);
		setMamedolResource(DseMod.MAMEDOLS.ml_iku);
		setMamedolResource(DseMod.MAMEDOLS.ml_kana);
		setMamedolResource(DseMod.MAMEDOLS.ml_matsuri);
		setMamedolResource(DseMod.MAMEDOLS.ml_momoko);
		setMamedolResource(DseMod.MAMEDOLS.ml_serika);
		setMamedolResource(DseMod.MAMEDOLS.ml_tomoka);
		setMamedolResource(DseMod.MAMEDOLS.ml_yuriko);

		// items resouce set
		ModelLoader.setCustomModelResourceLocation(DseMod.ITEMS.dsecart, 0, new ModelResourceLocation("dsemod:dsecart"));
		ModelLoader.setCustomModelResourceLocation(DseMod.ITEMS.mamedol_egg, 0, new ModelResourceLocation("dsemod:mamedol_egg"));
		ModelLoader.setCustomModelResourceLocation(DseMod.ITEMS.mamedol_seeds, 0, new ModelResourceLocation("dsemod:mamedol_seeds"));
		ModelLoader.setCustomModelResourceLocation(DseMod.ITEMS.mamedol_seeds_irimame, 0, new ModelResourceLocation("dsemod:mamedol_seeds_irimame"));

		ModelLoader.setCustomModelResourceLocation(DseMod.IMAS_RECORDS.ankirakyousoukyoku, 0, new ModelResourceLocation("dsemod:imas_records/ankirakyousoukyoku"));
		ModelLoader.setCustomModelResourceLocation(DseMod.IMAS_RECORDS.sakuranokoro, 0, new ModelResourceLocation("dsemod:imas_records/sakuranokoro"));

    }
}
