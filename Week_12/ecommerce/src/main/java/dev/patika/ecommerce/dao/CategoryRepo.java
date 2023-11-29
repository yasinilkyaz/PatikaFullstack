package dev.patika.ecommerce.dao;

import dev.patika.ecommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoryRepo extends JpaRepository<Category,Long> {
}
