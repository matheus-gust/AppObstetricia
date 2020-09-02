package com.fema.obstetricia.usuario.dto;

public class CadastroFinalizadoDTO {
	private boolean cadastroFinalizado;
	
	public CadastroFinalizadoDTO() {
		
	}

	public CadastroFinalizadoDTO(boolean cadastroFinalizado) {
		super();
		this.cadastroFinalizado = cadastroFinalizado;
	}

	public boolean isCadastroFinalizado() {
		return cadastroFinalizado;
	}

	public void setCadastroFinalizado(boolean cadastroFinalizado) {
		this.cadastroFinalizado = cadastroFinalizado;
	}
}
