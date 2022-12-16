package viewQuestion;

public class viewQuestion {
	private String faculty;
	private String year;
	private String mcode;
	
	
	public viewQuestion(String faculty, String year, String mcode) {
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
	
	public String createTableName() {
		String tableName = faculty + "_" + year + "_" + mcode;
		return tableName;
	}
	
}
