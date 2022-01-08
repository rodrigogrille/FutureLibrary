package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Autor;
import modelDao.AutorDao;

/**
 * Servlet implementation class AutorController
 */
public class AutorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String read = "views/autor/readAutor.jsp";
	String update = "views/autor/updateAutor.jsp";
	String create = "views/autor/createAutor.jsp";
	String delete = "views/autor/deleteAutor.jsp";
	Autor autor = new Autor();
	AutorDao dao = new AutorDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AutorController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acceso = "";
		String accion = request.getParameter("accion");
		if (accion.equalsIgnoreCase("readAutor")) {
			acceso = read;
		} else if (accion.equalsIgnoreCase("createAutor")) {
			acceso = create;
		} else if (accion.equalsIgnoreCase("Crear")) {
			int ID = Integer.parseInt(request.getParameter("txtID"));
			String Nombre = request.getParameter("txtNombre");
			autor.setId(ID);
			autor.setNombre(Nombre);
			dao.create(autor);
			acceso=read;
		} else if (accion.equalsIgnoreCase("updateAutor")) {
			request.setAttribute("id", request.getParameter("id"));
			System.out.println(request.getParameter("id"));
			acceso = update;
		} else if (accion.equalsIgnoreCase("Modificar")) {
			int ID = Integer.parseInt(request.getParameter("txtID"));
			String Nombre = request.getParameter("txtNombre");
			autor.setId(ID);
			autor.setNombre(Nombre);
			dao.update(autor);
			acceso=read;
		} else if (accion.equalsIgnoreCase("deleteAutor")) {
			int ID=Integer.parseInt(request.getParameter("id"));
			autor.setId(ID);
			dao.delete(ID);
			acceso=read;
			
		}
		RequestDispatcher view = request.getRequestDispatcher(acceso);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
