package controler.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetLoginPageCommand implements Command{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return "login.jsp";
	}

}
