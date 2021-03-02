package crud.springbootappdemo.controller.books.mvc;

import crud.springbootappdemo.model.BookModel;
import crud.springbootappdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.faces.bean.ManagedBean;
import java.util.List;

@Controller
public class BookController {
    private static final String BOOKS_LIST = "books";

    @Autowired
    private BookService bookService;

    @GetMapping(value ="/")
    public String getBooks(Model model) {
        List<BookModel> books = bookService.findAll();
        model.addAttribute(BOOKS_LIST, books);
        return "pages/books_dynamic";
    }


}
