package com.IServerBE.dto.userDto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPasswordRequestDto {
    private String oldPassword;
    private String newPassword;
}
