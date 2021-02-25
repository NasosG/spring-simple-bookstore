package crud.springbootappdemo.controller.books.mvc;

import crud.springbootappdemo.enums.Category;
import crud.springbootappdemo.model.BookModel;
import crud.springbootappdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditBookController {
    private static final String BOOK_ATTR = "book";
    private static final String BOOKS_CATEGORIES = "booksCategories";

    @Autowired
    private BookService bookService;

    @PostMapping(value = "/books/{id}/delete")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping(value = "/books/{id}/edit")
    public String editBook(@PathVariable Long id, Model model) {
        BookModel bookModel = bookService.findBook(id).get();
        model.addAttribute(BOOK_ATTR, bookModel);
        model.addAttribute(BOOKS_CATEGORIES, Category.values());
        return "pages/books_edit";
    }

    @PostMapping(value = "/books/edit")
    public String editBook(BookModel bookModel) {
        bookService.updateBook(bookModel);
        return "redirect:/";
    }
}
