package pl.spring.demo.repository.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.repository.BookRepository;

public class BookRepositoryImpl extends AbstractRepository<BookEntity, Long> implements BookRepository {

	@Override
	public List<BookEntity> findBookByTitle(String title) {
		TypedQuery<BookEntity> query = entityManager.createQuery(
				"select book from BookEntity book where upper(book.title) like concat(upper(:title), '%')",
				BookEntity.class);
		query.setParameter("title", title);
		return query.getResultList();
	}

	@Override
	public List<BookEntity> findBookByAuthor(String name) {
		TypedQuery<BookEntity> query = entityManager.createQuery(
				"select book from BookEntity book join book.authors author where upper(author.firstName) like concat(upper(:name), '%') or upper(author.lastName) like concat(upper(:name), '%')",
				BookEntity.class);
		query.setParameter("name", name);
		return query.getResultList();
	}

}
