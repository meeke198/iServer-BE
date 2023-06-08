package com.IServerBE.service.impl;

import com.IServerBE.converter.MessageConverter;
import com.IServerBE.dto.messageDto.request.MessageRequestDto;
import com.IServerBE.dto.messageDto.response.MessageResponseDto;
import com.IServerBE.entity.Message;
import com.IServerBE.repository.MessageRepo;
import com.IServerBE.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MessageServiceImpl implements MessageService {
    private final MessageRepo messageRepo;
    private final MessageConverter messageConverter;
    @Override
    public MessageResponseDto saveMessage(MessageRequestDto messageRequestDto) {
        Message message = messageRepo.save(messageConverter.dtoToEntity(messageRequestDto));
        return messageConverter.entityToDto(message);
    }


    @Override
    public List<MessageResponseDto> getAllMessages() {
        List<Message> messageList = messageRepo.findAll();

        if(!messageList.isEmpty()){
            return messageList.stream().map(messageConverter::entityToDto).collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("No message found");
        }
    }

    @Override
    public List<MessageResponseDto> getAllMessagesByRoomId(Long roomId) {
        Optional<List<Message>> messageList = Optional.of(messageRepo.getMessagesByRoomId(roomId));
        if(messageList.isPresent()){
            return messageList.get().stream().map(messageConverter::entityToDto).collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("No message found");
        }
    }
}
