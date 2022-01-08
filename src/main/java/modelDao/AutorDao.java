package modelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.Conection;
import model.Autor;

public class AutorDao {
	Conection cn = new Conection();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public AutorDao() {
	}

	public List<Autor> read() {
		ArrayList<Autor> list = new ArrayList<>();
		String sql = "select * from autor";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Autor autor = new Autor();
				autor.setId(rs.getInt("ID"));
				autor.setNombre(rs.getString("Nombre"));
				list.add(autor);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public Autor read(int id) {
		String sql = "select * from autor where ID=?";
		Autor autor = new Autor();
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				autor.setId(rs.getInt("ID"));
				autor.setNombre(rs.getString("Nombre"));
			}
		} catch (Exception e) {

		}
		return autor;
	}

	public boolean create(Autor autor) {
		String sql = "INSERT INTO autor(ID, Nombre)values( ?, ? )";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, autor.getId());
			ps.setString(2, autor.getNombre());
			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex);
			return false;
		}

		return true;
	}

	public boolean update(Autor autor) {
		String sql = "update autor set Nombre=? where ID = ?";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, autor.getNombre());
			ps.setInt(2, autor.getId());
			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex);
			return false;
		}
		return true;
	}

	public boolean delete(int id) {
		String sql="delete from autor where ID=?";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex);
			return false;
		}
		return true;
	}

}
