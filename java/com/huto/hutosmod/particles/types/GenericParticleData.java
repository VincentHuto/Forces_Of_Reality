package com.huto.hutosmod.particles.types;

import java.util.Locale;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;

import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.registry.Registry;

public class GenericParticleData extends ParticleType<GenericParticleData> implements IParticleData {
	
	private static final IParticleData.IDeserializer<GenericParticleData> DESERIALIZER = new IParticleData.IDeserializer<GenericParticleData>() {
		
		
		public GenericParticleData deserialize(ParticleType<GenericParticleData> particleTypeIn, StringReader reader)
				throws CommandSyntaxException {
			System.out.println("t");

			boolean show = (boolean) reader.readBoolean();
			reader.expect(' ');
			float red = (float) reader.readDouble();
			reader.expect(' ');
			float green = (float) reader.readDouble();
			reader.expect(' ');
			float blue = (float) reader.readDouble();
			reader.expect(' ');
			float alpha = (float) reader.readDouble();
			reader.expect(' ');
			int age = (int) reader.readInt();
			return new GenericParticleData(show, red, green, blue, alpha, age);
		}

		public GenericParticleData read(ParticleType<GenericParticleData> particleTypeIn, PacketBuffer buffer) {
			System.out.println("t");

			return new GenericParticleData(buffer.readBoolean(), buffer.readFloat(), buffer.readFloat(),
					buffer.readFloat(), buffer.readFloat(), buffer.readInt());
		}
	};
	private final Codec<GenericParticleData> field_239825_b_ = Codec.unit(this::getType);

	public GenericParticleData(boolean alwaysShow) {
		
		super(alwaysShow, DESERIALIZER);
		System.out.println("t");


	}

	public float r, g, b, a;
	public int age;

	public GenericParticleData(boolean alwaysShow, float rIn, float gIn, float bIn, float aIn, int ageIn) {
		super(alwaysShow, DESERIALIZER);
		System.out.println("t");
		this.r = rIn;
		this.g = gIn;
		this.b = bIn;
		this.a = aIn;
		this.age = ageIn;
	}

	public float getR() {
		return r;
	}

	public void setR(float r) {
		this.r = r;
	}

	public float getG() {
		return g;
	}

	public void setG(float g) {
		this.g = g;
	}

	public float getB() {
		return b;
	}

	public void setB(float b) {
		this.b = b;
	}

	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public GenericParticleData getType() {
		new GenericParticleData(false, 1, 0,1, 1,100);
		
		return this;
	}

	public Codec<GenericParticleData> func_230522_e_() {
		return this.field_239825_b_;
	}

	public void write(PacketBuffer buffer) {
		System.out.println("t");

		buffer.writeBoolean(this.getAlwaysShow());
		buffer.writeFloat(this.r);
		buffer.writeFloat(this.g);
		buffer.writeFloat(this.b);
		buffer.writeFloat(this.a);
		buffer.writeFloat(this.age);

	}

	public String getParameters() {
		System.out.println("t");

		return String.format("false %1f %1f %.2f %1f %1f 100", Registry.PARTICLE_TYPE.getKey(this.getType()));
	}
}