package dev.patika.library_management.dao;

import dev.patika.library_management.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Long> {
}
