package spring.chapter_04SpringAOP.aspect;


public class Mindreader{
	private String thoughts;
	
	public String getThoughts() {
		return thoughts;
	}

	public void interceptThoughts(String thoughts) {
		this.thoughts=thoughts;
		System.out.println("Mindreader==> Intercepting volunterr's thoughts: "+thoughts);
	}

}
