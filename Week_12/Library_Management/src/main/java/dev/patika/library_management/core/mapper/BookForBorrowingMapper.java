package dev.patika.library_management.core.mapper;

import dev.patika.LibraryApp.dto.request.BookForBorrowingRequest;
import dev.patika.LibraryApp.entity.Book;
import org.mapstruct.Mapper;

@Mapper
public interface BookForBorrowingMapper {

    Book asEntity(BookForBorrowingRequest bookForBorrowingRequest);
}
