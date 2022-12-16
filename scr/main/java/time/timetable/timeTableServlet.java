package time.timetable;


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
@WebServlet("/timeTableServlet")
public class timeTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//To capture the data from the form and to save it
		//We use request method to save the data inside variables
		String faculty = request.getParameter("faculty"); //We use the name given in the form inside the parentheses 
		String year = request.getParameter("year");
		Part timetable = request.getPart("timetable");
		String filename = timetable.getSubmittedFileName();  //get selected file name
		
		String path = "D:/Lectures/03) Y2-S1/03 - OOP/Assignments/Assignment 02/Final project/ExamManagement/src/main/webapp/timetable/"+filename; //upload path, to where should the file upload
		File f = new File(path);
		try {
			
			//upload the file into the folder
			if(f.exists()) {
				JOptionPane.showMessageDialog(null, "Timetable already Exist!");
			}
			else {
				FileOutputStream fos = new FileOutputStream(path); 
				InputStream is = timetable.getInputStream();
				
				byte[] data = new byte[is.available()];
				is.read(data);
				fos.write(data);
				fos.close();
			}
			
			

			
			//Call the inserttimetablemethod in the timetableDBUtil
			//Use above variable names as argument names
			
			boolean isTrue; //To capture the return boolean value
			
			isTrue = timetableDBUtil.inserttimetable(faculty, year, filename);
			
			//check whether the db connection is successful
			if(isTrue == true) {
				
				RequestDispatcher dis = request.getRequestDispatcher("viewTimetable.jsp");
				dis.forward(request, response);
			}
			else {
				
				RequestDispatcher dis2 = request.getRequestDispatcher("uploadTimetable.jsp");
				dis2.forward(request, response);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		

		
	}

}

/*
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        //process only if its multipart content
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
               
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                    }
                }
            
               //File uploaded successfully
               request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
          
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
     
        request.getRequestDispatcher("/result.jsp").forward(request, response);
      
    }
   
}
*/