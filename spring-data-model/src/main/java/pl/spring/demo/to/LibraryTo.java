package pl.spring.demo.to;

public class LibraryTo {
	private long id;
	private String name;

	public LibraryTo() {

	}

	public LibraryTo(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}