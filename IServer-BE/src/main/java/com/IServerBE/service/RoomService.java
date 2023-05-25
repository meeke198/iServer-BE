package com.IServerBE.service;

import com.IServerBE.dto.roomDto.response.RoomResponseDto;
import com.IServerBE.dto.userDto.request.UserRequestDto;
import com.IServerBE.dto.userDto.response.UserResponseDto;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Optional;

public interface RoomService {
    RoomResponseDto saveRoom(RoomResponseDto roomRequestDto);
    Optional<RoomResponseDto> getRoom(Long id);

    void deleteRoomById(Long id);

    Page<RoomResponseDto> getAllRooms(Pageable pageable);

}
