package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ejemplar;
import modelDao.EjemplarDao;

/**
 * Servlet implementation class EjemplarController
 */
public class EjemplarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String read = "views/ejemplar/readEjemplar.jsp";
	String update = "views/ejemplar/updateEjemplar.jsp";
	String create = "views/ejemplar/createEjemplar.jsp";
	Ejemplar ejemplar = new Ejemplar();
	EjemplarDao dao = new EjemplarDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EjemplarController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acceso = "";
		String accion = request.getParameter("accion");
		if (accion.equalsIgnoreCase("readEjemplar")) {
			acceso = read;
		} else if (accion.equalsIgnoreCase("createEjemplar")) {
			acceso = create;
		} else if (accion.equalsIgnoreCase("Crear")) {
			int ID = Integer.parseInt(request.getParameter("txtId")) ;
			String Estado = request.getParameter("txtEstado");
			String ISBN = request.getParameter("txtISBN");
			ejemplar.setId(ID);
			ejemplar.setEstado(Estado);
			ejemplar.setISBN(ISBN);
			dao.create(ejemplar);
			acceso = read;
		} else if (accion.equalsIgnoreCase("updateEjemplar")) {
			request.setAttribute("id", request.getParameter("id"));
			acceso = update;
		} else if (accion.equalsIgnoreCase("Modificar")) {
			int ID = Integer.parseInt(request.getParameter("txtId")) ;
			String Estado = request.getParameter("txtEstado");
			String ISBN = request.getParameter("txtISBN");
			ejemplar.setId(ID);
			ejemplar.setEstado(Estado);
			ejemplar.setISBN(ISBN);
			dao.update(ejemplar);
			acceso = read;
		} else if (accion.equalsIgnoreCase("deleteEjemplar")) {
			int ID = Integer.parseInt(request.getParameter("id"));
			dao.delete(ID);
			acceso = read;
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
