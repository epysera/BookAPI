package pl.coderslab;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public interface BookService {
    List<Book> getAllBooks();
    Optional<Book> getBook(Long id);
    void add(Book book);
    void delete(Long id);
    void update(Book book);

}
