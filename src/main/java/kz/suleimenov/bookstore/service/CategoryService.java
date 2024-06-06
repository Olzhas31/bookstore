package kz.suleimenov.bookstore.service;

import java.util.List;
import kz.suleimenov.bookstore.model.dtos.CategoryDto;

public interface CategoryService {

  List<CategoryDto> getAllCategories();

  CategoryDto getCategoryById(Long id);

  CategoryDto createCategory(CategoryDto categoryDto);

  CategoryDto updateCategory(Long id, CategoryDto categoryDto);

  void deleteCategory(Long id);
}
