package ABC;

import java.io.IOException;
import java.sql.*;
import ABC.DBConnection;

import java.util.List;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ABC.User;
import ABC.students;
import ABC.UserDAO;

/**
 * Servlet implementation class login
 */

public class FaceIDservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
private UserDAO inter;
	
	public void init() {
		inter = new UserDAO();
	}
	Connection conn=null;
	public FaceIDservlet() {
		conn=DBConnection.ConnectDB();
	}
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getServletPath();
		try {
		switch(action)
		{
		case"/LogoutServlet":
			logoutservlet(request,response);
			break;
		case"/LoginServlet":
			loginservlet(request,response);
			break;
		case"/RegisterServlet":
			registrationservlet(request,response);
			break;
		case"/ForgetpassServlet":
			forgetpassservlet(request,response);
			break;
		case"/consulservlet":
			consulter(request, response);
			break;
		case"/absenceservlet":
			
			listUser(request,response);
			break;
		
		}
		}catch (SQLException ex) {
			throw new ServletException(ex);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	
	}
		private void loginservlet(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
			
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		User user=new User(name, password);
		UserDAO loguser = new UserDAO();
		
		if(loguser.userlog(user)==1) {
			HttpSession session = request.getSession();
            session.setAttribute("userlog", user);
            response.sendRedirect("welcome.jsp");
		}
		else {
			if(loguser.userlog(user)==2) {
				HttpSession session = request.getSession();
	            session.setAttribute("userlog", user);
	            response.sendRedirect("Welcome2.jsp");
	            }else {
			String errorMessage = "User not found";
		    HttpSession session = request.getSession();
		    session.setAttribute("logError", errorMessage);
			 response.sendRedirect("index.jsp");
			 }
		}
		}
		private void registrationservlet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			//make user object
			//User userModel = new User(name, email, password);
			int n = email.length();
			String c =email.substring(n - 12);
			if(c.equals(".p@esith.net") || c.equals(".s@esith.net")) {
			User user1 = new User(name,email,password);
			
			UserDAO regUser = new UserDAO();
			
				try {
					if (regUser.Userver(user1)) {
						String errorMessage = "User Available";
					    HttpSession regSession = request.getSession();
					    regSession.setAttribute("RegError", errorMessage);
					   response.sendRedirect("Registration.jsp");
					}
					else {
					  regUser.saveUser(user1);
					  response.sendRedirect("index.jsp");
					   }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}else {
					response.sendRedirect("Registration.jsp");
				}
		}
		private void forgetpassservlet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			User user = new User(name,email,password);
			UserDAO userpass = new UserDAO();
			
			try {
				if (userpass.updatepass(user)) {
					
				   response.sendRedirect("index.jsp");
				}
				else {
				  
				  response.sendRedirect("ForgetPassWord.jsp");
				   }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		private void logoutservlet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			HttpSession session = request.getSession();
	        session.removeAttribute("userlog");
	        response.sendRedirect("index.jsp");
			
		}
		
		
		private void listUser(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {

			String f=request.getParameter("filière");
			String m=request.getParameter("Module");
			
			
			if(f.equals("IMS3")) {
				students st=new students(f,m);
			
			
			
					List<students> listUser = inter.selectIMS3(st);
					request.setAttribute("listUser", listUser);
					RequestDispatcher dispatcher = request.getRequestDispatcher("AbsTable.jsp");
					dispatcher.forward(request, response);
					}else {
						  if(f.equals("IMS2")) {
							  students st=new students(f,m);
								
								
								
								List<students> listUser = inter.selectIMS2(st);
								request.setAttribute("listUser", listUser);
								RequestDispatcher dispatcher = request.getRequestDispatcher("AbsTable.jsp");
								dispatcher.forward(request, response);
						  }else {
							  students st=new students(f,m);
								
								
								
								List<students> listUser = inter.selectIMS1(st);
								request.setAttribute("listUser", listUser);
								RequestDispatcher dispatcher = request.getRequestDispatcher("AbsTable.jsp");
								dispatcher.forward(request, response);
						  }
						  
						   }
		}
		
		private void consulter(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			HttpSession session = request.getSession();
			User user=(User)session.getAttribute("userlog");
			List<students> listabs = inter.Consulter(user);
			request.setAttribute("listabs", listabs);
			RequestDispatcher dispatcher = request.getRequestDispatcher("consult.jsp");
			dispatcher.forward(request, response);
			
		}
		
}


