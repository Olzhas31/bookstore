package kz.suleimenov.bookstore.controller;

import java.util.List;
import kz.suleimenov.bookstore.model.dtos.BookDto;
import kz.suleimenov.bookstore.service.BookService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping(path = "/books")
public class BookController {

  private final BookService bookService;

  // Получение всех книг
  @GetMapping
  public ResponseEntity<List<BookDto>> getAllBooks() {
    return ResponseEntity.ok(bookService.getAllBooks());
  }

  // Получение книги по ID
  @GetMapping("/{id}")
  public ResponseEntity<BookDto> getBookById(@PathVariable("id") Long id) {
    BookDto book = bookService.getBookById(id);
    if (book != null) {
      return new ResponseEntity<>(book, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // Создание новой книги
  @PostMapping
  public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
    BookDto newBook = bookService.createBook(bookDto);
    return new ResponseEntity<>(newBook, HttpStatus.CREATED);
  }

  // Обновление существующей книги
  @PutMapping("/{id}")
  public ResponseEntity<BookDto> updateBook(@PathVariable("id") Long id, @RequestBody BookDto bookDto) {
    BookDto updatedBook = bookService.updateBook(id, bookDto);
    if (updatedBook != null) {
      return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // Удаление книги по ID
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id) {
    boolean deleted = bookService.deleteBook(id);
    if (deleted) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}