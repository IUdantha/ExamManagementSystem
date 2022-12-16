package seat.exam;

public class seat {

	
	private int saID;
	private String faculty;
	private String year;
	private String filename;


	
	public seat(int saID, String faculty, String year, String filename) {
		
		this.saID = saID;
		this.faculty = faculty;
		this.year = year;
		this.filename = filename;

	}



	public int getSaID() {
		return saID;
	}



	public String getFaculty() {
		return faculty;
	}



	public String getYear() {
		return year;
	}


	public String getFilename() {
		return filename;
	}

	
}
