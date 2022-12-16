package addQuestion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import createQuiz.createQuizDBUtil;

/**
 * Servlet implementation class addQuestionServlet
 */
@WebServlet("/addQuestionServlet")
public class addQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get user data from insertQuestion.jsp file and load to parameters
		String question = request.getParameter("question");
		String opt1 = request.getParameter("opt1");
		String opt2 = request.getParameter("opt2");
		String opt3 = request.getParameter("opt3");
		String opt4 = request.getParameter("opt4");
		String answer = request.getParameter("answer");
		
		//pass data to addQuestion.java class using constructor
		addQuestion aq1 = new addQuestion(question, opt1, opt2, opt3, opt4, answer);
		
		//call validate method in addQuestionDBUtil.java class
		addQuestionDBUtil aqdb1 = new addQuestionDBUtil();
		aqdb1.validate(aq1);
	
		//Redirect to insertQuestion.jsp page
		RequestDispatcher dis = request.getRequestDispatcher("insertQuestion.jsp");
		dis.forward(request, response);	
	}

}
