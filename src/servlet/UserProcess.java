package servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.*;

/**
 * Servlet implementation class UserProcess
 */
@WebServlet("/UserProcess")
public class UserProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("we are in server");
		String username =request.getParameter("userName");
		String password =request.getParameter("password");
		boolean userExist = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	  
			   
		Connection con;
		try {
		con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/movierecommendation","root","123456");
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("select * from users");
	    ResultSet result= (ResultSet) statement.executeQuery();
		String msg="Database is okay";
		request.setAttribute("msg", msg);
		
		while(result.next())
		{
			if((result.getString(2).equals(username))&&(result.getString(3).equals(password))){
				HttpSession session = request.getSession(true);
				session.setAttribute("login", true);
				session.setAttribute("control", "succeed");
			
                userExist=true;
				System.out.println("we are in server"+username);

			 response.sendRedirect("index.jsp");//eðer session baþlarsa index e gitcek tekrardan
			}
			
		}
	//	if(!userExist){
		//	
			//response.sendRedirect("index.jsp");
		//}
			 //   response.sendRedirect("/index.jsp?name=" + session.getAttribute(username));
		//	System.out.print("ess");ü
			// RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            //        dispatcher.forward(request,response);
		/*	 boolean ret=true;
			 }
		  
		  }
		  
		 if(!ret){
			 HttpSession session = request.getSession(true);
			 session.setAttribute("msg", "failed");
		 System.out.print("nooo");
			 String me ="Username or password is wrong";
			 request.setAttribute("message", me);
			  request.getRequestDispatcher("index.jsp").forward(request, response);
			  
			 
		*/ 	// response.sendRedirect("index.jsp");
		
		 
		
				
		
		// TODO Auto-generated method stub
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}
}

 
