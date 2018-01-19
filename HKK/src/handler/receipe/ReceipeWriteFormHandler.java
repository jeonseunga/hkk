package handler.receipe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;

public class ReceipeWriteFormHandler implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		return "/HKK_receipe/receipewriteForm.jsp";
	}
}
