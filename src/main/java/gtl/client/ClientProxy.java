package gtl.client;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import gtl.common.CommonProxy;
import gtl.Tags;

import org.jetbrains.annotations.NotNull;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = Tags.MODID, value = Side.CLIENT)
public class ClientProxy extends CommonProxy {
    public void onPreInit() {
        super.onPreInit();
    }

    public void onInit() {
        super.onInit();
    }

    @SubscribeEvent
    public static void registerModels(@NotNull ModelRegistryEvent event) {}
}