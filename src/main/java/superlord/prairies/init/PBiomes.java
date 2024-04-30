package superlord.prairies.init;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import superlord.prairies.Prairies;
import superlord.prairies.common.biomes.PrairieBiomeDecorator;

public class PBiomes {
	
	public static final ResourceKey<Biome> PRAIRIES = register("prairies");
	
	public static void bootstrap(BootstapContext<Biome> bootstapContext) {
		HolderGetter<PlacedFeature> holderGetter = bootstapContext.lookup(Registries.PLACED_FEATURE);
		HolderGetter<ConfiguredWorldCarver<?>> holderGetter1 = bootstapContext.lookup(Registries.CONFIGURED_CARVER);
		bootstapContext.register(PRAIRIES, PrairieBiomeDecorator.decoratePrairie(holderGetter, holderGetter1));
	}
	
	private static ResourceKey<Biome> register(String name) {
		return ResourceKey.create(Registries.BIOME, new ResourceLocation(Prairies.MOD_ID, name));
	}

}
