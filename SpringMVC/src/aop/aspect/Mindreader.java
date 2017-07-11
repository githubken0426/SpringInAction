package aop.aspect;


public class Mindreader{
	private String thoughts;
	
	public String getThoughts() {
		return thoughts;
	}

	public void interceptThoughts(String thoughts) {
		this.thoughts=thoughts;
		System.out.println("Mindreader==> Intercepting volunter's thoughts: "+thoughts);
	}

}
