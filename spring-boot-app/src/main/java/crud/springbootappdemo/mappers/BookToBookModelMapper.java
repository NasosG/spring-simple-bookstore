package crud.springbootappdemo.mappers;

import crud.springbootappdemo.domain.Book;
import crud.springbootappdemo.enums.Category;
import crud.springbootappdemo.model.BookModel;
import org.springframework.stereotype.Component;

@Component
public class BookToBookModelMapper {

    public BookModel map(Book book) {
        BookModel bookModel = new BookModel();
        bookModel.setTitle(book.getTitle());
        bookModel.setAuthor(book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName());
        bookModel.setYear(book.getYear());
        bookModel.setId(book.getId());
        bookModel.setCategory(book.getCategory() != null ? book.getCategory() : Category.DEFAULT);
        bookModel.setAuthorLastName(book.getAuthor().getLastName());
        bookModel.setAuthorFirstName(book.getAuthor().getFirstName());
        bookModel.setPublicationDate(book.getPublicationDate());
        bookModel.setComments(book.getComments());
        return bookModel;
    }

}


