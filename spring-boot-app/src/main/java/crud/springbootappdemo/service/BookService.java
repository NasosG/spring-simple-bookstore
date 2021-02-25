package crud.springbootappdemo.service;

import crud.springbootappdemo.domain.Author;
import crud.springbootappdemo.domain.Book;
import crud.springbootappdemo.forms.BookForm;
import crud.springbootappdemo.model.BookModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookService {

    BookModel createBook(BookForm bookForm);

    BookModel updateBook(BookModel bookModel);

    Optional<BookModel> findBook(Long id);

    List<BookModel> findAll();

    List<BookModel> findByDate(LocalDate date);

    void deleteById(Long id);

    Book addBook(Book book);

    List<Book> findByTitle(String title);

    Book findOldestBook();

    List<Book> findByAuthor(Author author);

    List<BookModel> findByAuthorContaining(String name);

}
