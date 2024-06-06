package kz.suleimenov.bookstore.service.impl;

import kz.suleimenov.bookstore.domain.entity.Category;
import kz.suleimenov.bookstore.domain.repository.CategoryRepository;
import kz.suleimenov.bookstore.model.dtos.CategoryDto;
import kz.suleimenov.bookstore.model.mappers.CategoryMapper;
import kz.suleimenov.bookstore.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;
  private final CategoryMapper categoryMapper;

  @Override
  @Transactional(readOnly = true)
  public List<CategoryDto> getAllCategories() {
    List<Category> categories = categoryRepository.findAll();
    return categories.stream()
        .map(categoryMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  @Transactional(readOnly = true)
  public CategoryDto getCategoryById(Long id) {
    Optional<Category> optionalCategory = categoryRepository.findById(id);
    return optionalCategory.map(categoryMapper::toDto).orElse(null);
  }

  @Override
  @Transactional
  public CategoryDto createCategory(CategoryDto categoryDto) {
    Category category = categoryMapper.toEntity(categoryDto);
    category = categoryRepository.save(category);
    return categoryMapper.toDto(category);
  }

  @Override
  @Transactional
  public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
    Category category = categoryRepository.findById(id).orElse(null);
    if (category != null) {
      category.setName(categoryDto.getName());
      category = categoryRepository.save(category);
      return categoryMapper.toDto(category);
    }
    return null;
  }

  @Override
  @Transactional
  public void deleteCategory(Long id) {
    categoryRepository.deleteById(id);
  }
}
