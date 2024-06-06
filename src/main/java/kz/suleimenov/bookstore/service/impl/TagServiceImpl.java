package kz.suleimenov.bookstore.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import kz.suleimenov.bookstore.domain.entity.Tag;
import kz.suleimenov.bookstore.domain.repository.TagRepository;
import kz.suleimenov.bookstore.model.dtos.TagDto;
import kz.suleimenov.bookstore.model.mappers.TagMapper;
import kz.suleimenov.bookstore.service.TagService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TagServiceImpl implements TagService {

  private final TagRepository tagRepository;
  private final TagMapper tagMapper;

  @Override
  public List<TagDto> getAllTags() {
    List<Tag> tags = tagRepository.findAll();
    return tags.stream()
        .map(tagMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public TagDto getTagById(Long id) {
    return tagRepository.findById(id)
        .map(tagMapper::toDto)
        .orElse(null);
  }

  @Override
  public TagDto createTag(TagDto tagDto) {
    Tag tag = tagMapper.toEntity(tagDto);
    Tag savedTag = tagRepository.save(tag);
    return tagMapper.toDto(savedTag);
  }

  @Override
  public TagDto updateTag(Long id, TagDto tagDto) {
    if (tagRepository.existsById(id)) {
      Tag tag = tagMapper.toEntity(tagDto);
      tag.setId(id);
      Tag updatedTag = tagRepository.save(tag);
      return tagMapper.toDto(updatedTag);
    }
    return null;
  }

  @Override
  public boolean deleteTag(Long id) {
    if (tagRepository.existsById(id)) {
      tagRepository.deleteById(id);
      return true;
    }
    return false;
  }
}
