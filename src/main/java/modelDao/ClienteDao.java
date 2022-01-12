package modelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.Conection;
import model.Autor;
import model.Cliente;

public class ClienteDao {
	Conection cn = new Conection();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public ClienteDao() {
	}

	public List<Cliente> read() {
		ArrayList<Cliente> list = new ArrayList<>();
		String sql = "select * from cliente";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setDni(rs.getString("DNI"));
				cliente.setNombre(rs.getString("Nombre"));
				cliente.setTelefono(rs.getInt("Telefono"));
				cliente.setDireccion(rs.getString("Direccion"));
				cliente.setCorreo(rs.getString("Correo"));
				list.add(cliente);
			}
		} catch (Exception e) {
		}
		return list;
	}

	public Cliente read(String id) {
		String sql = "select * from cliente where DNI=?";
		Cliente cliente = new Cliente();
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				cliente.setDni(rs.getString("DNI"));
				cliente.setNombre(rs.getString("Nombre"));
				cliente.setTelefono(rs.getInt("Telefono"));
				cliente.setDireccion(rs.getString("Direccion"));
				cliente.setCorreo(rs.getString("Correo"));
			}
		} catch (Exception e) {

		}
		return cliente;
	}

	public boolean create(Cliente cliente) {
		String sql = "INSERT INTO cliente(DNI, Nombre, Telefono, Direccion, Correo)values( ?, ?, ?, ?, ? )";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getDni());
			ps.setString(2, cliente.getNombre());
			ps.setInt(3, cliente.getTelefono());
			ps.setString(4, cliente.getDireccion());
			ps.setString(5, cliente.getCorreo());
			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex);
			return false;
		}

		return true;
	}

	public boolean update(Cliente cliente) {
		String sql = "update cliente set Nombre=?, Telefono=?, Direccion=?, Correo=? where DNI = ?";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getNombre());
			ps.setInt(2, cliente.getTelefono());
			ps.setString(3, cliente.getDireccion());
			ps.setString(4, cliente.getCorreo());
			ps.setString(5, cliente.getDni());
			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex);
			return false;
		}
		return true;
	}

	public boolean delete(String id) {
		String sql = "delete from cliente where DNI=?";
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
