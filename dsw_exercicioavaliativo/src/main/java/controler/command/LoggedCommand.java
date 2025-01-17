package controler.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoggedCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		var session = request.getSession(false);
		boolean usuarioLogado = false;
		
		if (session != null) {
			usuarioLogado = true;
					
		}else {
			request.setAttribute("UsuarioLogado", false);
		}
		return "logged.jsp";
	}

}
