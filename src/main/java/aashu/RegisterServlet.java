package aashu;
import org.apache.catalina.mbeans.UserMBean;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) {
		try {
			UserBean b = new UserBean();
			b.setUname(req.getParameter("uname"));
			b.setPword(req.getParameter("pword"));
			b.setFname(req.getParameter("fname"));
			b.setlName(req.getParameter("lname"));
			b.setAddr(req.getParameter("addr"));
			b.setMid(req.getParameter("mid"));
			b.setPhno(Long.parseLong(req.getParameter("phno")));
			RegisterDAO re = new RegisterDAO();
			int k = re.register(b);
			if(k>0) {
				req.setAttribute("msg", "User register successfully...<br>");
				req.getRequestDispatcher("RegSuccess.jsp").forward(req, res);
				
			}
		}catch(Exception e) {e.printStackTrace();}
	}
}
