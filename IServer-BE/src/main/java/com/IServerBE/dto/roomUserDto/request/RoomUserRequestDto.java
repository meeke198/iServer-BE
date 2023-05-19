package com.IServerBE.dto.roomUserDto.request;

import com.IServerBE.entity.Room;
import com.IServerBE.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomUserRequestDto {
    private String name;
    private Room room;
    private User user;
}
