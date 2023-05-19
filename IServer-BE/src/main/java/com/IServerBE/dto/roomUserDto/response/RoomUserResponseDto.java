package com.IServerBE.dto.roomUserDto.response;

import com.IServerBE.entity.Room;
import com.IServerBE.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomUserResponseDto {
    private String name;
    private Room room;
    private User user;
}
