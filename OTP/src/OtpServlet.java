

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class OtpServlet
 */
@WebServlet("/OtpServlet")
public class OtpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public OtpServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String numbers = "1234567890";
	      Random random = new Random();
	      char[] ch = new char[4];

	      for(int i = 0; i< 4 ; i++) {
	         ch[i] = numbers.charAt(random.nextInt(numbers.length()));
	      }
	      	String otp = new String(ch);
	      	System.out.println(otp);
	      	HttpSession session=request.getSession(); 
	      	session.setAttribute("generatedOTP", otp);
	      	System.out.println(session);
	      	session.setMaxInactiveInterval(30);
	      	RequestDispatcher rd=request.getRequestDispatcher("secondpage.html");
	      	rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
