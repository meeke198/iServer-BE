package com.IServerBE.converter;

import com.IServerBE.dto.messageDto.request.MessageRequestDto;
import com.IServerBE.dto.messageDto.response.MessageResponseDto;
import com.IServerBE.entity.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MessageConverter {
    private final UserConverter userConverter;
    private final RoomConverter roomConverter;
    public MessageResponseDto entityToDto(Message message) {
        MessageResponseDto messageResponseDto = new MessageResponseDto();
        BeanUtils.copyProperties(message, messageResponseDto);
//        messageResponseDto.setRoomResponseDto(roomConverter.entityToDto(message.getRoom()));
        messageResponseDto.setUserResponseDto(userConverter.entityToDto(message.getUser()));
        return messageResponseDto;
    }

    public Message dtoToEntity(MessageRequestDto messageRequestDto) {
        Message message = new Message();
        BeanUtils.copyProperties(messageRequestDto, message);
        return message;
    }
}
