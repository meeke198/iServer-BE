package com.IServerBE.dto.messageDto.response;

import com.IServerBE.dto.roomDto.RoomResponseDto;
import com.IServerBE.dto.userDto.response.UserResponseDto;
import com.IServerBE.entity.Room;
import com.IServerBE.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponseDto {
    private String content;
//    private RoomResponseDto roomResponseDto;
    private UserResponseDto userResponseDto;
    private LocalDateTime sentAt;
}
