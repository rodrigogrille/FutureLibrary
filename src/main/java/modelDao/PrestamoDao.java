package modelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.Conection;
import model.Prestamo;

public class PrestamoDao {
	Conection cn = new Conection();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public PrestamoDao() {
	}

	public List<Prestamo> read() {
		ArrayList<Prestamo> list = new ArrayList<>();
		String sql = "select * from prestamo";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Prestamo prestamo = new Prestamo();
				prestamo.setDni(rs.getString("DNI"));
				prestamo.setId(rs.getInt("ID"));
				prestamo.setFecha_inicio(rs.getDate("fecha_inicio"));
				prestamo.setFecha_fin(rs.getDate("fecha_fin"));
				list.add(prestamo);
			}
		} catch (Exception e) {
		}
		return list;
	}

	public Prestamo read(String id) {
		String sql = "select * from prestamo where DNI=?";
		Prestamo prestamo = new Prestamo();
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				prestamo.setDni(rs.getString("DNI"));
				prestamo.setId(rs.getInt("ID"));
				prestamo.setFecha_inicio(rs.getDate("fecha_inicio"));
				prestamo.setFecha_fin(rs.getDate("fecha_fin"));
			}
		} catch (Exception e) {

		}
		return prestamo;
	}

	public boolean create(Prestamo prestamo) {
		String sql = "INSERT INTO prestamo( DNI, ID, fecha_inicio, fecha_fin )values( ?, ?, ?, ? )";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, prestamo.getDni());
			ps.setInt(2, prestamo.getId());
			ps.setDate(3, prestamo.getFecha_inicio());
			ps.setDate(4, prestamo.getFecha_fin());
			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex);
			return false;
		}

		return true;
	}

	public boolean update(Prestamo prestamo) {
		String sql = "update prestamo set ID=?, fecha_inicio=?, fecha_fin=? where DNI=?";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, prestamo.getId());
			ps.setDate(2, prestamo.getFecha_inicio());
			ps.setDate(3, prestamo.getFecha_fin());
			ps.setString(4, prestamo.getDni());
			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex);
			return false;
		}
		return true;
	}

	public boolean delete(String id) {
		String sql = "delete from prestamo where DNI=?";
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
