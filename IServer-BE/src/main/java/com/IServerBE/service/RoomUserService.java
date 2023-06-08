package com.IServerBE.service;

import com.IServerBE.dto.roomDto.RoomResponseDto;
import com.IServerBE.dto.roomUserDto.request.RoomUserRequestDto;
import com.IServerBE.dto.userDto.request.UserRequestDto;
import com.IServerBE.dto.userDto.response.UserResponseDto;
import com.IServerBE.entity.Room;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface RoomUserService {
    RoomUserRequestDto saveRoomUser(RoomUserRequestDto roomUserRequestDto);
    RoomUserRequestDto getRoomUser(Long id);

    void deleteRoomUserById(Long id);

    List<RoomUserRequestDto> getAllRoomUsers();

}
