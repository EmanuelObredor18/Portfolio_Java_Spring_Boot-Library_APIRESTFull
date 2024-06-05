package com.obredor.library.models.entities;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "AUTHORS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Author implements BaseEntity<Long> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long authorId;

  @Column(nullable = false, length = 30)
  private String name;

  @Column(columnDefinition = "TINYTEXT")
  private String description;

  @Temporal(TemporalType.DATE)
  private Date birthDate;

  @ManyToMany(mappedBy = "authors")
  private Set<Book> books;

  @Override
  public Long getId() {
    return this.authorId;
  }
}
