package crud.springbootappdemo.service;

import crud.springbootappdemo.domain.Author;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Optional<Author> findAuthor(Long id);

    List<Author> getAllAuthors();

    Optional<Author> findAuthorByFirstNameAndLastName(String firstName, String lastName);

    Optional<Author> fetchAuthorWithBooksByAuthorId(Long id);
}
