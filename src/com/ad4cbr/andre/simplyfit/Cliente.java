package com.ad4cbr.andre.simplyfit;

public class Cliente {
	private String cliente;
	private String nome;
	private String tel;
	private String cel;
	private String email;
	private String obs;
	
	public Cliente(String cliente, String nome, String tel, String cel, String email, String obs) {
		super();
		this.cliente = cliente;
		this.nome = nome;
		this.tel = tel;
		this.cel = cel;
		this.email = email;
		this.obs = obs;
	}
	
	public Cliente () {
		
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	@Override
	public String toString() {
		return cliente + " (" + nome + ")";
	}

}
