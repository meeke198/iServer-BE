package com.IServerBE.dto.messageDto.response;


import com.IServerBE.dto.roomDto.RoomResponseDto;
import com.IServerBE.dto.userDto.response.UserResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponseDto {
    private Long id;
    private String content;
    private UserResponseDto userResponseDto;
    private RoomResponseDto roomResponseDto;
    private LocalDateTime sentAt;
}
