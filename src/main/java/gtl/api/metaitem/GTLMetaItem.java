package gtl.api.metaitem;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.StandardMetaItem;

import gregtech.api.items.metaitem.stats.IItemComponent;
import gregtech.common.items.behaviors.TooltipBehavior;
import gtl.api.util.GTLUtil;
import gtl.common.GTLInfomation;

import net.minecraft.item.EnumRarity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;

public class GTLMetaItem extends StandardMetaItem {
    private GTLMetaItem() {
        super(metaId);
        if (subItemId > 32766) {
            resetSubId();
            metaId++;
        }

        metaItems[metaId] = new StandardMetaItem(metaId);
        metaItems[metaId].setRegistryName(GTLUtil.toGTLName("meta_item" + metaId));
        metaItems[metaId].setCreativeTab(GTLInfomation.CreativeTab);
    }

    //range from metaId 1-32767
    @SuppressWarnings("unchecked")
    public static <T extends MetaItem<?>.MetaValueItem> T addItem(
            @NotNull String unlocalizedName,
            EnumRarity rarity,
            int stackSize,
            IItemComponent... stats)
    {
        if (metaItems[metaId] == null) {
            resetSubId();
            metaItems[metaId] = new GTLMetaItem();
        }
        
        advanceSubId();
        if (subItemId > Short.MAX_VALUE - 1) initNewMetaItem();

        return (T) metaItems[metaId].addItem(subItemId, unlocalizedName)
                .setRarity(rarity)
                .setMaxStackSize(stackSize)
                .addComponents(stats);
    }

    public static <T extends MetaItem<?>.MetaValueItem> T addItem(@NotNull String unlocalizedName, EnumRarity rarity, int stackSize, @Nullable String[] tooltips) {
        return addItem(
                unlocalizedName,
                rarity,
                stackSize,
                new TooltipBehavior((lines) -> Collections.addAll(lines, tooltips))
        );
    }

    public static <T extends MetaItem<?>.MetaValueItem> T addItem(@NotNull String unlocalizedName, EnumRarity rarity, int stackSize) { return addItem(unlocalizedName, rarity, stackSize, new IItemComponent[] {}); }
    public static <T extends MetaItem<?>.MetaValueItem> T addItem(@NotNull String unlocalizedName, EnumRarity rarity) { return addItem(unlocalizedName, rarity, 64); }
    public static <T extends MetaItem<?>.MetaValueItem> T addItem(@NotNull String unlocalizedName) { return addItem(unlocalizedName, EnumRarity.COMMON); }

    //readability
    private static void advanceSubId() { subItemId++; }
    private static void resetSubId() { subItemId = 1; }
        //initialize new metaitem on next available id
    private static void initNewMetaItem() { metaItems[++metaId] = new GTLMetaItem(); }

    private static short subItemId = 1;
    private static short metaId = 0;
    private static StandardMetaItem[] metaItems;
}