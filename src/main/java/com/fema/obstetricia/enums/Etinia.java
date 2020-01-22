package com.fema.obstetricia.enums;

public enum Etinia {

	BRANCO(1, "Branco"),
	NEGRO(2, "Negro"),
	INDIGENA(3, "Indigena");
	
	private int cod;
	private String descricao;
	
	private Etinia(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static Etinia toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (Etinia x : Etinia.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id invalido: " + cod);
	}
}
