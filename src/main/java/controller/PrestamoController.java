package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DateValidation;
import model.Prestamo;
import modelDao.PrestamoDao;



/**
 * Servlet implementation class PrestamoController
 */
public class PrestamoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String read = "views/prestamo/readPrestamo.jsp";
	String update = "views/prestamo/updatePrestamo.jsp";
	String create = "views/prestamo/createLibro.jsp";
	Prestamo prestamo = new Prestamo();
	PrestamoDao dao = new PrestamoDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrestamoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acceso = "";
		String accion = request.getParameter("accion");
		if (accion.equalsIgnoreCase("readPrestamo")) {
			acceso = read;
		} else if (accion.equalsIgnoreCase("createPrestamo")) {
			acceso = create;
		} else if (accion.equalsIgnoreCase("Crear")) {
			String DNI = request.getParameter("txtDni");
			int ID = Integer.parseInt(request.getParameter("txtId")) ;
			String Fecha_inicio = request.getParameter("txtFechaInicio");
			String Fecha_fin = request.getParameter("txtFechaFin");
			prestamo.setDni(DNI);
			prestamo.setId(ID);
			prestamo.setFecha_inicio(DateValidation.getDate(Fecha_inicio));
			prestamo.setFecha_fin(DateValidation.getDate(Fecha_fin));
			dao.create(prestamo);
			acceso = read;
		} else if (accion.equalsIgnoreCase("updatePrestamo")) {
			request.setAttribute("dni", request.getParameter("dni"));
			request.setAttribute("id", request.getParameter("id"));
			request.setAttribute("fechainicio", request.getParameter("fechainicio"));
			acceso = update;
		} else if (accion.equalsIgnoreCase("Modificar")) {
			String DNI = request.getParameter("txtDni");
			int ID = Integer.parseInt(request.getParameter("txtId")) ;
			String Fecha_inicio = request.getParameter("txtFechaInicio");
			String Fecha_fin = request.getParameter("txtFechaFin");
			prestamo.setDni(DNI);
			prestamo.setId(ID);
			prestamo.setFecha_inicio(DateValidation.getDate(Fecha_inicio));
			prestamo.setFecha_fin(DateValidation.getDate(Fecha_fin));
			dao.update(prestamo);
			acceso = read;
		} else if (accion.equalsIgnoreCase("deletePrestamo")) {
			String DNI = request.getParameter("dni");
			int ID = Integer.parseInt(request.getParameter("id"));
			Date fecha_inicio = DateValidation.getDate(request.getParameter("fechainicio"));
			dao.delete(DNI);
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
