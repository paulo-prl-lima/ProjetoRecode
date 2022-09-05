package model;

public class Promocao {

	// atributos
	private int id_promocao;
	private String nomePacote;
	private double percentual;
	private String observacao;
	
	
	// gets e sets
	public int getId_promocao() {
		return id_promocao;
	}
	public void setId_promocao(int id_promocao) {
		this.id_promocao = id_promocao;
	}
	public String getNomePacote() {
		return nomePacote;
	}
	public void setNomePacote(String nomePacote) {
		this.nomePacote = nomePacote;
	}
	public double getPercentual() {
		return percentual;
	}
	public void setPercentual(double percentual) {
		this.percentual = percentual;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}

	