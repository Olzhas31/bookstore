package kz.suleimenov.bookstore.service.impl;

import kz.suleimenov.bookstore.domain.entity.Book;
import kz.suleimenov.bookstore.domain.repository.BookRepository;
import kz.suleimenov.bookstore.model.dtos.BookDto;
import kz.suleimenov.bookstore.model.mappers.BookMapper;
import kz.suleimenov.bookstore.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;
  private final BookMapper bookMapper;

  @Override
  public List<BookDto> getAllBooks() {
    List<Book> books = bookRepository.findAll();
    return books.stream()
        .map(bookMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public BookDto getBookById(Long id) {
    Optional<Book> optionalBook = bookRepository.findById(id);
    return optionalBook.map(bookMapper::toDto).orElse(null);
  }

  @Override
  public BookDto createBook(BookDto bookDto) {
    Book book = bookMapper.toEntity(bookDto);
    Book savedBook = bookRepository.save(book);
    return bookMapper.toDto(savedBook);
  }

  @Override
  public BookDto updateBook(Long id, BookDto bookDto) {
    Optional<Book> optionalBook = bookRepository.findById(id);
    if (optionalBook.isPresent()) {
      Book existingBook = optionalBook.get();
      existingBook.setName(bookDto.getName());
      existingBook.setYear(bookDto.getYear());
      existingBook.setUrl(bookDto.getUrl());
      Book updatedBook = bookRepository.save(existingBook);
      return bookMapper.toDto(updatedBook);
    } else {
      return null;
    }
  }

  @Override
  public boolean deleteBook(Long id) {
    if (bookRepository.existsById(id)) {
      bookRepository.deleteById(id);
      return true;
    }
    return false;
  }
}

