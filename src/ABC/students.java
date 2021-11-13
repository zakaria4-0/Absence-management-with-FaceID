package ABC;

public class students {
	
	
	int id;
	String name;
	String option;
	String module;
	String date;
	
	public students() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public students(int id, String name, String module, String date) {
		super();
		this.id = id;
		this.name = name;
		this.module = module;
		this.date = date;
	}



	public students(int id, String name, String option, String module, String date) {
		super();
		this.id = id;
		this.name = name;
		this.option = option;
		this.module = module;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public students(String option, String module) {
		super();
		this.option = option;
		this.module = module;
	}

	
	
	
	
	
	
	
	
	
	

}
