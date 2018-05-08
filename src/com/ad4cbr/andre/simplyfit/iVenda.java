package com.ad4cbr.andre.simplyfit;

public class iVenda {
	private int venda;
	private int ivenda;
	private String material;
	private int qtd;
	private float p_unit;
	
	public iVenda(int venda, int ivenda, String material, int qtd, float p_unit) {
		super();
		this.venda = venda;
		this.ivenda = ivenda;
		this.material = material;
		this.qtd = qtd;
		this.p_unit = p_unit;
	}
	
	public iVenda() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getVenda() {
		return venda;
	}
	public void setVenda(int venda) {
		this.venda = venda;
	}
	public int getIvenda() {
		return ivenda;
	}
	public void setIvenda(int ivenda) {
		this.ivenda = ivenda;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public float getP_unit() {
		return p_unit;
	}
	public void setP_unit(float p_unit) {
		this.p_unit = p_unit;
	}
	
	@Override
	public String toString() {
		return "iVenda [venda=" + venda + ", ivenda=" + ivenda + ", material=" + material + ", qtd=" + qtd + ", p_unit="
				+ p_unit + "]";
	}
	
	

}
