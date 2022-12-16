package addQuestion;

public class addQuestion {
	private String question;
	private String opt1;
	private String opt2;
	private String opt3;
	private String opt4;
	private String answer;
	
	public addQuestion(String question, String opt1, String opt2, String opt3, String opt4, String answer) {
		this.question = question;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.opt4 = opt4;
		this.answer = answer;
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
