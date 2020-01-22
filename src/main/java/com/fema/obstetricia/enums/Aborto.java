package com.fema.obstetricia.enums;

public enum Aborto {
	
	SIM(1, "Aborto"),
	NAO(2, "Nao foi aborto"),
	NAO_INFORMAR(3, "Não informar");
	
	private int cod;
	private String descricao;
	
	private Aborto(int cod, String descricao) {
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
	
	public static Aborto toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (Aborto x : Aborto.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id invalido: " + cod);
	}
}
