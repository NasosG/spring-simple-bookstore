package crud.springbootappdemo.controller.books.restTest;

import crud.springbootappdemo.domain.Book;
import crud.springbootappdemo.model.BookModel;
import crud.springbootappdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class BookRestController {

    @Autowired
    private BookService bookService;

    @GetMapping("books")
    public List<BookModel> getBooks() {
        return bookService.findAll();
    }

    @GetMapping("books/{id}")
    public BookModel getBookById(@PathVariable String id) {
        Optional<BookModel> bookOptional = bookService.findBook(Long.parseLong(id));
        return bookOptional.orElse(null);
    }

    @PostMapping("books")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }
}
