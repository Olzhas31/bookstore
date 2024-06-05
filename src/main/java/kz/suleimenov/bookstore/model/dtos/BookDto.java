package kz.suleimenov.bookstore.model.dtos;

import lombok.Data;

@Data
public class BookDto {

  private Long id;
  private String name;
  private Integer year;
  private String url;

}
