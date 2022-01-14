 package modelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.Conection;
import model.Ejemplar;

public class EjemplarDao {
	Conection cn = new Conection();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public EjemplarDao() {
	}

	public List<Ejemplar> read() {
		ArrayList<Ejemplar> list = new ArrayList<>();
		String sql = "select * from ejemplar";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Ejemplar ejemplar = new Ejemplar();
				ejemplar.setId(rs.getInt("ID"));
				ejemplar.setEstado(rs.getString("Estado"));
				ejemplar.setISBN(rs.getString("ISBN"));
				list.add(ejemplar);
			}
		} catch (Exception e) {
		}
		return list;
	}

	public Ejemplar read(int id) {
		String sql = "select * from ejemplar where ID=?";
		Ejemplar ejemplar = new Ejemplar();
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				ejemplar.setId(rs.getInt("ID"));
				ejemplar.setEstado(rs.getString("Estado"));
				ejemplar.setISBN(rs.getString("ISBN"));
			}
		} catch (Exception e) {

		}
		return ejemplar;
	}

	public boolean create(Ejemplar ejemplar) {
		String sql = "INSERT INTO ejemplar( ID, Estado, ISBN )values( ?, ?, ? )";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, ejemplar.getId());
			ps.setString(2, ejemplar.getEstado());
			ps.setString(3, ejemplar.getISBN());
			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex);
			return false;
		}

		return true;
	}

	public boolean update(Ejemplar ejemplar) {
		String sql = "update ejemplar set Estado=?, ISBN=? where ID=?";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, ejemplar.getEstado());
			ps.setString(2, ejemplar.getISBN());
			ps.setInt(3, ejemplar.getId());
			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex);
			return false;
		}
		return true;
	}

	public boolean delete(int id) {
		String sql = "delete from ejemplar where ID=?";
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
