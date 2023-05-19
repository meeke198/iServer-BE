package com.IServerBE.dto.userDto.request;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDto {
    private String fullName;
    private String address;
    private String phone;
    private String avatar;
}
