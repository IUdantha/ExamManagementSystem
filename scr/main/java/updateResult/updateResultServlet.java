package updateResult;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updateResultServlet
 */
@WebServlet("/updateResultServlet")
public class updateResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateResultServlet() {
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
		String rid = request.getParameter("rid");
		String sid = request.getParameter("sid");
		String qType = request.getParameter("qType");
		String marks = request.getParameter("marks");
		
		updateResult ur1 = new updateResult(rid, sid, qType, marks);
		
		updateResultDBUtil urdb1 = new updateResultDBUtil();
		urdb1.validate(ur1);
		
		RequestDispatcher dis = request.getRequestDispatcher("viewResult");
		dis.forward(request, response);
		
	}

}
