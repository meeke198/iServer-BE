package com.IServerBE.dto.messageDto.response;

import com.IServerBE.entity.Room;

import java.time.LocalDateTime;

public class MessageResponseDto {
    private String content;
    private Room room;
    private LocalDateTime sentAt = LocalDateTime.now();
}
