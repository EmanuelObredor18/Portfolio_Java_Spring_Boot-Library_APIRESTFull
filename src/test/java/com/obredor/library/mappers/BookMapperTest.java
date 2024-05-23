package com.obredor.library.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.obredor.library.models.dtos.BookDTO;
import com.obredor.library.models.entities.Book;

@SpringBootTest
public class BookMapperTest {

  @Mock
  private ModelMapper modelMapper;

  @InjectMocks
  private BookMapper bookMapper;

  @Test
  public void testToDto() {
    // Arrange
    Book book = new Book();
    book.setBookIsbn("1");
    book.setTitle("Test Book");

    BookDTO expectedDto = new BookDTO();
    expectedDto.setBookIsbn("1");
    expectedDto.setTitle("Test Book");

    // Define el comportamiento del mock de ModelMapper
    when(modelMapper.map(book, BookDTO.class)).thenReturn(expectedDto);

    // Act
    BookDTO actualDto = bookMapper.toDto(book);

    // Assert
    assertEquals(expectedDto, actualDto);
  }
  
}
