

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

@WebServlet("/sup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	response.setContentType("text/html");
	PrintWriter out=response.getWriter();

	String u=request.getParameter("uid");
	String p=request.getParameter("pass");
	String n=request.getParameter("nm");
	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/application","root","12345");	
			PreparedStatement ps=con.prepareStatement("insert into form values(?,?,?)");
			ps.setString(1, u);
			ps.setString(2, p);
			ps.setString(3, n);
					int x=0;
			x=ps.executeUpdate();
			if(x==0)
			{
				out.println("Data Not Inserted");
			}
			else
			{
					out.println("Welcome to the pagge and your signup Successful");
					response.sendRedirect("http://guptajimobiletech.blogspot.com/");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}
	

}







