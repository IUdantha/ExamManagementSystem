package in.inquiry;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class CustomerInsert
 */
@MultipartConfig
@WebServlet("/inquiry")
public class uploadInquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//To capture the data from the form and to save it
		//We use request method to save the data inside variables
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");		
		String number = request.getParameter("number")	;	
		String faculty = request.getParameter("faculty");
		String year = request.getParameter("year"); //We use the name given in the form inside the parentheses 
		String inquirytype = request.getParameter("inquirytype");
		String message = request.getParameter("message");
		
		Part inquiry =  request.getPart("inquiry");
		String filename = inquiry.getSubmittedFileName();  //get selected file name
		
		String path = "C:/Projects/ExamManagement/src/main/webapp/inquiry/"+filename; //upload path, to where should the file upload
		File f = new File(path);
		
		
		try {
			
			if(f.exists()) {
				JOptionPane.showMessageDialog(null, "Timetable already Exist!");
			}
			else {
				FileOutputStream fos = new FileOutputStream(path); 
				InputStream is = inquiry.getInputStream();
				
				byte[] data = new byte[is.available()];
				is.read(data);
				fos.write(data);
				fos.close();
			}
			

			
			//Call the insert inquiry method in theinquiryDBUtil
			//Use above variable names as argument names
			
			boolean isTrue; //To capture the return boolean value
			
			isTrue = inquiryDBUtil.insertinquiry(name, email, number, faculty, year, inquirytype, message, filename);
			
			//check whether the db connection is successful
			if(isTrue == true) {
				
				RequestDispatcher dis = request.getRequestDispatcher("viewInquiry.jsp");
				dis.forward(request, response);
			}
			else {
				
				RequestDispatcher dis2 = request.getRequestDispatcher("uploadInquiry.jsp");
				dis2.forward(request, response);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		

		
	}

}

