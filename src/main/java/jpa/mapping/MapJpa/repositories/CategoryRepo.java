package jpa.mapping.MapJpa.repositories;

import jpa.mapping.MapJpa.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, String> {

}
