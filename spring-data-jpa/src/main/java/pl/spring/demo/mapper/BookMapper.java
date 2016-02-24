package pl.spring.demo.mapper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import pl.spring.demo.entity.AuthorEntity;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.LibraryEntity;
import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookTo;
import pl.spring.demo.to.LibraryTo;

public class BookMapper {

	public static BookTo map(BookEntity bookEntity) {
		if (bookEntity != null) {
			List<AuthorTo> authors = bookEntity.getAuthors().stream().map(BookMapper::map).collect(Collectors.toList());
			return new BookTo(bookEntity.getId(), bookEntity.getTitle(), authors, map(bookEntity.getLibraryName()));
		}
		return null;
	}

	public static BookEntity map(BookTo bookTo) {
		if (bookTo != null) {
			List<AuthorEntity> authors = bookTo.getAuthors().stream().map(BookMapper::map).collect(Collectors.toList());
			return new BookEntity(bookTo.getId(), bookTo.getTitle(), authors, map(bookTo.getLibraryName()));
		}
		return null;
	}

	public static LibraryTo map(LibraryEntity libraryEntity) {
		if (libraryEntity != null) {
			return new LibraryTo(libraryEntity.getId(), libraryEntity.getName());
		}
		return null;
	}

	public static LibraryEntity map(LibraryTo libraryTo) {
		if (libraryTo != null) {
			return new LibraryEntity(libraryTo.getId(), libraryTo.getName(), null);
		}
		return null;
	}

	public static AuthorTo map(AuthorEntity authorEntity) {
		if (authorEntity != null) {
			return new AuthorTo(authorEntity.getId(), authorEntity.getFirstName(), authorEntity.getLastName());
		}
		return null;
	}

	public static AuthorEntity map(AuthorTo authorTo) {
		if (authorTo != null) {
			return new AuthorEntity(authorTo.getId(), authorTo.getFirstName(), authorTo.getLastName());
		}
		return null;
	}
	
	public static String mapAuthors(List<AuthorTo> authorsTo) {
		if (authorsTo != null) {
			String autors="";
			for (AuthorTo author : authorsTo) {
				autors += author.getFirstName() + " " + author.getLastName()+";";   
			}
			return autors;
		}
		return null;
	}
	
	public static List<AuthorTo> mapAuthors(String authors) {
		if (authors != null) {
			List<AuthorTo> authorsTo = new ArrayList<>();
			String[] nameTable = authors.split(" ");
			for(int i =0; i < nameTable.length; i+=2){
				authorsTo.add(BookMapper.map(new AuthorEntity(0L, nameTable[i],nameTable[i+1])));
			}
			return authorsTo;
		}
		return null;
	}

	public static List<BookTo> map2To(List<BookEntity> bookEntities) {
		return bookEntities.stream().map(BookMapper::map).collect(Collectors.toList());
	}

	public static List<BookEntity> map2Entity(List<BookTo> bookEntities) {
		return bookEntities.stream().map(BookMapper::map).collect(Collectors.toList());
	}
}
