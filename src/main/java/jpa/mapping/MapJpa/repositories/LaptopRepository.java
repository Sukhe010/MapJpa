// LaptopRepository.java
package jpa.mapping.MapJpa.repositories;

import jpa.mapping.MapJpa.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop, Integer> {
}
