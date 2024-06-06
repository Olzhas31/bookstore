package kz.suleimenov.bookstore.service;

import java.util.List;
import kz.suleimenov.bookstore.model.dtos.AuthorDto;

public interface AuthorService {

  List<AuthorDto> getAllAuthors();

  AuthorDto getAuthorById(Long id);

  AuthorDto createAuthor(AuthorDto authorDto);

  AuthorDto updateAuthor(Long id, AuthorDto authorDto);

  boolean deleteAuthor(Long id);
}
