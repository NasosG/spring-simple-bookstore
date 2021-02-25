package crud.springbootappdemo.service;

import crud.springbootappdemo.domain.Author;
import crud.springbootappdemo.domain.Book;
import crud.springbootappdemo.forms.BookForm;
import crud.springbootappdemo.mappers.BookFormToBookMapper;
import crud.springbootappdemo.mappers.BookToBookModelMapper;
import crud.springbootappdemo.model.BookModel;
import crud.springbootappdemo.repository.AuthorRepository;
import crud.springbootappdemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookToBookModelMapper bookModelMapper;

    @Autowired
    private BookFormToBookMapper bookMapper;

    @Override
    public BookModel createBook(BookForm bookForm) {
        Book book = bookMapper.map(bookForm);

        Optional<Author> authorOptional = authorRepository.findAuthorByFirstNameAndLastName(bookForm.getAuthorFirstName(), bookForm.getAuthorLastName());
        if (authorOptional.isPresent() ) {
            Author author = authorOptional.get();
            List<Book> authorBooks = author.getBooks();
            authorBooks.add(book);
            authorRepository.save(author);
        }

        Book newBook = bookRepository.save(book);
        return bookModelMapper.map(newBook);
    }

    @Override
    public BookModel updateBook(BookModel bookModel) {
        Book originalBook = bookRepository.findById(bookModel.getId()).get();

        originalBook.setYear(String.valueOf(bookModel.getPublicationDate().getYear()));
        originalBook.setTitle(bookModel.getTitle());
        originalBook.setPublicationDate(bookModel.getPublicationDate());
        originalBook.setCategory(bookModel.getCategory());
        originalBook.setComments(bookModel.getComments());

        Book newBook = bookRepository.save(originalBook);
        return bookModelMapper.map(newBook);
    }

    @Override
    public Optional<BookModel> findBook(Long id) {
        return bookRepository
                .findById(id)
                .map(book -> bookModelMapper.map(book));
    }

    @Override
    public List<BookModel> findAll() {
        return bookRepository
                .findAll()
                .stream()
                .map(book -> bookModelMapper.map(book))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookModel> findByAuthorContaining(String name) {
        return bookRepository
                .findByAuthorContaining(String.valueOf(name))
                .stream()
                .map(book -> bookModelMapper.map(book))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitleContaining(title);
    }

    @Override
    public Book findOldestBook() {
        return bookRepository.findOldestBook();
    }

    @Override
    public Book addBook(Book book) {
        if (book == null) return null;
        return bookRepository.save(book);
    }

}
