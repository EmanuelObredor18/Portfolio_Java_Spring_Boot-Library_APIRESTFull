package com.obredor.library.models.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "BOOKS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Book implements BaseEntity<String> {

  @Id
  @Column(length = 17)
  private String bookIsbn;

  @Column(nullable = false, length = 30)
  private String title;

  @Column(nullable = false, columnDefinition = "TINYTEXT")
  private String description;

  @Column(length = 100)
  private String imgSource;

  @ManyToMany
  @JoinTable(
    name = "bookAuthor",
    joinColumns = @JoinColumn(name = "bookId"),
    inverseJoinColumns = @JoinColumn(name = "authorId")
  )
  private Set<Author> authors;

  @OneToMany(mappedBy = "book")
  private Set<Loan> loans;

  @Override
  public String getId() {
    return this.bookIsbn;
  }
}
