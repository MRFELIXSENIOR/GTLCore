package gtl;

import gregtech.api.unification.material.Materials;
import gregtech.api.util.BaseCreativeTab;
import gregtech.common.items.MetaItems;
import gregtech.common.items.ToolItems;
import gtl.common.GTLInfomation;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import gtl.common.CommonProxy;

import org.jetbrains.annotations.NotNull;

@Mod(   modid = GTLInfomation.ModID,
        name = GTLInfomation.ModName,
        version = GTLInfomation.Version)
public class GTLCore {
    @SidedProxy(
            modId = GTLInfomation.ModID,
            clientSide = "gtl.client.ClientProxy",
            serverSide = "gtl.common.CommonProxy"
    )
    public static CommonProxy commonProxy;

    @EventHandler
    public void onConstruction(@NotNull FMLConstructionEvent event) {

    }

    @EventHandler
    public void onPreInit(@NotNull FMLPreInitializationEvent event) {

    }

    @EventHandler
    public void onInit(@NotNull FMLInitializationEvent event) {

    }

    @EventHandler
    public void onPostInit(@NotNull FMLPostInitializationEvent event) {

    }
}