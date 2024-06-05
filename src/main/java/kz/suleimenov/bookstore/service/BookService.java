package kz.suleimenov.bookstore.service;

import java.util.List;
import kz.suleimenov.bookstore.model.dtos.BookDto;

public interface BookService {

  List<BookDto> getAllBooks();

  BookDto getBookById(Long id);

  BookDto createBook(BookDto bookDto);

  BookDto updateBook(Long id, BookDto bookDto);

  boolean deleteBook(Long id);
}
