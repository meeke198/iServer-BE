package com.IServerBE.dto.userDto.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String fullName;
    private String userName;
    private String email;
    private String avatar;

}
