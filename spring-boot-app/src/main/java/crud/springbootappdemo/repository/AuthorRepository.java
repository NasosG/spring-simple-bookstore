package crud.springbootappdemo.repository;

import crud.springbootappdemo.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findAuthorByFirstNameAndLastName(String firstName, String lastName);

    @Query(value="SELECT a FROM Author a JOIN FETCH a.books WHERE a.id = (:id)")
    Optional<Author> fetchAuthorWithBooksByAuthorId(@Param("id") Long id);
}
