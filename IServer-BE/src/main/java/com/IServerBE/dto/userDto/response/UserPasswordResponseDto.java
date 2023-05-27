package com.IServerBE.dto.userDto.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPasswordResponseDto {
    private String passwordToken;
}