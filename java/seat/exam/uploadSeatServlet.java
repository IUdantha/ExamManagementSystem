package seat.exam;



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
 * Servlet implementation class uploadSeatServlet
 */
@MultipartConfig
@WebServlet("/uploadSeatServlet")
public class uploadSeatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//To capture the data from the form and to save it
		//We use request method to save the data inside variables
	
		String faculty = request.getParameter("faculty");
		String year = request.getParameter("year");
		Part seat = request.getPart("seat");
		String filename = seat.getSubmittedFileName();
	 //get selected file name
		
		System.out.println(faculty);
		System.out.println(seat);
		
		String path = "C:/Projects/ExamManagement/src/main/webapp/seat/"+filename; //upload path, to where should the file upload
		File f = new File(path);
		try {
			
			//upload the file into the folder
			if(f.exists()) {
				JOptionPane.showMessageDialog(null, "Seat Arrangements already Exist!");
			}
			else {
				FileOutputStream fos = new FileOutputStream(path); 
				InputStream is = seat.getInputStream();
				
				byte[] data = new byte[is.available()];
				is.read(data);
				fos.write(data);
				fos.close();
			}
			
			

			
			//Call the inserttimetablemethod in the timetableDBUtil
			//Use above variable names as argument names
			
			boolean isTrue; //To capture the return boolean value
			
			isTrue = seatDBUtil.insertseat(faculty, year, filename);
			
			//check whether the db connection is successful
			if(isTrue == true) {
				
				RequestDispatcher dis = request.getRequestDispatcher("viewSeat.jsp");
				dis.forward(request, response);
			}
			else {
				
				RequestDispatcher dis2 = request.getRequestDispatcher("uploadSeat.jsp");
				dis2.forward(request, response);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		

		
	}
}
