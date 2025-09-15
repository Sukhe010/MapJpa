package jpa.mapping.MapJpa.repositories;

import jpa.mapping.MapJpa.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, String> {

}
