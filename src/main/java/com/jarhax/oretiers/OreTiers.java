package com.jarhax.oretiers;

import org.apache.logging.log4j.Logger;

import com.jarhax.oretiers.proxy.ProxyCommon;

import net.darkhax.bookshelf.network.NetworkHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "oretiers", name = "Ore Tiers", version = "@VERSION@", dependencies = "required-after:bookshelf@[1.5.0.370,);required-after:crafttweaker@[3.0.23,)")
public class OreTiers {

    @SidedProxy(clientSide = "com.jarhax.oretiers.proxy.ProxyClient", serverSide = "com.jarhax.oretiers.proxy.ProxyCommon")
    public static ProxyCommon proxy;

    public static NetworkHandler network = new NetworkHandler("oretiers");
    public static Logger log;

    @Mod.EventHandler
    public void preInit (FMLPreInitializationEvent ev) {

        log = ev.getModLog();

        proxy.onPreInit();
    }

    @Mod.EventHandler
    public void init (FMLInitializationEvent ev) {

        proxy.onInit();
    }

    @Mod.EventHandler
    public void postInit (FMLPostInitializationEvent ev) {

        proxy.onPostInit();
    }
}
