package aashu;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/log")
public class LoginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String uN = req.getParameter("uname");
		String pW = req.getParameter("pword");
		UserBean ub = new LoginDAO().Login(uN, pW);
		if(ub==null) {
			req.setAttribute("msg", "Invalid login process");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			ServletContext sct = req.getServletContext();
			sct.setAttribute("ubean", ub);
			Cookie ck = new Cookie("fname", ub.getFname());
			res.addCookie(ck);
			req.getRequestDispatcher("LogSuccess.jsp").forward(req, res);
		}
	}
}
