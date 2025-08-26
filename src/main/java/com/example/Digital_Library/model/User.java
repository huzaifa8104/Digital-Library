package com.example.Digital_Library.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30)
    private String name;

    @Column(nullable = false, unique = true, length = 15)
    private String phoneNo;

    @Column(unique = true, length = 50)
    private String email;

    private String address;

    @CreationTimestamp
    private Date createOn;

    @UpdateTimestamp
    private Date updateOn;

    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    @Enumerated
    private UserStatus userStatus;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties(value = "user")
    private List<Book> bookList;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties(value = {"user", "book"})
    private List<Txn> txnList;
}
