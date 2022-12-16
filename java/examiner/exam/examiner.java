package examiner.exam;

public class examiner {

	
	private int exID;
	private String faculty;
	private String year;
	private String filename;


	
	public examiner(int exID, String faculty, String year, String filename) {
		
		this.exID = exID;
		this.faculty = faculty;
		this.year = year;
		this.filename = filename;

	}



	public int getExID() {
		return exID;
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
