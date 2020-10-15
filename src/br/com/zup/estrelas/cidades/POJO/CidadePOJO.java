package br.com.zup.estrelas.cidades.POJO;

public class CidadePOJO {
	private String nome;
	private String cep;
	private float numeroHabitantes;
	private boolean ehCapital;
	private String estado;
	private float rendaPerCapta;
	private String dataFundacao;
	
	

	public CidadePOJO() {
	
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public float getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public void setNumeroHabitantes(float numeroHabitantes) {
		this.numeroHabitantes = numeroHabitantes;
	}

	public boolean getEhCapital() {
		return ehCapital;
	}

	public void setEhCapital(boolean ehCapital) {
		this.ehCapital = ehCapital;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public float getRendaPerCapta() {
		return rendaPerCapta;
	}

	public void setRendaPerCapta(float rendaPerCapta) {
		this.rendaPerCapta = rendaPerCapta;
	}

	public String getDataFundacao() {
		return dataFundacao;
	}

	public void setData(String dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	
}
