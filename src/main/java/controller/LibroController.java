package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Libro;
import modelDao.LibroDao;

/**
 * Servlet implementation class LibroController
 */
public class LibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String read = "views/libro/readLibro.jsp";
	String update = "views/libro/updateLibro.jsp";
	String create = "views/libro/createLibro.jsp";
	Libro libro = new Libro();
	LibroDao dao = new LibroDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibroController() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acceso = "";
		String accion = request.getParameter("accion");
		if (accion.equalsIgnoreCase("readLibro")) {
			acceso = read;
		} else if (accion.equalsIgnoreCase("createLibro")) {
			acceso = create;
		} else if (accion.equalsIgnoreCase("Crear")) {
			String Isbn = request.getParameter("txtIsbn");
			int N_Paginas = Integer.parseInt(request.getParameter("txtNPaginas")) ;
			String Titulo = request.getParameter("txtTitulo");
			String Editorial = request.getParameter("txtEditorial");
			int Id_Autor = Integer.parseInt(request.getParameter("txtIdAutor")) ;
			libro.setIsbn(Isbn);
			libro.setNum_pag(N_Paginas);
			libro.setTitulo(Titulo);
			libro.setEditorial(Editorial);
			libro.setId_autor(Id_Autor);
			dao.create(libro);
			acceso = read;
		} else if (accion.equalsIgnoreCase("updateLibro")) {
			request.setAttribute("id", request.getParameter("id"));
			acceso = update;
		} else if (accion.equalsIgnoreCase("Modificar")) {
			String Isbn = request.getParameter("txtIsbn");
			int N_Paginas = Integer.parseInt(request.getParameter("txtNPaginas")) ;
			String Titulo = request.getParameter("txtTitulo");
			String Editorial = request.getParameter("txtEditorial");
			int Id_Autor = Integer.parseInt(request.getParameter("txtIdAutor")) ;
			libro.setIsbn(Isbn);
			libro.setNum_pag(N_Paginas);
			libro.setTitulo(Titulo);
			libro.setEditorial(Editorial);
			libro.setId_autor(Id_Autor);
			dao.update(libro);
			acceso = read;
		} else if (accion.equalsIgnoreCase("deleteLibro")) {
			String Isbn = request.getParameter("id");
			dao.delete(Isbn);
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
