package com.example.Digital_Library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreationTimestamp(source = SourceType.DB)
    private Date createdOn;

    @UpdateTimestamp
    private Date updateOn;

    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    @OneToMany(mappedBy = "author")
//    @JsonIgnore
    @JsonIgnoreProperties(value = "author")
    private List<Book> bookList;

    @Column(unique = true, length = 50, nullable = false)
    private String email;

    @Column(length = 30)
    private String name;
}
