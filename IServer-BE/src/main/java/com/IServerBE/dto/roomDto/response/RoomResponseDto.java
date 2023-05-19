package com.IServerBE.dto.roomDto.response;

import com.IServerBE.entity.Message;
import com.IServerBE.entity.RoomUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomResponseDto {
    private String name;
    private LocalDateTime createAt = LocalDateTime.now();
    private List<RoomUser> RoomUserList;
    private List<Message> messageList;
}
