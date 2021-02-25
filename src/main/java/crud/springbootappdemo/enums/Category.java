package crud.springbootappdemo.enums;

public enum Category {
    DEFAULT("Undefined"),
    COMEDY("Comedy"),
    DRAMA("Drama"),
    ACTION_ADVENTURE("Action and Adventure"),
    HISTORICAL_FICTION("Historical Fiction"),
    HORROR_FICTION("Horror Fiction"),
    LITERARY_REALISM("Literary Realism"),
    DETECTIVE_MYSTERY("Detective and Mystery"),
    ROMANCE("Romance"),
    SATIRE("Satire"),
    TRAGEDY("Tragedy"),
    TRAGICOMEDY("Tragicomedy"),
    FANTASY("Fantasy"),
    MYTHOLOGY("Mythology");

    private String bookCategoryFullName;

    Category(String bookCategoryFullName) {
        this.bookCategoryFullName = bookCategoryFullName;
    }

    public String getBookCategoryFullName() {
        return bookCategoryFullName;
    }
}
