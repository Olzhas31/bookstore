package kz.suleimenov.bookstore.service;

import java.util.List;
import kz.suleimenov.bookstore.model.dtos.TagDto;

public interface TagService {

  List<TagDto> getAllTags();

  TagDto getTagById(Long id);

  TagDto createTag(TagDto tagDto);

  TagDto updateTag(Long id, TagDto tagDto);

  boolean deleteTag(Long id);

}
