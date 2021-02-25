package crud.springbootappdemo.model;

import crud.springbootappdemo.enums.Category;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

public class BookModel {
    private String title;
    private String year;
    private String author;
    private String authorFirstName;
    private String authorLastName;
    private String authorId;
    private Long id;
    private Category category;
    private String comments;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publicationDate;

    public BookModel() {}

    public BookModel(String title, String year, String author) {
        this.title = title;
        this.year = year;
        this.author = author;
    }

    public BookModel(String title, String year, String author, String authorId, LocalDate publicationDate, Long id) {
        this.title = title;
        this.year = year;
        this.author = author;
        this.authorId = authorId;
        this.publicationDate = publicationDate;
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }
}
