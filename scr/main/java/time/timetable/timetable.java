
package time.timetable;


public class timetable {
	private int ttID;
	private String faculty;
	private String year;
	private String filename;


	
	public timetable(int ttID, String faculty, String year, String filename) {
		
		this.ttID = ttID;
		this.faculty = faculty;
		this.year = year;
		this.filename = filename;

	}


	public int getTtID() {
		return ttID;
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
