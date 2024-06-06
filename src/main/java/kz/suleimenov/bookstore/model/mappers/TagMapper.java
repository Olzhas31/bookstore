package kz.suleimenov.bookstore.model.mappers;

import kz.suleimenov.bookstore.domain.entity.Tag;
import kz.suleimenov.bookstore.model.dtos.TagDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {
  TagDto toDto(Tag tag);

  Tag toEntity(TagDto tagDto);
}
