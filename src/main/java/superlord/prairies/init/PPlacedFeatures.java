package superlord.prairies.init;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.NoiseThresholdCountPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import superlord.prairies.Prairies;

public class PPlacedFeatures {
	
	public static final ResourceKey<PlacedFeature> PLACED_SHORT_PRAIRIE_GRASS = registerPlacedFeature("placed_short_prairie_grass");
	public static final ResourceKey<PlacedFeature> PLACED_PRAIRIE_GRASS = registerPlacedFeature("placed_prairie_grass");
	public static final ResourceKey<PlacedFeature> PLACED_SHORT_PRAIRIE_TUFTS = registerPlacedFeature("placed_short_prairie_tufts");
	public static final ResourceKey<PlacedFeature> PLACED_TALL_PRAIRIE_TUFTS = registerPlacedFeature("placed_tall_prairie_tufts");
	public static final ResourceKey<PlacedFeature> PLACED_YELLOW_BLOOMING_SCRUB = registerPlacedFeature("placed_yellow_blooming_scrub");
	public static final ResourceKey<PlacedFeature> PLACED_BLUE_BLOOMING_SCRUB = registerPlacedFeature("placed_blue_blooming_scrub");
	public static final ResourceKey<PlacedFeature> PLACED_RED_BLOOMING_SCRUB = registerPlacedFeature("placed_red_blooming_scrub");

	public static void bootstrap(BootstapContext<PlacedFeature> bootstapContext) {
		HolderGetter<ConfiguredFeature<?, ?>> holderGetter = bootstapContext.lookup(Registries.CONFIGURED_FEATURE);
		PlacementUtils.register(bootstapContext, PLACED_SHORT_PRAIRIE_GRASS, holderGetter.getOrThrow(PFeatures.SHORT_PRAIRIE_GRASS), NoiseThresholdCountPlacement.of(-0.8D, 15, 15), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
		PlacementUtils.register(bootstapContext, PLACED_PRAIRIE_GRASS, holderGetter.getOrThrow(PFeatures.PRAIRIE_GRASS), NoiseThresholdCountPlacement.of(-0.8D, 15, 15), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
		PlacementUtils.register(bootstapContext, PLACED_SHORT_PRAIRIE_TUFTS, holderGetter.getOrThrow(PFeatures.SHORT_PRAIRIE_TUFT), NoiseThresholdCountPlacement.of(-0.8D, 15, 15), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
		PlacementUtils.register(bootstapContext, PLACED_TALL_PRAIRIE_TUFTS, holderGetter.getOrThrow(PFeatures.TALL_PRAIRIE_TUFT), NoiseThresholdCountPlacement.of(-0.8D, 15, 15), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
		PlacementUtils.register(bootstapContext, PLACED_YELLOW_BLOOMING_SCRUB, holderGetter.getOrThrow(PFeatures.YELLOW_BLOOMING_SCRUB), NoiseThresholdCountPlacement.of(-0.8D, 15, 4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
		PlacementUtils.register(bootstapContext, PLACED_BLUE_BLOOMING_SCRUB, holderGetter.getOrThrow(PFeatures.BLUE_BLOOMING_SCRUB), NoiseThresholdCountPlacement.of(-0.8D, 15, 4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
		PlacementUtils.register(bootstapContext, PLACED_RED_BLOOMING_SCRUB, holderGetter.getOrThrow(PFeatures.RED_BLOOMING_SCRUB), NoiseThresholdCountPlacement.of(-0.8D, 15, 4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
	}

	public static ResourceKey<PlacedFeature> registerPlacedFeature(String id) {
		return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Prairies.MOD_ID, id));
	}

}
