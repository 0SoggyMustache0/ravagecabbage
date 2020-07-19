package coda.ravagecabbage.client.renderer.entity.model;

import coda.ravagecabbage.entity.CabbageRavagerEntity;
import com.google.common.collect.ImmutableList;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;
import net.minecraft.util.math.MathHelper;

import java.util.Collections;

@Environment(EnvType.CLIENT)
public class CabbageRavagerModel extends AnimalModel<CabbageRavagerEntity> {
   private final ModelPart head;
   private final ModelPart jaw;
   private final ModelPart body;
   private final ModelPart legBackRight;
   private final ModelPart legBackLeft;
   private final ModelPart legFrontRight;
   private final ModelPart legFrontLeft;
   private final ModelPart neck;
   private Iterable<ModelPart> parts;

   public CabbageRavagerModel() {
      this.textureWidth = 128;
      this.textureHeight = 128;
      this.neck = new ModelPart(this);
      this.neck.setPivot(0.0F, -7.0F, -1.5F);
      this.neck.setTextureOffset(68, 73).addCuboid(-5.0F, -1.0F, -18.0F, 10.0F, 10.0F, 18.0F, 0.0F);
      this.head = new ModelPart(this);
      this.head.setPivot(0.0F, 16.0F, -17.0F);
      this.head.setTextureOffset(0, 0).addCuboid(-8.0F, -20.0F, -14.0F, 16.0F, 20.0F, 16.0F, 0.0F);
      this.head.setTextureOffset(0, 0).addCuboid(-2.0F, -6.0F, -18.0F, 4.0F, 8.0F, 4.0F, 0.0F);
      ModelPart ModelPart = new ModelPart(this);
      ModelPart.setPivot(-10.0F, -14.0F, -8.0F);
      ModelPart.setTextureOffset(74, 55).addCuboid(0.0F, -14.0F, -2.0F, 2.0F, 14.0F, 4.0F, 0.0F);
      ModelPart.pitch = 1.0995574F;
      this.head.addChild(ModelPart);
      ModelPart ModelPart1 = new ModelPart(this);
      ModelPart1.mirror = true;
      ModelPart1.setPivot(8.0F, -14.0F, -8.0F);
      ModelPart1.setTextureOffset(74, 55).addCuboid(0.0F, -14.0F, -2.0F, 2.0F, 14.0F, 4.0F, 0.0F);
      ModelPart1.pitch = 1.0995574F;
      this.head.addChild(ModelPart1);
      this.jaw = new ModelPart(this);
      this.jaw.setPivot(0.0F, -2.0F, 2.0F);
      this.jaw.setTextureOffset(0, 36).addCuboid(-8.0F, 0.0F, -16.0F, 16.0F, 3.0F, 16.0F, 0.0F);
      this.head.addChild(this.jaw);
      this.neck.addChild(this.head);
      this.body = new ModelPart(this);
      this.body.setTextureOffset(0, 55).addCuboid(-7.0F, -10.0F, -7.0F, 14.0F, 16.0F, 20.0F, 0.0F);
      this.body.setTextureOffset(0, 91).addCuboid(-6.0F, 6.0F, -7.0F, 12.0F, 13.0F, 18.0F, 0.0F);
      this.body.setPivot(0.0F, 1.0F, 2.0F);
      this.legBackRight = new ModelPart(this, 96, 0);
      this.legBackRight.addCuboid(-4.0F, 0.0F, -4.0F, 8.0F, 37.0F, 8.0F, 0.0F);
      this.legBackRight.setPivot(-8.0F, -13.0F, 18.0F);
      this.legBackLeft = new ModelPart(this, 96, 0);
      this.legBackLeft.mirror = true;
      this.legBackLeft.addCuboid(-4.0F, 0.0F, -4.0F, 8.0F, 37.0F, 8.0F, 0.0F);
      this.legBackLeft.setPivot(8.0F, -13.0F, 18.0F);
      this.legFrontRight = new ModelPart(this, 64, 0);
      this.legFrontRight.addCuboid(-4.0F, 0.0F, -4.0F, 8.0F, 37.0F, 8.0F, 0.0F);
      this.legFrontRight.setPivot(-8.0F, -13.0F, -5.0F);
      this.legFrontLeft = new ModelPart(this, 64, 0);
      this.legFrontLeft.mirror = true;
      this.legFrontLeft.addCuboid(-4.0F, 0.0F, -4.0F, 8.0F, 37.0F, 8.0F, 0.0F);
      this.legFrontLeft.setPivot(8.0F, -13.0F, -5.0F);
   }

   @Override
   public void setAngles(CabbageRavagerEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
      this.head.pitch = headPitch * ((float) Math.PI / 180F);
      this.head.yaw = headYaw * ((float) Math.PI / 180F);
      this.body.pitch = ((float) Math.PI / 2F);
      float f = 0.4F * limbDistance;
      this.legBackRight.pitch = MathHelper.cos(limbAngle * 0.6662F) * f;
      this.legBackLeft.pitch = MathHelper.cos(limbAngle * 0.6662F + (float) Math.PI) * f;
      this.legFrontRight.pitch = MathHelper.cos(limbAngle * 0.6662F + (float) Math.PI) * f;
      this.legFrontLeft.pitch = MathHelper.cos(limbAngle * 0.6662F) * f;
      setLivingAnimations(entity, limbAngle, limbDistance, animationProgress);
   }

   public Iterable<ModelPart> getBodyParts() {
      if (parts == null)
         parts = ImmutableList.of(this.neck, this.body, this.legBackRight, this.legBackLeft, this.legFrontRight, this.legFrontLeft);
      return parts;
   }

   @Override
   protected Iterable<ModelPart> getHeadParts() {
      return Collections.emptyList();
   }
   
   public void setLivingAnimations(CabbageRavagerEntity entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
      int i = entityIn.getStunTick();
      int j = entityIn.getRoarTick();
      int l = entityIn.getAttackTick();
      if (l > 0) {
         float f = this.triangleWave((float) l - partialTick, 10.0F);
         float f1 = (1.0F + f) * 0.5F;
         float f2 = f1 * f1 * f1 * 12.0F;
         float f3 = f2 * MathHelper.sin(this.neck.pitch);
         this.neck.pivotZ = -6.5F + f2;
         this.neck.pivotY = -7.0F - f3;
         float f4 = MathHelper.sin(((float) l - partialTick) / 10.0F * (float) Math.PI * 0.25F);
         this.jaw.pitch = ((float) Math.PI / 2F) * f4;
         if (l > 5) {
            this.jaw.pitch = MathHelper.sin(((float) (-4 + l) - partialTick) / 4.0F) * (float) Math.PI * 0.4F;
         } else {
            this.jaw.pitch = 0.15707964F * MathHelper.sin((float) Math.PI * ((float) l - partialTick) / 10.0F);
         }
      } else {
         float f5 = -1.0F;
         float f6 = f5 * MathHelper.sin(this.neck.pitch);
         this.neck.pivotX = 0.0F;
         this.neck.pivotY = -7.0F - f6;
         this.neck.pivotZ = 5.5F;
         boolean flag = i > 0;
         this.neck.pitch = flag ? 0.21991149F : 0.0F;
         this.jaw.pitch = (float) Math.PI * (flag ? 0.05F : 0.01F);
         if (flag) {
            double d0 = (double) i / 40.0D;
            this.neck.pivotX = (float) Math.sin(d0 * 10.0D) * 3.0F;
         } else if (j > 0) {
            float f7 = MathHelper.sin(((float) (20 - j) - partialTick) / 20.0F * (float) Math.PI * 0.25F);
            this.jaw.pitch = ((float) Math.PI / 2F) * f7;
         }
      }
   }

   private float triangleWave(float p_217167_1_, float p_217167_2_) {
      return (Math.abs(p_217167_1_ % p_217167_2_ - p_217167_2_ * 0.5F) - p_217167_2_ * 0.25F) / (p_217167_2_ * 0.25F);
   }
}
