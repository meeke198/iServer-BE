package com.IServerBE.dto.userDto.response;

import com.IServerBE.dto.roomUserDto.response.RoomUserResponseDto;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String userName;
    private String email;
    private String avatar;
    private String password;
    private Boolean isOnline = false;
    private Boolean isActive = true;
    private List<RoomUserResponseDto> roomUserResponseDtoList;

}
