package org.mineplugin.locusazzurro.icaruswings.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class GoldenSparkleParticle extends TextureSheetParticle {

    public GoldenSparkleParticle(ClientLevel world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        super(world, x, y, z, xSpeed, ySpeed, zSpeed);
        this.setColor(1f,1f,1f);
        this.setSize(0.02f, 0.02f);
        this.scale(world.random.nextFloat()/0.5f);
        this.xd = world.random.nextDouble() - 0.5;
        this.yd = world.random.nextDouble() - 0.5;
        this.zd = world.random.nextDouble() - 0.5;
        this.lifetime = 20;
        this.hasPhysics = false;
    }

    @Override
    public void tick(){
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) this.remove();
        else {
            this.move(xd, yd, zd);
            this.xd *= 0.8d;
            this.yd *= 0.8d;
            this.zd *= 0.8d;
        }
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements ParticleProvider<SimpleParticleType> {

        private final SpriteSet sprites;

        public Factory(SpriteSet sprite) {
            this.sprites = sprite;
        }

        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType dataIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            GoldenSparkleParticle particle = new GoldenSparkleParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
            particle.setColor(1f,1f,1f);
            particle.pickSprite(sprites);
            return particle;
        }
    }
}
