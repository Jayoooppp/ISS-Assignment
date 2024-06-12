

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")	
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
try {
			
			Connection connection = DBUtil.getConnection();
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			
			String query = "INSERT INTO user(name,email,password) values(?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);
			
			int rowsAffected = preparedStatement.executeUpdate();
			
			if(rowsAffected > 0) {
				response.sendRedirect("Login.jsp?signup=success");
			}else {
				response.sendRedirect("Signup.jsp?error=1");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			response.sendRedirect("Signup.jsp?error=1");
		}
	}

}
