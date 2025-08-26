package com.example.Digital_Library.dto;

import com.example.Digital_Library.model.User;
import com.example.Digital_Library.model.UserStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserRequest {

    private String userName;

    @NotBlank(message = "user phoneNo should not be blank")
    private String phoneNo;

    private String email;

    private String address;

    public User toUser() {
        return User.
                builder().
                name(this.userName).
                email(this.email).
                phoneNo(this.phoneNo).
                address(this.address).
                userStatus(UserStatus.ACTIVE).
                build();
    }
}
