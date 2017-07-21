package aop.aspect;


public class Mindreader{
	private String thoughts;
	
	public String getThoughts() {
		return thoughts;
	}

	public void interceptThoughts(String thoughts) {
		this.thoughts=thoughts;
		System.out.println(Mindreader.class.getCanonicalName()+"==> 获取参数值: "+thoughts);
	}

}
