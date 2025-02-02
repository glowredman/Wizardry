package electroblob.wizardry.client.renderer.entity.layers;

import electroblob.wizardry.registry.WizardryPotions;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

/**
 * Layer used to render the diamondflesh texture on creatures with the diamondflesh effect.
 *
 * @author WinDanesz
 * @since Wizardry 4.3.7
 */
public class LayerDiamond extends LayerTiledOverlay<EntityLivingBase> {

	private static final ResourceLocation TEXTURE = new ResourceLocation("textures/blocks/diamond_block.png");

	public LayerDiamond(RenderLivingBase<?> renderer){
		super(renderer);
	}

	@Override
	public boolean shouldRender(EntityLivingBase entity, float partialTicks){
		return !entity.isInvisible() && entity.isPotionActive(WizardryPotions.diamondflesh);
	}

	@Override
	public ResourceLocation getTexture(EntityLivingBase entity, float partialTicks){
		return TEXTURE;
	}

	@Override
	public void doRenderLayer(EntityLivingBase entity, float limbSwing, float limbSwingAmount, float partialTicks,
			float ageInTicks, float netHeadYaw, float headPitch, float scale){

		GlStateManager.enableBlend();
		GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);

		super.doRenderLayer(entity, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale);

		GlStateManager.disableBlend();
	}

}