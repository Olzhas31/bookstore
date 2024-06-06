package kz.suleimenov.bookstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import kz.suleimenov.bookstore.model.dtos.BookDto;
import kz.suleimenov.bookstore.service.BookService;
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
@RequiredArgsConstructor
@Tag(name = "books", description = "Books Service APIs")
@RequestMapping(path = "/books")
public class BookController {

  private static final String SWAGGER_TAG = "books";
  private final BookService bookService;

  @Operation(summary = "Return all books",
      description = "Get a list of all books available in the bookstore",
      tags = {SWAGGER_TAG})
  @GetMapping
  public ResponseEntity<List<BookDto>> getAllBooks() {
    return ResponseEntity.ok(bookService.getAllBooks());
  }

  @Operation(summary = "Return a book by id",
      description = "Get the details of a specific book by its unique identifier",
      tags = {SWAGGER_TAG})
  @GetMapping("/{id}")
  public ResponseEntity<BookDto> getBookById(@PathVariable("id") Long id) {
    BookDto book = bookService.getBookById(id);
    if (book != null) {
      return new ResponseEntity<>(book, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @Operation(
      summary = "Create a new book",
      description = "Add a new book to the bookstore's collection by providing the necessary details",
      tags = {SWAGGER_TAG}
  )
  @PostMapping
  public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
    BookDto newBook = bookService.createBook(bookDto);
    return new ResponseEntity<>(newBook, HttpStatus.CREATED);
  }

  @Operation(
      summary = "Update an existing book",
      description = "Update the details of an existing book by providing the book ID and the updated information",
      tags = {SWAGGER_TAG}
  )
  @PutMapping("/{id}")
  public ResponseEntity<BookDto> updateBook(@PathVariable("id") Long id, @RequestBody BookDto bookDto) {
    BookDto updatedBook = bookService.updateBook(id, bookDto);
    if (updatedBook != null) {
      return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @Operation(
      summary = "Delete a book by ID",
      description = "Remove a specific book from the bookstore by its unique identifier",
      tags = {SWAGGER_TAG}
  )
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