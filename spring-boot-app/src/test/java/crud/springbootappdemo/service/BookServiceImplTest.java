package crud.springbootappdemo.service;

import crud.springbootappdemo.domain.Author;
import crud.springbootappdemo.domain.Book;
import crud.springbootappdemo.enums.Category;
import crud.springbootappdemo.model.BookModel;
import crud.springbootappdemo.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doReturn;

@ActiveProfiles("test")
@SpringBootTest
class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;

    private static long BOOKID= 1L;
    private   Author author;

    @BeforeEach
    void doPreparation() {
        author = new Author("Vasilis", "Foufoutos",null);
    }

    @Test
    @DisplayName("Test findAll")
    void testFindAll() {
        // Setup our mock repository
        Book book1 = new Book("A book", "1950", author,  Category.DRAMA);
        Book book2 = new Book("A second book", "1970", author,  Category.COMEDY);
        doReturn(Arrays.asList(book1, book2)).when(bookRepository).findAll();

        List<BookModel> books = bookService.findAll();
        // Assert the response
        Assertions.assertEquals(2, books.size(), "findAll should return 2 books");
        Assertions.assertEquals(Arrays.asList(book1, book2), books, "Not equal lists");
        Assertions.assertSame(Arrays.asList(book1, book2), books, "Not same lists");
    }

}