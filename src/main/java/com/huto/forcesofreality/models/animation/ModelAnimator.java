package com.huto.forcesofreality.models.animation;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

import java.util.HashMap;
import java.util.Map;

public class ModelAnimator {
	private int tempTick = 0;
	private int prevTempTick;
	private boolean correctAnimation = false;
	private float partialTicks;
	private IAnimatable entity;
	private final HashMap<WRModelRenderer, BoxPosCache> boxPosCache = new HashMap<>();
	private final HashMap<WRModelRenderer, BoxPosCache> prevPosCache = new HashMap<>();

	private ModelAnimator() {
	}

	public static ModelAnimator create() {
		return new ModelAnimator();
	}

	public IAnimatable getEntity() {
		return entity;
	}

	public void update(IAnimatable entity, float partialTicks) {
		this.tempTick = prevTempTick = 0;
		this.correctAnimation = false;
		this.entity = entity;
		this.partialTicks = partialTicks;
		boxPosCache.clear();
		prevPosCache.clear();
	}

	public boolean setAnimation(Animation animation) {
		tempTick = prevTempTick = 0;
		correctAnimation = entity.getAnimation() == animation;
		return correctAnimation;
	}

	/***
	 * 
	 * How long the entire animation will take till it goes into reversion
	 * 
	 * @param duration
	 */
	public void startKeyframe(int duration) {
		if (correctAnimation) {
			prevTempTick = tempTick;
			tempTick += duration;
		}
	}

	public void setStaticKeyframe(int duration) {
		startKeyframe(duration);
		endKeyframe(true);
	}

	/***
	 * 
	 * How long the animation will take going back to its old position
	 * 
	 * @param duration
	 */
	public void resetKeyframe(int duration) {
		startKeyframe(duration);
		endKeyframe();
	}

	public void rotate(WRModelRenderer box, float x, float y, float z) {
		if (correctAnimation)
			getPosCache(box).addRotation(x, y, z);
	}

	public void move(WRModelRenderer box, float x, float y, float z) {
		if (correctAnimation)
			getPosCache(box).addOffset(x, y, z);
	}

	private BoxPosCache getPosCache(WRModelRenderer box) {
		return boxPosCache.computeIfAbsent(box, (b) -> new BoxPosCache());
	}

	public void endKeyframe() {
		endKeyframe(false);
	}

	private void endKeyframe(boolean stationary) {
		if (correctAnimation) {
			int animationTick = entity.getAnimationTick();
			if (animationTick >= prevTempTick && animationTick < tempTick) {
				if (stationary) {
					for (Map.Entry<WRModelRenderer, BoxPosCache> entry : prevPosCache.entrySet()) {
						ModelRenderer box = entry.getKey();
						BoxPosCache cache = entry.getValue();
						box.rotateAngleX += cache.getRotationX();
						box.rotateAngleY += cache.getRotationY();
						box.rotateAngleZ += cache.getRotationZ();
						box.rotationPointX += cache.getOffsetX();
						box.rotationPointY += cache.getOffsetY();
						box.rotationPointZ += cache.getOffsetZ();
					}
				} else {
					float tick = ((float) (animationTick - prevTempTick) + partialTicks) / (tempTick - prevTempTick);
					float inc = MathHelper.sin(tick * Mafs.PI / 2f);
					float dec = 1f - inc;

					for (Map.Entry<WRModelRenderer, BoxPosCache> entry : prevPosCache.entrySet()) {
						ModelRenderer box = entry.getKey();
						BoxPosCache cache = entry.getValue();
						box.rotateAngleX += dec * cache.getRotationX();
						box.rotateAngleY += dec * cache.getRotationY();
						box.rotateAngleZ += dec * cache.getRotationZ();
						box.rotationPointX += dec * cache.getOffsetX();
						box.rotationPointY += dec * cache.getOffsetY();
						box.rotationPointZ += dec * cache.getOffsetZ();
					}

					for (Map.Entry<WRModelRenderer, BoxPosCache> entry : boxPosCache.entrySet()) {
						ModelRenderer box = entry.getKey();
						BoxPosCache cache = entry.getValue();
						box.rotateAngleX += inc * cache.getRotationX();
						box.rotateAngleY += inc * cache.getRotationY();
						box.rotateAngleZ += inc * cache.getRotationZ();
						box.rotationPointX += inc * cache.getOffsetX();
						box.rotationPointY += inc * cache.getOffsetY();
						box.rotationPointZ += inc * cache.getOffsetZ();
					}
				}
			}

			if (!stationary) {
				prevPosCache.clear();
				prevPosCache.putAll(boxPosCache);
				boxPosCache.clear();
			}
		}
	}
}