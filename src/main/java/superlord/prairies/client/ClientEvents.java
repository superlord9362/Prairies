package superlord.prairies.client;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import superlord.prairies.Prairies;
import superlord.prairies.init.PBlocks;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = Prairies.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
	
	@SubscribeEvent
	public static void init(final FMLClientSetupEvent event) {
		setupBlockRenders();
	}
	
	@SuppressWarnings("deprecation")
	public static void setupBlockRenders() {
		RenderType cutoutRenderType = RenderType.cutout();
		ItemBlockRenderTypes.setRenderLayer(PBlocks.BLUE_BLOOMING_SCRUB.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PBlocks.RED_BLOOMING_SCRUB.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PBlocks.YELLOW_BLOOMING_SCRUB.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PBlocks.PRAIRIE_GRASS.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PBlocks.SHORT_PRAIRIE_GRASS.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PBlocks.SHORT_PRAIRIE_TUFTS.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PBlocks.TALL_PRAIRIE_TUFTS.get(), cutoutRenderType);
	}

}
