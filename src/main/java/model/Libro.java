package model;

public class Libro {

	String isbn;
	int num_pag;
	String titulo;
	String editorial;
	int id_autor;

	public Libro(String isbn, int num_pag, String titulo, String editorial, int id_autor) {
		super();
		this.isbn = isbn;
		this.num_pag = num_pag;
		this.titulo = titulo;
		this.editorial = editorial;
		this.id_autor = id_autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getNum_pag() {
		return num_pag;
	}

	public void setNum_pag(int num_pag) {
		this.num_pag = num_pag;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getId_autor() {
		return id_autor;
	}

	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}

}
