

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DS")
public class DeleteSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out=response.getWriter();
HttpSession s= request.getSession();
String id=(String)s.getAttribute("ukey");

try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/application","root","12345");
	PreparedStatement ps=con.prepareStatement("delete from form where sid=?");
	ps.setString(1, id);
	int i=0;
	i=ps.executeUpdate();
	if(i==0)
	{
		response.sendRedirect("Login.html");
	}
	else
	{
		out.println("your account is successfully deleted");
		
	}
	}
catch(Exception e)
{
e.printStackTrace();	
}
}
	}


