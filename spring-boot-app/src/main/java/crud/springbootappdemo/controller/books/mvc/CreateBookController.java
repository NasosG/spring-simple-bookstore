package crud.springbootappdemo.controller.books.mvc;

import crud.springbootappdemo.enums.Category;
import crud.springbootappdemo.forms.BookForm;
import crud.springbootappdemo.service.BookService;
import crud.springbootappdemo.utils.GlobalAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CreateBookController {
    private static final String BOOKS_FORM = "booksForm";
    private static final String BOOKS_CATEGORIES = "booksCategories";

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books/create")
    public String booksDynamic(Model model) {
        model.addAttribute(BOOKS_FORM, new BookForm());
        model.addAttribute(BOOKS_CATEGORIES, Category.values());
        return "pages/books_create";
    }

    @PostMapping(value = "/books/create")
    public String createBooks(Model model, @Valid @ModelAttribute(BOOKS_FORM) BookForm bookForm,
                              BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            // some kind of error handling here, perhaps add extra error messages to the model
            model.addAttribute(GlobalAttributes.ERROR_MESSAGE, "an error occurred");
            return "pages/books_create";
        }
        bookService.createBook(bookForm);
        return "redirect:/";
    }
}
