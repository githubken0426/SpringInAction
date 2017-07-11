package IoC.normal.bean;

public class Student {
	private String name;
	private String birthday;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String toString(){
		return "姓名:"+name+",生日："+birthday;
	}
}
