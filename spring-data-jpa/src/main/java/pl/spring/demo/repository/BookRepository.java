package pl.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.spring.demo.entity.BookEntity;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    @Query("select book from BookEntity book where upper(book.title) like concat(upper(:title), '%')")
    public List<BookEntity> findBookByTitle(@Param("title") String title);

    @Query("select book from BookEntity book join book.authors author where upper(author.firstName) like concat(upper(:name), '%') or upper(author.lastName) like concat(upper(:name), '%')")
	public List<BookEntity> findBookByAuthor(@Param("name") String name);
    
//    @Query("select book from BookEntity book where upper(book.authors) like concat('%', upper(:author), '%')")
//    public List<BookEntity> findBookByAuthor(@Param("author") String author);
}
