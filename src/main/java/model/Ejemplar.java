package model;

public class Ejemplar {

	int id;
	String estado;
	String ISBN;
	
	public Ejemplar() {
	}

	public Ejemplar(int id, String estado, String iSBN) {
		this.id = id;
		this.estado = estado;
		ISBN = iSBN;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

}
