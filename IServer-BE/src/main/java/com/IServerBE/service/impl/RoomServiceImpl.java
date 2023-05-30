package com.IServerBE.service.impl;

import com.IServerBE.dto.roomDto.RoomResponseDto;
import com.IServerBE.entity.Room;
import com.IServerBE.repository.RoomRepo;
import com.IServerBE.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class RoomServiceImpl implements RoomService {
    private final RoomRepo roomRepo;


    @Override
    public RoomResponseDto saveRoom(Room room) {
        return null;
    }

    @Override
    public Optional<RoomResponseDto> getRoom(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteRoomById(Long id) {

    }

    @Override
    public List<RoomResponseDto> getAllRooms() {
        return null;
    }
}
