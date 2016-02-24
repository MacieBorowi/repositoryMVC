package pl.spring.demo.service.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.entity.AuthorEntity;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.mapper.BookMapper;
import pl.spring.demo.repository.BookRepository;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

@Service
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

	@Autowired
	@Qualifier("bookRepository")
	private BookRepository bookRepository;

	@Override
	public List<BookTo> findAllBooks() {
		return BookMapper.map2To(bookRepository.findAll());
	}

	@Override
	public List<BookTo> findBooksByTitle(String title) {
		return BookMapper.map2To(bookRepository.findBookByTitle(title));
	}

	@Override
	public List<BookTo> findBooksByAuthor(String author) {
		return BookMapper.map2To(bookRepository.findBookByAuthor(author));
	}

	@Override
	@Transactional(readOnly = false)
	public BookTo saveBook(BookTo book) {
		BookEntity entity = BookMapper.map(book);
		entity = bookRepository.save(entity);
		return BookMapper.map(entity);
	}
	
	@Transactional(readOnly = false)
	public BookTo saveBook(String title, String Author) {
		List<AuthorEntity> authors = new ArrayList<>();
		authors.add(new AuthorEntity(0L, Author, null));
		BookEntity entity = new BookEntity(null, title, authors, null);
		entity = bookRepository.save(entity);
		return BookMapper.map(entity);
	}

	@Transactional(readOnly = false)
	private void removeBook(BookTo book) {
		bookRepository.delete(BookMapper.map(book));
	}

	@Override
	@Transactional(readOnly = false)
	public BookTo removeBookById(Long id) {
		BookTo book = BookMapper.map(bookRepository.getOne(id));
		if (book != null) {
			bookRepository.delete(BookMapper.map(book));
			return book;
		}
		return null;
	}

}
