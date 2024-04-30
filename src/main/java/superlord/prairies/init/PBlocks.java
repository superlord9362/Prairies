package superlord.prairies.init;

import java.util.function.BiFunction;
import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.prairies.Prairies;
import superlord.prairies.common.blocks.BloomingScrubBlock;
import superlord.prairies.common.blocks.PrairieGrassBlock;
import superlord.prairies.common.blocks.ShortPrairieGrassBlock;
import superlord.prairies.common.blocks.ShortPrairieTuftsBlock;

public class PBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, Prairies.MOD_ID);

	public static final RegistryObject<Block> YELLOW_BLOOMING_SCRUB = add("yellow_blooming_scrub", () -> new BloomingScrubBlock(BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)), new Item.Properties());
	public static final RegistryObject<Block> BLUE_BLOOMING_SCRUB = add("blue_blooming_scrub", () -> new BloomingScrubBlock(BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)), new Item.Properties());
	public static final RegistryObject<Block> RED_BLOOMING_SCRUB = add("red_blooming_scrub", () -> new BloomingScrubBlock(BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)), new Item.Properties());

	public static final RegistryObject<Block> SHORT_PRAIRIE_GRASS = add("short_prairie_grass", () -> new ShortPrairieGrassBlock(BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)), new Item.Properties());
	public static final RegistryObject<Block> PRAIRIE_GRASS = add("prairie_grass", () -> new PrairieGrassBlock(BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)), new Item.Properties());
	public static final RegistryObject<Block> SHORT_PRAIRIE_TUFTS = add("short_prairie_tufts", () -> new ShortPrairieTuftsBlock(BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)), new Item.Properties());
	public static final RegistryObject<Block> TALL_PRAIRIE_TUFTS = add("tall_prairie_tufts", () -> new DoublePlantBlock(BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)), new Item.Properties());

	//Register a block without an item, add("name", new Block(...))
	public static <T extends Block> RegistryObject<T> add(String name, Supplier<T> block) {
		return add(name, block, null);
	}

	//Register a block with an item, add("name", new Block(...), new Item.Properties())
	public static <T extends Block> RegistryObject<T> add(String name, Supplier<T> block, Item.Properties properties) {
		return add(name, block, properties, BlockItem::new);
	}

	//Register a block with a custom item, add("name", new Block(...), new Item.Properties(), Item::new)
	public static <T extends Block> RegistryObject<T> add(String name, Supplier<T> block, Item.Properties properties, BiFunction<Block, Item.Properties, BlockItem> itemConstructor) {
		final RegistryObject<T> registryObject = REGISTRY.register(name, block);
		if (itemConstructor != null && properties != null) PItems.REGISTRY.register(name, () -> itemConstructor.apply(registryObject.get(), properties));
		return registryObject;
	}
}
