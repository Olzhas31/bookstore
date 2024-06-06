package kz.suleimenov.bookstore.domain.repository;

import kz.suleimenov.bookstore.domain.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

}
