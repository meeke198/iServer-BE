package com.IServerBE.converter;

import com.IServerBE.dto.roomUserDto.request.RoomUserRequestDto;
import com.IServerBE.dto.roomUserDto.response.RoomUserResponseDto;
import com.IServerBE.entity.RoomUser;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RoomUserConverter {

    public RoomUserResponseDto entityToDto(RoomUser roomUser){
        RoomUserResponseDto roomUserResponseDto = new RoomUserResponseDto();
        BeanUtils.copyProperties(roomUser, roomUserResponseDto);
        return roomUserResponseDto;
    }

    public RoomUser entityToDto(RoomUserRequestDto roomUserRequestDto){
        RoomUser roomUser = new RoomUser();
        BeanUtils.copyProperties(roomUserRequestDto, roomUser);
        return roomUser;
    }
}
