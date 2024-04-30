package superlord.prairies.common.world;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import superlord.prairies.Prairies;
import superlord.prairies.init.PBiomes;
import superlord.prairies.init.PFeatures;
import superlord.prairies.init.PPlacedFeatures;

public class PFeatureAndBiomeGenerator extends DatapackBuiltinEntriesProvider {
	
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ctx -> PFeatures.bootstrap(ctx))
            .add(Registries.PLACED_FEATURE, PPlacedFeatures::bootstrap)
            .add(Registries.BIOME, PBiomes::bootstrap);

    public PFeatureAndBiomeGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Prairies.MOD_ID));
    }

}