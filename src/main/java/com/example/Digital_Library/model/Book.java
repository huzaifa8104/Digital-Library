package com.example.Digital_Library.model;

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
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreationTimestamp(source = SourceType.DB)
    private Date createdOn;
    //Sourcetype can be DB or VM, you can see the changes
    // when the DB is on diff server and application is on diff server

    @UpdateTimestamp
    private Date updateOn;

    @Column(length = 30)
    private String title;

    @Column(length = 20, unique = true)
    private String bookNo;

    @Enumerated(value = EnumType.STRING)
    private BookType bookType;

    private Integer securityAmount;


    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn

    private Author author;

    @OneToMany(mappedBy = "book")
    @JsonIgnoreProperties(value = {"book", "user"})
    private List<Txn> txnList;
}
