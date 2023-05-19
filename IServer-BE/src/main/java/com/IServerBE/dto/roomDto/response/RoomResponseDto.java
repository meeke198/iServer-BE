package com.IServerBE.dto.roomDto.response;

import com.IServerBE.entity.Message;
import com.IServerBE.entity.RoomUser;

import java.time.LocalDateTime;
import java.util.List;

public class RoomResponseDto {
    private String name;
    private LocalDateTime createAt = LocalDateTime.now();
    private List<RoomUser> RoomUserList;
    private List<Message> messageList;
}
