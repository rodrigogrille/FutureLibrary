package modelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.Conection;
import model.Libro;

public class LibroDao {
	Conection cn = new Conection();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public LibroDao() {
	}

	public List<Libro> read() {
		ArrayList<Libro> list = new ArrayList<>();
		String sql = "select * from libro";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Libro libro = new Libro();
				libro.setIsbn(rs.getString("ISBN"));
				libro.setNum_pag(rs.getInt("Numero_Paginas"));
				libro.setTitulo(rs.getString("Titulo"));
				libro.setEditorial(rs.getString("Editorial"));
				libro.setId_autor(rs.getInt("id_autor"));
				list.add(libro);
			}
		} catch (Exception e) {
		}
		return list;
	}

	public Libro read(String id) {
		String sql = "select * from libro where ISBN=?";
		Libro libro = new Libro();
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				libro.setIsbn(rs.getString("ISBN"));
				libro.setNum_pag(rs.getInt("Numero_Paginas"));
				libro.setTitulo(rs.getString("Titulo"));
				libro.setEditorial(rs.getString("Editorial"));
				libro.setId_autor(rs.getInt("id_autor"));
			}
		} catch (Exception e) {

		}
		return libro;
	}

	public boolean create(Libro libro) {
		String sql = "INSERT INTO libro( ISBN, Numero_paginas, Titulo, Editorial, id_autor )values( ?, ?, ?, ?, ? )";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, libro.getIsbn());
			ps.setInt(2, libro.getNum_pag());
			ps.setString(3, libro.getTitulo());
			ps.setString(4, libro.getEditorial());
			ps.setInt(5, libro.getId_autor());
			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex);
			return false;
		}

		return true;
	}

	public boolean update(Libro libro) {
		String sql = "update libro set Numero_paginas=?, Titulo=?, Editorial=?, id_autor=? where ISBN=?";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, libro.getNum_pag());
			ps.setString(2, libro.getTitulo());
			ps.setString(3, libro.getEditorial());
			ps.setInt(4, libro.getId_autor());
			ps.setString(5, libro.getIsbn());
			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex);
			return false;
		}
		return true;
	}

	public boolean delete(String id) {
		String sql = "delete from libro where ISBN=?";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex);
			return false;
		}
		return true;
	}
}
