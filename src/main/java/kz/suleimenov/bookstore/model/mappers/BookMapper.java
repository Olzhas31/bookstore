package kz.suleimenov.bookstore.model.mappers;

import kz.suleimenov.bookstore.domain.entity.Book;
import kz.suleimenov.bookstore.model.dtos.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

  BookDto toDto(Book book);

  @Mapping(target = "id", ignore = true) // Игнорируем поле id при маппинге обратно к сущности
  Book toEntity(BookDto bookDto);
}
