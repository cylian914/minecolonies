package com.minecolonies.api.entity.mobs.amazons;

import com.minecolonies.api.entity.mobs.AbstractEntityMinecoloniesRaider;
import com.minecolonies.api.entity.mobs.RaiderType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

import static com.minecolonies.api.util.constant.RaiderConstants.ONE;
import static com.minecolonies.api.util.constant.RaiderConstants.OUT_OF_ONE_HUNDRED;

/**
 * Abstract for all amazon entities.
 */
public abstract class AbstractEntityAmazonRaider extends AbstractEntityMinecoloniesRaider
{
    /**
     * Swim speed for amazons
     */
    private static final double AMAZON_SWIM_BONUS = 1.9;

    /**
     * Constructor method for Abstract amazon.
     *
     * @param type  the type.
     * @param world the world.
     */
    public AbstractEntityAmazonRaider(final EntityType<? extends AbstractEntityAmazonRaider> type, final Level world)
    {
        super(type, world);
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

    @Override
    public RaiderType getRaiderType()
    {
        return RaiderType.AMAZON;
    }

    @Override
    public double getSwimSpeedFactor()
    {
        return AMAZON_SWIM_BONUS;
    }
}
