package crud.springbootappdemo.service;

import crud.springbootappdemo.domain.Author;
import crud.springbootappdemo.domain.Book;
import crud.springbootappdemo.forms.BookForm;
import crud.springbootappdemo.model.BookModel;
import crud.springbootappdemo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findAuthor(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> findAuthorByFirstNameAndLastName(String firstName, String lastName) {
        return authorRepository.findAuthorByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Optional<Author> fetchAuthorWithBooksByAuthorId(Long id) {
        return authorRepository.fetchAuthorWithBooksByAuthorId(id);
    }

}
