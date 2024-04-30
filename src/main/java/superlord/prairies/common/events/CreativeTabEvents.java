package superlord.prairies.common.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.prairies.Prairies;
import superlord.prairies.init.PBlocks;
import superlord.prairies.init.PCreativeTabs;

@Mod.EventBusSubscriber(modid = Prairies.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CreativeTabEvents {

	@SubscribeEvent
	public static void buildContents(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == PCreativeTabs.ITEM_GROUP.getKey()) {
			event.accept(PBlocks.BLUE_BLOOMING_SCRUB.get().asItem());
			event.accept(PBlocks.RED_BLOOMING_SCRUB.get().asItem());
			event.accept(PBlocks.YELLOW_BLOOMING_SCRUB.get().asItem());
			event.accept(PBlocks.SHORT_PRAIRIE_GRASS.get().asItem());
			event.accept(PBlocks.PRAIRIE_GRASS.get().asItem());
			event.accept(PBlocks.SHORT_PRAIRIE_TUFTS.get().asItem());
			event.accept(PBlocks.TALL_PRAIRIE_TUFTS.get().asItem());
		}
	}
	
}
