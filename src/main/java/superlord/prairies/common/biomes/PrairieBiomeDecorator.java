package superlord.prairies.common.biomes;

import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import superlord.prairies.init.PPlacedFeatures;

public class PrairieBiomeDecorator {

	private static Biome biome(boolean hasPrecipitation, float temperature, float downfall, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder) {
		return (new Biome.BiomeBuilder())
				.hasPrecipitation(hasPrecipitation)
				.temperature(temperature)
				.downfall(downfall)
				.specialEffects((new BiomeSpecialEffects.Builder())
						.waterColor(0x8C8E9A)
						.waterFogColor(0x7A7883)
						.fogColor(0x92AEBA)
						.skyColor(0xA4BFC8)
						.grassColorOverride(0xEDBD00)
						//D1A800 is 1st screenshot
						//D3D300 is 2nd screenshot
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
						.build())
				.mobSpawnSettings(spawnBuilder.build())
				.generationSettings(biomeBuilder.build())
				.build();
	}

	public static Biome decoratePrairie(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		globalOverworldGeneration(biomeFeatures);
		prairieGeneration(biomeFeatures);
		spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
		spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
		spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
		spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
		spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
		spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
		return biome(true, 0.8F, 0.3F, spawnSettings, biomeFeatures);
	}

	private static void globalOverworldGeneration(BiomeGenerationSettings.Builder p_194870_) {
		BiomeDefaultFeatures.addDefaultCarversAndLakes(p_194870_);
		BiomeDefaultFeatures.addDefaultCrystalFormations(p_194870_);
		BiomeDefaultFeatures.addDefaultMonsterRoom(p_194870_);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(p_194870_);
		BiomeDefaultFeatures.addDefaultSprings(p_194870_);
		BiomeDefaultFeatures.addSurfaceFreezing(p_194870_);
	}
	
	private static void prairieGeneration(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PPlacedFeatures.PLACED_PRAIRIE_GRASS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PPlacedFeatures.PLACED_SHORT_PRAIRIE_GRASS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PPlacedFeatures.PLACED_SHORT_PRAIRIE_TUFTS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PPlacedFeatures.PLACED_TALL_PRAIRIE_TUFTS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PPlacedFeatures.PLACED_BLUE_BLOOMING_SCRUB);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PPlacedFeatures.PLACED_YELLOW_BLOOMING_SCRUB);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PPlacedFeatures.PLACED_RED_BLOOMING_SCRUB);
	}

}
