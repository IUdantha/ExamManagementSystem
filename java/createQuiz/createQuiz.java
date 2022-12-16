package createQuiz;

public class createQuiz {
	private String faculty;
	private String year;
	private String mcode;
	private String noQ;
	private String enrollKey;
	private String quizPass;
	
	
	public createQuiz(String faculty, String year, String mcode, String noQ, String enrollKey, String quizPass) {
		this.faculty = faculty;
		this.year = year;
		this.mcode = mcode;
		this.noQ = noQ;
		this.enrollKey = enrollKey;
		this.quizPass = quizPass;
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
	
	public String getNoQ() {
		return noQ;
	}


	public String getEnrollKey() {
		return enrollKey;
	}


	public String getQuizPass() {
		return quizPass;
	}
	
}
