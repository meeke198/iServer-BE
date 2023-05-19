package com.IServerBE.dto.userDto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPasswordDto {
    private String oldPassword;
    private String newPassword;
}
