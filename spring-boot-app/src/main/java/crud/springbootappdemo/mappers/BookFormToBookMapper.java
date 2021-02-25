package crud.springbootappdemo.mappers;


import crud.springbootappdemo.domain.Author;
import crud.springbootappdemo.domain.Book;
import crud.springbootappdemo.enums.Category;
import crud.springbootappdemo.forms.BookForm;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class BookFormToBookMapper {

    public Book map(BookForm bookForm) {
        Book book = new Book();
        book.setTitle(bookForm.getTitle());
        book.setYear(bookForm.getYear());
        book.setAuthor(new Author(bookForm.getAuthorFirstName(), bookForm.getAuthorLastName()));
        book.setPublicationDate(parseLocalDateFromString(bookForm.getPublicationDate()));
        book.setCategory(Category.valueOf(bookForm.getCategory()));
        return book;
    }

    private LocalDate parseLocalDateFromString(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);
    }

}
