package com.IServerBE.service.impl;

import com.IServerBE.converter.RoomConverter;
import com.IServerBE.dto.roomDto.RoomResponseDto;
import com.IServerBE.entity.Room;
import com.IServerBE.repository.RoomRepo;
import com.IServerBE.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class RoomServiceImpl implements RoomService {
    private final RoomRepo roomRepo;
    private final RoomConverter roomConverter;


    @Override
    public RoomResponseDto saveRoom(Room room) {
        return roomConverter.entityToDto(roomRepo.save(room));
    }

    @Override
    public RoomResponseDto getRoom(Long id) {
        Optional<Room> room = roomRepo.findById(id);
        if(room.isPresent()){
            return roomConverter.entityToDto(room.get());
        } else {
            throw new IllegalArgumentException("Room doesnt exist");
        }
    }


    @Override
    public void deleteRoomById(Long id) {
        Optional<Room> room = roomRepo.findById(id);
        if(room.isPresent()){
            roomRepo.deleteById(id);
        }else {
            throw new IllegalArgumentException("Room doesnt exist");
        }
    }

    @Override
    public List<RoomResponseDto> getAllRooms() {
        Optional<List<Room>> roomList = Optional.of(roomRepo.findAll());
        if(roomList.isPresent()){
            List<RoomResponseDto> roomResponseDtoList = roomConverter.entitiesToDto(roomList.get());
            return roomResponseDtoList;
        }else{
            throw new IllegalArgumentException("No rooms found");
        }
    }
}
