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
    public MessageResponseDto entityToDto(Message message) {
        MessageResponseDto messageResponseDto = new MessageResponseDto();
        BeanUtils.copyProperties(message, messageResponseDto);
        return messageResponseDto;
    }

    public Message dtoToEntity(MessageRequestDto messageRequestDto) {
        Message message = new Message();
        BeanUtils.copyProperties(messageRequestDto, message);
        return message;
    }

    public List<MessageResponseDto> entitesToDtos(List<Message> messageList) {
        List<MessageResponseDto> messageResponseDtoList = new ArrayList<>();
        messageList.forEach(message -> messageResponseDtoList.add(entityToDto(message)));
        return messageResponseDtoList;
    }
}
