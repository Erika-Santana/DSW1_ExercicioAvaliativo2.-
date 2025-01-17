package controler.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterCommand implements Command{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		
		return "register.jsp";
	}

}
