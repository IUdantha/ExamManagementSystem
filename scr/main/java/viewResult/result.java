package viewResult;

public class result {
	private String id;
	private String sid;
	private String table;
	private String marks;
	
	
	public result(String id, String sid, String table, String marks) {
		this.id = id;
		this.sid = sid;
		this.table = table;
		this.marks = marks;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getSid() {
		return sid;
	}


	public void setSid(String sid) {
		this.sid = sid;
	}


	public String getTable() {
		return table;
	}


	public void setTable(String table) {
		this.table = table;
	}


	public String getMarks() {
		return marks;
	}


	public void setMarks(String marks) {
		this.marks = marks;
	}
	
	
	
	

}
