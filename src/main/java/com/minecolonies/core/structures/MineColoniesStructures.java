package com.minecolonies.core.structures;

import com.minecolonies.api.util.constant.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.minecolonies.core.structures.EmptyColonyStructure.COLONY_CODEC;

/**
 * Thanks to: https://github.com/TelepathicGrunt/StructureTutorialMod/tree/1.18.x-Forge-Jigsaw
 */
public class MineColoniesStructures
{
    /**
     * We are using the Deferred Registry system to register our structure as this is the preferred way on Forge.
     * This will handle registering the base structure for us at the correct time so we don't have to handle it ourselves.
     */
    public static final DeferredRegister<StructureType<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(Registries.STRUCTURE_TYPE, Constants.MOD_ID);

    /**
     * Empty colony structure.
     */
    public static final RegistryObject<StructureType<EmptyColonyStructure>> EMPTY_COLONY = DEFERRED_REGISTRY_STRUCTURE.register("empty_colony", () -> () -> COLONY_CODEC);
}
