package model;
public class Destino {

	
	// atributos
	private int id_destino;
	private String nome;
	private String hotel;
	private String descricao;
	private double valor;
	private int id_cliente;
	private int id_promocao;

	// gets e sets
	public int getId_destino() {
		return id_destino;
	}

	public void setId_destino(int id_destino) {
		this.id_destino = id_destino;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}


	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_promocao() {
		return id_promocao;
	}

	public void setId_promocao(int id_promocao) {
		this.id_promocao = id_promocao;
	}



}
