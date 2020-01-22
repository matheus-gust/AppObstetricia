package com.fema.obstetricia.enums;

public enum TipoQuestionario {

	SAUDE_RECEM_NASCIDO(1, "Saude do bebe e amamentação"),
	TIPO_CONTRACEPTIVO(2, "Tipo de contraceptivo usado"),
	TESTES_REALIZADOS_BEBE(3, "Testes realizados no bebe"),
	VACINA(4, "Informações sobre testes realizados no bebe"),
	INCONTINENCIA_URINARIA(5, "Incontinencia urinaria"),
	DEPRESSAO(6, "Depressão pós puerpera");
	
	private int cod;
	private String descricao;
	
	private TipoQuestionario(int cod, String descricao) {
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
	
	public static TipoQuestionario toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (TipoQuestionario x : TipoQuestionario.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id invalido: " + cod);
	}
}
