package com.huto.forces_of_reality;

import com.huto.forces_of_reality.entities.utils.Vector3;

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