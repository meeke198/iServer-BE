package com.IServerBE.service;

import com.IServerBE.dto.roomDto.response.RoomResponseDto;
import com.IServerBE.dto.roomUserDto.request.RoomUserRequestDto;
import com.IServerBE.dto.userDto.request.UserRequestDto;
import com.IServerBE.dto.userDto.response.UserResponseDto;
import com.IServerBE.entity.Room;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Optional;

public interface RoomUserService {
    RoomUserRequestDto saveRoom(RoomUserRequestDto roomUserRequestDto);
    Optional<RoomUserRequestDto> getRoomUser(Long id);

    void deleteRoomUserById(Long id);

    Page<RoomUserRequestDto> getAllRoomUsers(Pageable pageable);

}
