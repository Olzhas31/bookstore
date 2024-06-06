package kz.suleimenov.bookstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.suleimenov.bookstore.model.dtos.AuthorDto;
import kz.suleimenov.bookstore.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "authors", description = "Authors APIs")
@RequestMapping("/authors")
public class AuthorController {

  private final AuthorService authorService;

  @Operation(summary = "Retrieve all authors", description = "Get a list of all authors", tags = {"authors"})
  @GetMapping
  public ResponseEntity<List<AuthorDto>> getAllAuthors() {
    return ResponseEntity.ok(authorService.getAllAuthors());
  }

  @Operation(summary = "Retrieve an author by ID", description = "Get the details of a specific author by ID", tags = {"authors"})
  @GetMapping("/{id}")
  public ResponseEntity<AuthorDto> getAuthorById(@PathVariable("id") Long id) {
    AuthorDto author = authorService.getAuthorById(id);
    return author != null ? new ResponseEntity<>(author, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @Operation(summary = "Create a new author", description = "Add a new author to the system", tags = {"authors"})
  @PostMapping
  public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) {
    AuthorDto newAuthor = authorService.createAuthor(authorDto);
    return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
  }

  @Operation(summary = "Update an existing author", description = "Update the details of an existing author by ID", tags = {"authors"})
  @PutMapping("/{id}")
  public ResponseEntity<AuthorDto> updateAuthor(@PathVariable("id") Long id, @RequestBody AuthorDto authorDto) {
    AuthorDto updatedAuthor = authorService.updateAuthor(id, authorDto);
    return updatedAuthor != null ? new ResponseEntity<>(updatedAuthor, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @Operation(summary = "Delete an author by ID", description = "Remove a specific author by ID", tags = {"authors"})
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAuthor(@PathVariable("id") Long id) {
    boolean deleted = authorService.deleteAuthor(id);
    return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}

