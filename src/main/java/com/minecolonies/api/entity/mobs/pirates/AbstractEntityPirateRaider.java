package com.minecolonies.api.entity.mobs.pirates;

import com.minecolonies.api.entity.mobs.AbstractEntityMinecoloniesRaider;
import com.minecolonies.api.entity.mobs.RaiderType;
import com.minecolonies.core.entity.pathfinding.navigation.AbstractAdvancedPathNavigate;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

import static com.minecolonies.api.util.constant.RaiderConstants.ONE;
import static com.minecolonies.api.util.constant.RaiderConstants.OUT_OF_ONE_HUNDRED;

/**
 * Abstract for all pirate entities.
 */
public abstract class AbstractEntityPirateRaider extends AbstractEntityMinecoloniesRaider
{
    /**
     * Swim speed for pirates
     */
    private static final double PIRATE_SWIM_BONUS = 2.3;

    /**
     * Amount of unique pirate textures.
     */
    private static final int PIRATE_TEXTURES = 4;

    /**
     * Texture id of the pirates.
     */
    private int textureId;

    /**
     * Constructor method for Abstract Barbarians.
     *
     * @param type  the type.
     * @param world the world.
     */
    public AbstractEntityPirateRaider(final EntityType<? extends AbstractEntityPirateRaider> type, final Level world)
    {
        super(type, world);
        this.textureId = new Random().nextInt(PIRATE_TEXTURES);
    }

    @Override
    public void playAmbientSound()
    {
        final SoundEvent soundevent = this.getAmbientSound();

        if (soundevent != null && level().random.nextInt(OUT_OF_ONE_HUNDRED) <= ONE)
        {
            this.playSound(soundevent, this.getSoundVolume(), this.getVoicePitch());
        }
    }

    @Override
    public boolean checkSpawnRules(final LevelAccessor worldIn, final MobSpawnType spawnReasonIn)
    {
        return true;
    }

    /**
     * Get the unique texture id.
     *
     * @return the texture id.
     */
    public int getTextureId()
    {
        return this.textureId;
    }

    @NotNull
    @Override
    public AbstractAdvancedPathNavigate getNavigation()
    {
        AbstractAdvancedPathNavigate navigator = super.getNavigation();
        navigator.getPathingOptions().withStartSwimCost(2.5D).withSwimCost(1.1D);
        return navigator;
    }

    @Override
    public RaiderType getRaiderType()
    {
        return RaiderType.PIRATE;
    }

    @Override
    public double getSwimSpeedFactor()
    {
        return PIRATE_SWIM_BONUS;
    }
}
