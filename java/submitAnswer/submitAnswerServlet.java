package submitAnswer;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class submitAnswerServlet
 */
@WebServlet("/submitAnswerServlet")
public class submitAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public submitAnswerServlet() {
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
		String table = request.getParameter("table");
		String sid = request.getParameter("sid");
		
		System.out.println("snum " + sid + " - " + table);
		ArrayList<String> answers = new ArrayList<String>();
		
		
		submitAnswerDBUtil sadb1 = new submitAnswerDBUtil();
		int noQ = sadb1.noQtable(table);
		
//		System.out.println("Number is there : " + sadb1.noQtable(table));

		for (int i = 1; i <= noQ; i++) {
			String qs1 = request.getParameter(Integer.toString(i));
			answers.add(qs1);
		}
		
		int marks = sadb1.qValidate(answers, table);
		System.out.println("Marks :" + marks);
		
		
		//add final marks with sid to the database
		sadb1.storeMarks(sid, table, marks);

		
		RequestDispatcher dis = request.getRequestDispatcher("Home.jsp");
		dis.forward(request, response);	
		
		
	}

}
