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
    public MessageResponseDto getMessage(Long id) {
        MessageResponseDto messageResponseDto = new MessageResponseDto();
        Optional<Message> message = messageRepo.findById(id);
        if(message.isPresent()){
            return messageConverter.entityToDto(message.get());
        } else {
          throw new IllegalArgumentException("Couldn't find any message with id " + id);
        }
    }

    @Override
    public void deleteMessageById(Long id) {
        Optional<Message> message = messageRepo.findById(id);
        if(message.isPresent()){
            messageRepo.deleteById(id);
        } else {
            throw new IllegalArgumentException("Couldn't find any message with id " + id);
        }
    }

    @Override
    public List<MessageResponseDto> getAllMessages() {
        List<MessageResponseDto> messageResponseDtos = new ArrayList<>();
        Optional<List<Message>> messageList = Optional.of(messageRepo.findAll());
        if(messageList.isPresent()){
            return messageConverter.entitesToDtos(messageList.get());
        } else {
            throw new IllegalArgumentException("No message found");
        }
    }

    @Override
    public List<MessageResponseDto> getAllMessagesByRoomId(Long roomId) {
        List<MessageResponseDto> messageResponseDtoList = new ArrayList<>();
        Optional<List<Message>> messageList = Optional.of(messageRepo.getAllMessageByRoomId(roomId));
        if(messageList.isPresent()){
            return messageConverter.entitesToDtos(messageList.get());
        } else {
            throw new IllegalArgumentException("No message found");
        }

    }
}
