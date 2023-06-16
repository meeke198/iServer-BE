package com.IServerBE.dto.roomUserDto.response;

import com.IServerBE.dto.roomDto.RoomResponseDto;
import com.IServerBE.dto.userDto.response.UserResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomUserResponseDto {
    private String name;
    private UserResponseDto userResponseDto;
    private RoomResponseDto roomResponseDto;

}
