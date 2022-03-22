package pl.coderslab;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class MockBookService implements BookService {

    private static Long nextId = 4L;

    private List<Book> list;
    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public List<Book> getAllBooks () {
        return list;
    }
    public Optional<Book> getBook(Long id){
        return list.stream().filter(item -> item.getId().equals(id)).findFirst();
    }
    @Override
    public void add(Book book) {
        book.setId(nextId++);
        list.add(book);
    }
    @Override
    public void delete(Long id) {
        if (getBook(id).isPresent()) {
            list.remove(this.getBook(id).get());
        }
    }
    @Override
    public void update(Book book) {
        if (this.getBook(book.getId()).isPresent()) {
            int indexOf = list.indexOf(this.getBook(book.getId()).get());
            list.set(indexOf, book);
        }
    }


}
