package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import modelDao.ClienteDao;

/**
 * Servlet implementation class ClienteController
 */
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String read = "views/cliente/readCliente.jsp";
	String update = "views/cliente/updateCliente.jsp";
	String create = "views/cliente/createCliente.jsp";
	Cliente cliente = new Cliente();
	ClienteDao dao = new ClienteDao();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acceso = "";
		String accion = request.getParameter("accion");
		if (accion.equalsIgnoreCase("readCliente")) {
			acceso = read;
		} else if (accion.equalsIgnoreCase("createCliente")) {
			acceso = create; 
		} else if (accion.equalsIgnoreCase("Crear")) {
			String DNI =request.getParameter("txtDNI");
			String Nombre = request.getParameter("txtNombre");
			int Telefono = Integer.parseInt(request.getParameter("txtTelefono"));
			String Direccion = request.getParameter("txtDireccion");
			String Correo = request.getParameter("txtCorreo");
			cliente.setDni(DNI);
			cliente.setNombre(Nombre);
			cliente.setTelefono(Telefono);
			cliente.setDireccion(Direccion);
			cliente.setCorreo(Correo);
			dao.create(cliente);
			acceso=read;
		} else if (accion.equalsIgnoreCase("updateCliente")) {
			request.setAttribute("id", request.getParameter("id"));
			acceso = update;
		} else if (accion.equalsIgnoreCase("Modificar")) {
			String DNI =request.getParameter("txtDNI");
			String Nombre = request.getParameter("txtNombre");
			int Telefono = Integer.parseInt(request.getParameter("txtTelefono"));
			String Direccion = request.getParameter("txtDireccion");
			String Correo = request.getParameter("txtCorreo");
			cliente.setDni(DNI);
			cliente.setNombre(Nombre);
			cliente.setTelefono(Telefono);
			cliente.setDireccion(Direccion);
			cliente.setCorreo(Correo);
			dao.update(cliente);
			acceso=read;
		} else if (accion.equalsIgnoreCase("deleteCliente")) {
			String DNI =request.getParameter("id");
			dao.delete(DNI);
			acceso=read;
			
		}
		RequestDispatcher view = request.getRequestDispatcher(acceso);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
