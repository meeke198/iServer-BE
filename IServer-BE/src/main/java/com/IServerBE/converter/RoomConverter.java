package com.IServerBE.converter;

import com.IServerBE.dto.roomDto.RoomRequestDto;
import com.IServerBE.dto.roomDto.RoomResponseDto;
import com.IServerBE.entity.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RoomConverter {
    public RoomResponseDto entityToDto(Room room) {
        RoomResponseDto roomResponseDto = new RoomResponseDto();
        BeanUtils.copyProperties(room, roomResponseDto);
        return roomResponseDto;
    }
    public Room dtoToEntity(RoomRequestDto roomRequestDto) {
        Room room = new Room();
        BeanUtils.copyProperties(roomRequestDto, room);
        return room;
    }

//    public List<RoomResponseDto> entitiesToDto(List<Room> roomList){
//        List<RoomResponseDto> roomResponseDtoList = new ArrayList<>();
//        roomList.forEach(room -> roomResponseDtoList.add(entityToDto(room)));
//     return roomResponseDtoList;
//    }
}
