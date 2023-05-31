package com.IServerBE.dto.messageDto.response;

import com.IServerBE.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponseDto {
    private String content;
    private Room room;
    private Room user;
    private LocalDateTime sentAt = LocalDateTime.now();
}
