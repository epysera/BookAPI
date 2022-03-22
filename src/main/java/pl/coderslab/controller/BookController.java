package pl.coderslab.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.Book;
import pl.coderslab.BookService;
import pl.coderslab.MockBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("")
    @ResponseBody
    public List<Book> getList(){
        return bookService.getAllBooks();
    }
    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return this.bookService.getBook(id).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        });
    }
    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        bookService.add(book);
    }
    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable Long id) {
        bookService.delete(id);
    }
    @PutMapping("")
    @ResponseBody
    public void updateBook(@RequestBody Book book) {
        bookService.update(book);
    }


}

