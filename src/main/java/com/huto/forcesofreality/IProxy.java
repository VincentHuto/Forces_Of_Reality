package com.huto.forcesofreality;

import com.huto.forcesofreality.entities.utils.Vector3;

public interface IProxy {

	default void registerHandlers() {
	}

	default void openBinderGui() {
	}
	default void openMechanGui() {
	}
	default void lightningFX(Vector3 vectorStart, Vector3 vectorEnd, float ticksPerMeter, int colorOuter,
			int colorInner) {
		lightningFX(vectorStart, vectorEnd, ticksPerMeter, System.nanoTime(), colorOuter, colorInner);
	}

	default void lightningFX(Vector3 vectorStart, Vector3 vectorEnd, float ticksPerMeter, long seed, int colorOuter,
			int colorInner) {

	}
}
