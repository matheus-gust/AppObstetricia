package com.fema.obstetricia.enums;

public enum Escolaridade {
	ENSINO_FUNDAMENTAL_COMPLETO(1, "Ensino fundamental completo"),
	ENSINO_FUNDAMENTAL_INCOMPLETO(2, "Ensino fundamental incompleto"),
	ENSION_MEDIO_COMPLETO(3, "Ensino medio completo"),
	ENSION_MEDIO_INCOMPLETO(4, "Ensino medio incompleto"),
	ENSINO_TECNICO(5, "Ensino tecnico"),
	ENSINO_SUPERIOR_COMPLETO(6, "Ensino superior completo"),
	ENSINO_SUPERIOR_INCOMPLETO(7, "Ensino superior incompleto");

	private int cod;
	private String descricao;
	
	private Escolaridade(int cod, String descricao) {
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
	
	public static Escolaridade toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (Escolaridade x : Escolaridade.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id invalido: " + cod);
	}
}
