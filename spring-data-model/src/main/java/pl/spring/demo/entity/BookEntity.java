package pl.spring.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class BookEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, length = 50)
	private String title;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "BOOK_AUTHOR", joinColumns = {
			@JoinColumn(name = "id_book", updatable = false, nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id_author", updatable = false, nullable = false) })
	private List<AuthorEntity> authors;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "library_id", nullable = false)
	private LibraryEntity libraryName;

	protected BookEntity() {
	}

	public BookEntity(Long id, String title, List<AuthorEntity> authors, LibraryEntity libraryName) {
		this.id = id;
		this.title = title;
		this.authors = authors;
		this.libraryName = libraryName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<AuthorEntity> getAuthors() {
		return authors;
	}

	public void setAuthors(List<AuthorEntity> authors) {
		this.authors = authors;
	}

	public LibraryEntity getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(LibraryEntity libraryName) {
		this.libraryName = libraryName;
	}

}