package kz.suleimenov.bookstore.model.mappers;

import kz.suleimenov.bookstore.domain.entity.Category;
import kz.suleimenov.bookstore.model.dtos.CategoryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

  CategoryDto toDto(Category category);

  Category toEntity(CategoryDto categoryDto);
}

