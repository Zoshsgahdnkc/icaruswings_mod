package org.mineplugin.locusazzurro.icaruswings.registry;

import java.util.function.Supplier;

import org.mineplugin.locusazzurro.icaruswings.data.ModData;
import org.mineplugin.locusazzurro.icaruswings.entity.*;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypeRegistry {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, ModData.MOD_ID);
	
	public static final RegistryObject<EntityType<GoldenRamEntity>> goldenRamEntity =
			register("golden_ram", () -> EntityType.Builder
					.of(GoldenRamEntity::new, EntityClassification.CREATURE)
					.sized(0.9F, 1.3F)
					.clientTrackingRange(10)
					.build("golden_ram"));

	public static final RegistryObject<EntityType<ArtemisMissileEntity>> artemisMissileEntity =
			register("artemis_missile", () -> EntityType.Builder
					.<ArtemisMissileEntity>of(ArtemisMissileEntity::new, EntityClassification.MISC)
					.sized(0.1F, 0.1F)
					.build("artemis_missile"));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, Supplier<EntityType<T>> type) {
		return ENTITIES.register(name, type);
	}

}