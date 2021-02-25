package crud.springbootappdemo.domain;

import javax.persistence.*;
import java.util.List;

@Entity
// made the combination or username-lastname unique also, but I don't know if it's the best idea as
// many authors with same first name and last name may exist
@Table(name = "AUTHOR", uniqueConstraints = {@UniqueConstraint(columnNames = {"firstname", "lastname"})})
public class Author {

    private static final int MAX_NAME_LENGTH = 60;

    @Id
    @Column(name = "author_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname", length = MAX_NAME_LENGTH)
    private String firstName;

    @Column(name = "lastname", length = MAX_NAME_LENGTH)
    private String lastName;

    @OneToMany(mappedBy = "author", targetEntity = Book.class)
    private List<Book> books;

    public Author(String firstName, String lastName, List<Book> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Author{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
