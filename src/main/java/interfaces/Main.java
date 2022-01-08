package interfaces;

import java.util.List;

import model.Autor;
import modelDao.AutorDao;

public class Main {

	public static void main(String[] args) {
		AutorDao dao = new AutorDao();
		Autor autor = dao.read(1);
		System.out.println(autor.toString());
	}

}
