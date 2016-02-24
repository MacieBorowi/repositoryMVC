package pl.spring.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRARY")
public class LibraryEntity {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "library_name", nullable = false, length = 50)
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "libraryName")
	private List<BookEntity> books;

	protected LibraryEntity() {
	}

	public LibraryEntity(long id, String name, List<BookEntity> books) {
		this.id = id;
		this.name = name;
		this.books = books;
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

	public List<BookEntity> getBooks() {
		return books;
	}

	public void setBooks(List<BookEntity> books) {
		this.books = books;
	}

}