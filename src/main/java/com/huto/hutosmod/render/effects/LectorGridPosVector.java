package com.huto.hutosmod.render.effects;

public class LectorGridPosVector {
	float x, y, z;
	LectorVectorColorData colorData;

	public LectorGridPosVector(float xIn, float yIn, float zIn) {
		this.x = xIn;
		this.y = yIn;
		this.z = zIn;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

}
