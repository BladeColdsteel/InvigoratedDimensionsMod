package com.bladecoldsteel.invigorateddimensions.electrichighlands.client.particle;

import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.PortalParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ElectricHighlandsPortalParticle extends PortalParticle {

    protected ElectricHighlandsPortalParticle(ClientWorld world, double x, double y, double z, double motionX, double motionY, double motionZ) {
        super(world, x, y, z, motionX, motionY, motionZ);
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType> {
        private final IAnimatedSprite spriteSet;

        public Factory(IAnimatedSprite spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Override
        public Particle createParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double speedX, double speedY, double speedZ) {
            ElectricHighlandsPortalParticle portalParticle = new ElectricHighlandsPortalParticle(worldIn, x, y, z, speedX, speedY, speedZ);
            portalParticle.pickSprite(this.spriteSet);
            portalParticle.setColor(0.2F, 0.45F, 0.09F);
            return portalParticle;
        }
    }
}
