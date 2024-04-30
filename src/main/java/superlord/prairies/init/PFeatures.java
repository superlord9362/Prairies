package superlord.prairies.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import superlord.prairies.Prairies;

public class PFeatures {
	
	public static final ResourceKey<ConfiguredFeature<?, ?>> SHORT_PRAIRIE_GRASS = registerConfiguredFeature("short_prairie_grass");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PRAIRIE_GRASS = registerConfiguredFeature("prairie_grass");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SHORT_PRAIRIE_TUFT = registerConfiguredFeature("short_prairie_tuft");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_PRAIRIE_TUFT = registerConfiguredFeature("tall_prairie_tuft");
	public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_BLOOMING_SCRUB = registerConfiguredFeature("yellow_blooming_scrub");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_BLOOMING_SCRUB = registerConfiguredFeature("blue_blooming_scrub");
	public static final ResourceKey<ConfiguredFeature<?, ?>> RED_BLOOMING_SCRUB = registerConfiguredFeature("red_blooming_scrub");

	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> bootstapContext) {
		FeatureUtils.register(bootstapContext, SHORT_PRAIRIE_GRASS, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PBlocks.SHORT_PRAIRIE_GRASS.get()), 32));
		FeatureUtils.register(bootstapContext, PRAIRIE_GRASS, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PBlocks.PRAIRIE_GRASS.get()), 32));
		FeatureUtils.register(bootstapContext, SHORT_PRAIRIE_TUFT, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PBlocks.SHORT_PRAIRIE_TUFTS.get()), 32));
		FeatureUtils.register(bootstapContext, TALL_PRAIRIE_TUFT, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PBlocks.TALL_PRAIRIE_TUFTS.get()), 32));
		FeatureUtils.register(bootstapContext, YELLOW_BLOOMING_SCRUB, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PBlocks.YELLOW_BLOOMING_SCRUB.get()), 32));
		FeatureUtils.register(bootstapContext, BLUE_BLOOMING_SCRUB, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PBlocks.BLUE_BLOOMING_SCRUB.get()), 32));
		FeatureUtils.register(bootstapContext, RED_BLOOMING_SCRUB, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PBlocks.RED_BLOOMING_SCRUB.get()), 32));
	}
	
	private static RandomPatchConfiguration grassPatch(BlockStateProvider p_195203_, int p_195204_) {
        return FeatureUtils.simpleRandomPatchConfiguration(p_195204_, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(p_195203_)));
     }
    
    public static ResourceKey<ConfiguredFeature<?, ?>> registerConfiguredFeature(String id) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Prairies.MOD_ID, id));
	}
	
}
