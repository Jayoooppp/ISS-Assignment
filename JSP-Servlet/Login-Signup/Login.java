

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")	
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			Connection connection = DBUtil.getConnection();
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			String query = "SELECT * FROM user WHERE email = ? AND password = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				response.sendRedirect("Welcome.jsp");
			}else {
				response.sendRedirect("Login.jsp?error=1");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			response.sendRedirect("Login.jsp?error=1");
		}
	}

}
