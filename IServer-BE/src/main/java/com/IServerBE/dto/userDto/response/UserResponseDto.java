package com.IServerBE.dto.userDto.response;

import com.IServerBE.dto.roomUserDto.response.RoomUserResponseDto;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String fullName;
    private String userName;
    private String email;
    private String avatar;
    private List<RoomUserResponseDto> roomUserResponseDtoList;

}
