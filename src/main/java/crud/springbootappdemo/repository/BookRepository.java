package crud.springbootappdemo.repository;

import crud.springbootappdemo.domain.Author;
import crud.springbootappdemo.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);

    @Query(value="SELECT * FROM BOOK INNER JOIN AUTHOR au ON au.author_id = BOOK.author_id WHERE au.firstname LIKE CONCAT('%',:name,'%') OR au.lastname LIKE CONCAT('%',:name,'%') ", nativeQuery = true)
    List<Book> findByAuthorContaining(@Param("name") String name);

    @Query(value="SELECT TOP 1 * FROM BOOK ORDER BY PUBLICATION_YEAR DESC", nativeQuery = true)
    Book findOldestBook();
}
