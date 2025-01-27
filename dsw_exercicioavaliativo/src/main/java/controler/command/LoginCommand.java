package controler.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dao.DatabaseUserImp;
import model.entity.Usuario;

public class LoginCommand implements Command{
	
	private static DatabaseUserImp daoUser = new DatabaseUserImp();

	public LoginCommand() {
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		var login = request.getParameter("login");
		var senha = request.getParameter("senha");
		
		
		
		Usuario user = new Usuario(login, senha); 
		boolean resultado = daoUser.cadastrarNovosUsuario(user);
		
		if (resultado) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return "front.do?action=logged";
		}else {
			request.setAttribute("error_login", false);
			return "front.do?action=getLoginForm";
		}

	}

}
