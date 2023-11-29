package dev.patika.library_management.dao;

import dev.patika.library_management.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepo extends JpaRepository<Publisher,Long> {
}
