package com.vincenthuto.forcesofreality.model.entity.mob.anim;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class TentacleAnimations {

	public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(2f).looping()
			.addAnimation("tip",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0.5416666666666666f,
									KeyframeAnimations.degreeVec(-0.7425080590132893f, -1.8480229034785225f,
											-14.855975324390783f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.4583333333333333f,
									KeyframeAnimations.degreeVec(0.7999886978539688f, 1.2645986306934538f,
											11.230724008723154f),
									AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("third",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0.5416666666666666f,
									KeyframeAnimations.degreeVec(-0.8578435025501676f, -1.4857092423371796f,
											12.393303774698325f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.4583333333333333f,
									KeyframeAnimations.degreeVec(-0.7014857758456674f, -6.067878879818727f,
											-23.393538608779817f),
									AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("second",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.5416666666666666f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.4583333333333333f,
									KeyframeAnimations.degreeVec(1.0183529150554023f, 3.235965634234617f,
											17.96117827672666f),
									AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("second",
					new AnimationChannel(AnimationChannel.Targets.SCALE,
							new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
									AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("base",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("base",
					new AnimationChannel(AnimationChannel.Targets.SCALE,
							new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
									AnimationChannel.Interpolations.CATMULLROM)))
			.build();
}
