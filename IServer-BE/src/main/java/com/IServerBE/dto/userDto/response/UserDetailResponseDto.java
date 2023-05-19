package com.IServerBE.dto.userDto.response;

import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailResponseDto {
    private Long id;
    private String fullName;
    private String userName;
    private String email;
    private String address;
    private String phone;
    private String avatar;
    private Boolean isStatus;
    private String rememberToken;
}