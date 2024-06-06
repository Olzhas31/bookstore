package kz.suleimenov.bookstore.model.dtos;

import java.util.List;
import lombok.Data;

@Data
public class BookDto {

  private Long id;
  private String name;
  private Integer year;
  private String url;
  private List <AuthorDto> authors;
  private List <CategoryDto> categories;
  private List <TagDto> tags;

}
