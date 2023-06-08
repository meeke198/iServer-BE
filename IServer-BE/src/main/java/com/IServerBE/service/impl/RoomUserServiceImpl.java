package com.IServerBE.service.impl;
import com.IServerBE.dto.roomUserDto.request.RoomUserRequestDto;
import com.IServerBE.service.RoomUserService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class RoomUserServiceImpl implements RoomUserService {

    @Override
    public RoomUserRequestDto saveRoomUser(RoomUserRequestDto roomUserRequestDto) {
        return null;
    }

    @Override
    public RoomUserRequestDto getRoomUser(Long id) {
        return null;
    }

    @Override
    public void deleteRoomUserById(Long id) {

    }

    @Override
    public List<RoomUserRequestDto> getAllRoomUsers() {
        return null;
    }
}
