package kz.suleimenov.bookstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import kz.suleimenov.bookstore.model.dtos.TagDto;
import kz.suleimenov.bookstore.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "tags", description = "Tags APIs")
@RequestMapping("/tags")
public class TagController {

  private static final String SWAGGER_TAG = "tags";
  private final TagService tagService;

  @Operation(summary = "Retrieve all tags", description = "Get a list of all tags", tags = {SWAGGER_TAG})
  @GetMapping
  public ResponseEntity<List<TagDto>> getAllTags() {
    return ResponseEntity.ok(tagService.getAllTags());
  }

  @Operation(summary = "Retrieve a tag by ID", description = "Get the details of a specific tag by ID", tags = {SWAGGER_TAG})
  @GetMapping("/{id}")
  public ResponseEntity<TagDto> getTagById(@PathVariable("id") Long id) {
    TagDto tag = tagService.getTagById(id);
    return tag != null ? new ResponseEntity<>(tag, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @Operation(summary = "Create a new tag", description = "Add a new tag to the system", tags = {SWAGGER_TAG})
  @PostMapping
  public ResponseEntity<TagDto> createTag(@RequestBody TagDto tagDto) {
    TagDto newTag = tagService.createTag(tagDto);
    return new ResponseEntity<>(newTag, HttpStatus.CREATED);
  }

  @Operation(summary = "Update an existing tag", description = "Update the details of an existing tag by ID", tags = {SWAGGER_TAG})
  @PutMapping("/{id}")
  public ResponseEntity<TagDto> updateTag(@PathVariable("id") Long id, @RequestBody TagDto tagDto) {
    TagDto updatedTag = tagService.updateTag(id, tagDto);
    return updatedTag != null ? new ResponseEntity<>(updatedTag, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @Operation(summary = "Delete an tag by ID", description = "Remove a specific tag by ID", tags = {SWAGGER_TAG})
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTag(@PathVariable("id") Long id) {
    boolean deleted = tagService.deleteTag(id);
    return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

}
