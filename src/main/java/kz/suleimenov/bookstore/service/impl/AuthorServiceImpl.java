package kz.suleimenov.bookstore.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import kz.suleimenov.bookstore.domain.entity.Author;
import kz.suleimenov.bookstore.domain.repository.AuthorRepository;
import kz.suleimenov.bookstore.model.dtos.AuthorDto;
import kz.suleimenov.bookstore.model.mappers.AuthorMapper;
import kz.suleimenov.bookstore.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

  private final AuthorRepository authorRepository;
  private final AuthorMapper authorMapper;

  @Override
  public List<AuthorDto> getAllAuthors() {
    List<Author> authors = authorRepository.findAll();
    return authors.stream()
        .map(authorMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public AuthorDto getAuthorById(Long id) {
    return authorRepository.findById(id)
        .map(authorMapper::toDto)
        .orElse(null);
  }

  @Override
  public AuthorDto createAuthor(AuthorDto authorDto) {
    Author author = authorMapper.toEntity(authorDto);
    Author savedAuthor = authorRepository.save(author);
    return authorMapper.toDto(savedAuthor);
  }

  @Override
  public AuthorDto updateAuthor(Long id, AuthorDto authorDto) {
    if (authorRepository.existsById(id)) {
      Author author = authorMapper.toEntity(authorDto);
      author.setId(id);
      Author updatedAuthor = authorRepository.save(author);
      return authorMapper.toDto(updatedAuthor);
    }
    return null;
  }

  @Override
  public boolean deleteAuthor(Long id) {
    if (authorRepository.existsById(id)) {
      authorRepository.deleteById(id);
      return true;
    }
    return false;
  }

}
