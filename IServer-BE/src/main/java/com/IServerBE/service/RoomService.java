package com.IServerBE.service;

import com.IServerBE.dto.roomDto.RoomResponseDto;
import com.IServerBE.entity.Room;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface RoomService {
    RoomResponseDto saveRoom(Room room);
    Optional<RoomResponseDto> getRoom(Long id);

    void deleteRoomById(Long id);

    List<RoomResponseDto> getAllRooms();

}
