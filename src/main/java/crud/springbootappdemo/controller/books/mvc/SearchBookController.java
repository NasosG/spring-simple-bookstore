package crud.springbootappdemo.controller.books.mvc;

import crud.springbootappdemo.forms.SearchForm;
import crud.springbootappdemo.model.BookModel;
import crud.springbootappdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class SearchBookController {

    private static final String BOOKS_LIST = "books";

    @Autowired
    private BookService bookService;

    @GetMapping("/search")
    public String searchTest(Model model) {
        model.addAttribute("searchForm", new SearchForm());
        return "pages/books_search";
    }

    @PostMapping("/search")
    public String searchTest(@ModelAttribute("searchForm") SearchForm searchForm, Model model, @RequestParam(value = "author", defaultValue = "") String author) {


        String authorsName = author.isEmpty() ? author : null;
        List<BookModel> books = bookService.findByAuthorContaining(authorsName);
        if (!books.isEmpty()) model.addAttribute(BOOKS_LIST, books);

        return "pages/books_dynamic";
    }
}
