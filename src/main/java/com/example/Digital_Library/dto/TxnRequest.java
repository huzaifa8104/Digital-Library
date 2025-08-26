package com.example.Digital_Library.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TxnRequest {

    @NotBlank(message = "User Phone number should not be blank")
    private String userPhoneNo;

    @NotBlank(message = "Book  number should not be blank")
    private String bookNo;



}
