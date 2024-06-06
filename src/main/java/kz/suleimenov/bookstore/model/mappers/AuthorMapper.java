package kz.suleimenov.bookstore.model.mappers;

import kz.suleimenov.bookstore.domain.entity.Author;
import kz.suleimenov.bookstore.model.dtos.AuthorDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
  AuthorDto toDto(Author author);
  Author toEntity(AuthorDto authorDto);
}
