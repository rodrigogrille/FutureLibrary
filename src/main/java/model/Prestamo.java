package model;

import java.sql.Date;

public class Prestamo {

	String dni;
	int id;
	Date fecha_inicio;
	Date fecha_fin;
	
	public Prestamo() {
	}

	public Prestamo(String dni, int id, Date fecha_inicio, Date fecha_fin) {
		this.dni = dni;
		this.id = id;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

}
