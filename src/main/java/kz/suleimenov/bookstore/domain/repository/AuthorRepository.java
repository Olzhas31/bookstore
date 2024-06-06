package kz.suleimenov.bookstore.domain.repository;

import kz.suleimenov.bookstore.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
