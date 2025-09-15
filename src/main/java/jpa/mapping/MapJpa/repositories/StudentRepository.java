package jpa.mapping.MapJpa.repositories;

import jpa.mapping.MapJpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
