package deleteQuiz;

public class deleteQuiz {
	private String faculty;
	private String year;
	private String mcode;
	
	
	public deleteQuiz(String faculty, String year, String mcode) {
		this.faculty = faculty;
		this.year = year;
		this.mcode = mcode;
	}


	public String getFaculty() {
		return faculty;
	}


	public String getYear() {
		return year;
	}


	public String getMcode() {
		return mcode;
	}
}
