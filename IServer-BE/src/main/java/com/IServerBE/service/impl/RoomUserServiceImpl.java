package com.IServerBE.service.impl;
import com.IServerBE.converter.RoomUserConverter;
import com.IServerBE.dto.roomUserDto.request.RoomUserRequestDto;
import com.IServerBE.dto.roomUserDto.response.RoomUserResponseDto;
import com.IServerBE.entity.RoomUser;
import com.IServerBE.repository.RoomUserRepo;
import com.IServerBE.service.RoomUserService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j

public class RoomUserServiceImpl implements RoomUserService {
    private final RoomUserRepo roomUserRepo;
    private final RoomUserConverter roomUserConverter;

    @Override
    public RoomUserResponseDto saveRoomUser(RoomUserRequestDto roomUserRequestDto) {
       RoomUser roomUser = roomUserConverter.dtoToEntity(roomUserRequestDto);
       roomUserRepo.save(roomUser);
        log.info("Saving new roomUser to database {}", roomUser.getName());
        RoomUserResponseDto roomUserResponseDto = roomUserConverter.entityToDto(roomUser);
        return roomUserResponseDto;
    }

    @Override
    public RoomUserResponseDto getRoomUserById(Long id) {
        Optional<RoomUser> roomUser = roomUserRepo.findById(id);
        if(roomUser.isPresent()){
            return roomUserConverter.entityToDto(roomUser.get());
        } else{
            throw new IllegalArgumentException("No roomUser found");
        }
    }

    @Override
    public void deleteRoomUserById(Long id) {
        Optional<RoomUser> roomUser = roomUserRepo.findById(id);
        if(roomUser.isPresent()){
            roomUserRepo.delete(roomUser.get());
            log.info("Deleted RoomUser " + id);
        } else {
            throw new IllegalArgumentException("No roomUser found");
        }
    }

    @Override
    public List<RoomUserResponseDto> getAllRoomUsers() {
        List<RoomUser> roomUserList = roomUserRepo.findAll();
        if(!roomUserList.isEmpty()){
            return roomUserList.stream().map(roomUserConverter::entityToDto).collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("No roomUser found");
        }
    }
}
