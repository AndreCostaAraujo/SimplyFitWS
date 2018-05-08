package com.ad4cbr.andre.simplyfit;

import java.util.Date;

public class Venda {
	private int venda;
	private String cliente;
	private Date d_vend;
	private Date d_prev;
	private Date d_prod;
	private Date d_sep;
	private Date d_ent;
	private String obs;
	
	public Venda(int venda, String cliente, Date d_vend, Date d_prev, Date d_prod, 
			Date d_sep, Date d_ent, String obs) {
		super();
		this.venda = venda;
		this.cliente = cliente;
		this.d_vend = d_vend;
		this.d_prev = d_prev;
		this.d_prod = d_prod;
		this.d_sep = d_sep;
		this.d_ent = d_ent;
		this.obs = obs;
	}

	public Venda() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getVenda() {
		return venda;
	}

	public void setVenda(int venda) {
		this.venda = venda;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Date getD_vend() {
		return d_vend;
	}

	public void setD_vend(Date d_vend) {
		this.d_vend = d_vend;
	}

	public Date getD_prev() {
		return d_prev;
	}

	public void setD_prev(Date d_prev) {
		this.d_prev = d_prev;
	}

	public Date getD_prod() {
		return d_prod;
	}

	public void setD_prod(Date d_prod) {
		this.d_prod = d_prod;
	}

	public Date getD_sep() {
		return d_sep;
	}

	public void setD_sep(Date d_sep) {
		this.d_sep = d_sep;
	}

	public Date getD_ent() {
		return d_ent;
	}

	public void setD_ent(Date d_ent) {
		this.d_ent = d_ent;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	@Override
	public String toString() {
		return "Venda [venda=" + venda + ", cliente=" + cliente + ", obs=" + obs + "]";
	}
	
}
