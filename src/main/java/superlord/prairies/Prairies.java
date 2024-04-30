package superlord.prairies;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import superlord.prairies.common.world.PFeatureAndBiomeGenerator;
import superlord.prairies.common.world.PrairieRegionProvider;
import superlord.prairies.init.PBlocks;
import superlord.prairies.init.PCreativeTabs;
import superlord.prairies.init.PItems;
import terrablender.api.Regions;

@Mod(Prairies.MOD_ID)
public class Prairies {

	public static final String MOD_ID = "prairies";
	
	public Prairies() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		bus.addListener(this::setup);
		
		PBlocks.REGISTRY.register(bus);
		PItems.REGISTRY.register(bus);
		PCreativeTabs.REGISTRY.register(bus);

		bus.addListener(this::gatherData);
	}
	
	private void setup(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			Regions.register(new PrairieRegionProvider(new ResourceLocation(MOD_ID, "prairie"), 4));			
		});
	}
	
	public void gatherData(GatherDataEvent event) {
		DataGenerator dataGenerator = event.getGenerator();
		PackOutput packOutput = dataGenerator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		boolean server = event.includeServer();
		dataGenerator.addProvider(server, new PFeatureAndBiomeGenerator(packOutput, lookupProvider));
	}
	
}
