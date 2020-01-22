package com.fema.obstetricia.enums;

public enum TipoDeParto {
	NORMAL(1, "Parto normal"),
	CESAREA(2, "Cesareana");
	
	private int cod;
	private String descricao;
	
	private TipoDeParto(int cod, String descricao) {
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
	
	public static TipoDeParto toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (TipoDeParto x : TipoDeParto.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id invalido: " + cod);
	}
}
