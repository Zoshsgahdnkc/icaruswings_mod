package org.mineplugin.locusazzurro.icaruswings.render.models;

import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import org.mineplugin.locusazzurro.icaruswings.entity.GoldenRamEntity;

public class GoldenRamModel<T extends GoldenRamEntity> extends QuadrupedModel<T> {

    private float headXRot;

    public GoldenRamModel(ModelPart pRoot) {
        super(pRoot, false, 8.0F, 4.0F, 2.0F, 2.0F, 24);
    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(12, CubeDeformation.NONE);
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, -6.0F, 6.0F, 6.0F, 8.0F), PartPose.offset(0.0F, 6.0F, -8.0F));
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(28, 8).addBox(-4.0F, -10.0F, -7.0F, 8.0F, 16.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 2.0F, ((float)Math.PI / 2F), 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    public void prepareMobModel(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick) {
        super.prepareMobModel(pEntity, pLimbSwing, pLimbSwingAmount, pPartialTick);
        this.head.y = 6.0F + pEntity.getHeadEatPositionScale(pPartialTick) * 9.0F;
        this.headXRot = pEntity.getHeadEatAngleScale(pPartialTick);
    }

    public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        super.setupAnim(pEntity, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch);
        this.head.xRot = this.headXRot;
    }
}
