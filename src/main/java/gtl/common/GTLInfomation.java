package gtl.common;

import gregtech.api.unification.material.Materials;
import gregtech.api.util.BaseCreativeTab;
import gregtech.common.items.ToolItems;

import gtl.Tags;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class GTLInfomation {
    public static final String ModID = Tags.MODID;
    public static final String ModName = Tags.MODNAME;
    public static final String Version = Tags.VERSION;

    public static final CreativeTabs CreativeTab = new BaseCreativeTab(ModID + ".main", GTLInfomation::tabIcon, true);

    private static ItemStack tabIcon() { return ToolItems.WRENCH.get(Materials.Neutronium); }

    public static void preInit() {}
}