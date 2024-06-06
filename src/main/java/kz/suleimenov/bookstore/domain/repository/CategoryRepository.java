package kz.suleimenov.bookstore.domain.repository;

import kz.suleimenov.bookstore.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}

