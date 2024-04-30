package superlord.prairies.common.world;

import java.util.function.Consumer;

import com.mojang.datafixers.util.Pair;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import superlord.prairies.init.PBiomes;
import terrablender.api.ParameterUtils.Continentalness;
import terrablender.api.ParameterUtils.Depth;
import terrablender.api.ParameterUtils.Erosion;
import terrablender.api.ParameterUtils.Humidity;
import terrablender.api.ParameterUtils.ParameterPointListBuilder;
import terrablender.api.ParameterUtils.Temperature;
import terrablender.api.ParameterUtils.Weirdness;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;


public class PrairieRegionProvider extends Region {
	public static final ResourceLocation LOCATION = new ResourceLocation("minecraft:overworld");
	
	public PrairieRegionProvider(ResourceLocation name, int weight) {
		super(name, RegionType.OVERWORLD, weight);
	}
	
	@Override
	public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
		VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
		
		new ParameterPointListBuilder()
			.temperature(Temperature.WARM)
			.humidity(Humidity.DRY)
			.continentalness(Continentalness.span(Continentalness.INLAND, Continentalness.FAR_INLAND))
			.erosion(Erosion.EROSION_0, Erosion.EROSION_1, Erosion.EROSION_2)
			.depth(Depth.SURFACE, Depth.FLOOR)
			.weirdness(Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.MID_SLICE_NORMAL_DESCENDING)
			.build().forEach(point -> builder.add(point, PBiomes.PRAIRIES));

        builder.build().forEach(mapper);
	}

}
