package com.IServerBE.dto.roomDto.request;

import com.IServerBE.entity.Message;
import com.IServerBE.entity.RoomUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomRequestDto {
    private String name;
    private LocalDateTime createAt = LocalDateTime.now();
    private List<RoomUser> RoomUserList;
    private List<Message> messageList;
}
