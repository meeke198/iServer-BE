package com.IServerBE.dto.messageDto.request;

import com.IServerBE.dto.roomDto.RoomRequestDto;
import com.IServerBE.dto.userDto.request.UserRequestDto;
import com.IServerBE.entity.Room;
import com.IServerBE.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class MessageRequestDto {
    private String content;
    private Long userId;
    private Long roomId;
    private LocalDateTime sentAt = LocalDateTime.now();

}
