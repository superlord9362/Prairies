package superlord.prairies.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import superlord.prairies.Prairies;

public class PCreativeTabs {
	
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Prairies.MOD_ID);

	public static final RegistryObject<CreativeModeTab> ITEM_GROUP = REGISTRY.register("prairies_item_group", () -> CreativeModeTab.builder().icon(() -> new ItemStack(PBlocks.SHORT_PRAIRIE_TUFTS.get().asItem()))
			.title(Component.translatable("itemGroup.prairies_item_group"))
			.displayItems((pParameters, pOutput) -> {
			}).build());
	
}
