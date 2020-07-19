package coda.ravagecabbage.client.renderer.entity;

import coda.ravagecabbage.client.renderer.entity.model.CabbageRavagerModel;
import coda.ravagecabbage.entity.CabbageRavagerEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class CabbageRavagerRenderer extends MobEntityRenderer<CabbageRavagerEntity, CabbageRavagerModel> {
    private static final Identifier TEXTURE = new Identifier("textures/entity/illager/ravager.png");

    public CabbageRavagerRenderer(EntityRenderDispatcher renderManagerIn) {
        super(renderManagerIn, new CabbageRavagerModel(), 1.1F);
    }

    @Override
    public Identifier getTexture(CabbageRavagerEntity entity) {
        return TEXTURE;
    }
}
