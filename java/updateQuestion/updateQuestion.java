package updateQuestion;

public class updateQuestion {
	private String faculty;
	private String year;
	private String mcode;
	private String newQno;
	private String question;
	private String opt1;
	private String opt2;
	private String opt3;
	private String opt4;
	private String answer;
	
	public updateQuestion(String faculty, String year, String mcode, String newQno, String question, String opt1,
			String opt2, String opt3, String opt4, String answer) {
		
		this.faculty = faculty;
		this.year = year;
		this.mcode = mcode;
		this.newQno = newQno;
		this.question = question;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.opt4 = opt4;
		this.answer = answer;
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

	public String getNewQno() {
		return newQno;
	}

	public String getQuestion() {
		return question;
	}

	public String getOpt1() {
		return opt1;
	}

	public String getOpt2() {
		return opt2;
	}

	public String getOpt3() {
		return opt3;
	}

	public String getOpt4() {
		return opt4;
	}

	public String getAnswer() {
		return answer;
	}
	
	
	
}
