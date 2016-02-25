package pl.spring.demo.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookRestService {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books-by-title", method = RequestMethod.GET)
    public List<BookTo> findBooksByTitle(@RequestParam("titlePrefix") String titlePrefix) {
        return bookService.findBooksByTitle(titlePrefix);
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public BookTo saveBook(@RequestBody BookTo book) {
        return bookService.saveBook(book);
    }
    
    @RequestMapping(value = "/book", method = RequestMethod.DELETE)
	public void removeBook(@RequestBody Long id) {
		bookService.removeBookById(id);
	}
    
	@RequestMapping(value = "/book", method = RequestMethod.PUT)
	public BookTo bookUpdate(@RequestBody BookTo book) {
		return bookService.saveBook(book);
	}

	@RequestMapping(value = "/book/{bookId}", method = RequestMethod.DELETE)
	public void deleteBook(@PathVariable("bookId") long bookId) {
		bookService.removeBookById(bookId);
	}
	
	//Poster
	//Content-Type	application/json
	//http://localhost:9721/workshop/book
	//{"id":8,"title":"Dra","authors":"Zbignielhvcvrvrrevfwak"}
}
