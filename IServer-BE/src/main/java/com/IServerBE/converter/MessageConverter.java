package com.IServerBE.converter;

import com.IServerBE.dto.messageDto.request.MessageRequestDto;
import com.IServerBE.dto.messageDto.response.MessageResponseDto;
import com.IServerBE.dto.roomDto.RoomResponseDto;
import com.IServerBE.dto.userDto.response.UserResponseDto;
import com.IServerBE.entity.Message;
import com.IServerBE.entity.Room;
import com.IServerBE.entity.User;
import com.IServerBE.repository.RoomRepo;
import com.IServerBE.repository.UserRepo;
import com.IServerBE.service.RoomService;
import com.IServerBE.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MessageConverter {
    private final RoomRepo roomRepo;
    private final UserRepo userRepo;
    private final UserConverter userConverter;
    private final RoomConverter roomConverter;


    public MessageResponseDto entityToDto(Message message) {
        MessageResponseDto messageResponseDto = new MessageResponseDto();
        BeanUtils.copyProperties(message, messageResponseDto);
        UserResponseDto userResponseDto = userConverter.entityToDto(message.getUser());
        messageResponseDto.setUserResponseDto(userResponseDto);
        RoomResponseDto roomResponseDto = roomConverter.entityToDto(message.getRoom());
        messageResponseDto.setRoomResponseDto(roomResponseDto);
        return messageResponseDto;
    }

    public Message dtoToEntity(MessageRequestDto messageRequestDto) {
        Message message = new Message();
        BeanUtils.copyProperties(messageRequestDto, message);
       Optional<Room> room = roomRepo.findById(messageRequestDto.getRoomId());
        message.setRoom(room.get());
        Optional<User> user = userRepo.findById(messageRequestDto.getUserId());
        message.setUser(user.get());
        return message;
    }
}
