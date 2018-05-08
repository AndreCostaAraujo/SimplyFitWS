package com.ad4cbr.andre.simplyfit;

public class Material {
	private String material;
	private String desc;
	private String tipo;
	private float p_unit;
	
	public Material(String material, String desc, String tipo, float p_unit) {
		super();
		this.material = material;
		this.desc = desc;
		this.tipo = tipo;
		this.p_unit = p_unit;
	}
	
	public Material() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getP_unit() {
		return p_unit;
	}

	public void setP_unit(float p_unit) {
		this.p_unit = p_unit;
	}

	@Override
	public String toString() {
		return "Material [material=" + material + ", desc=" + desc + ", tipo=" + tipo + ", p_unit=" + p_unit + "]";
	}
	
	

}
