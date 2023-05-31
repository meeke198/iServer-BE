package com.IServerBE.service.impl;

import com.IServerBE.dto.messageDto.request.MessageRequestDto;
import com.IServerBE.dto.messageDto.response.MessageResponseDto;
import com.IServerBE.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MessageServiceImpl implements MessageService {
    @Override
    public MessageResponseDto saveMessage(MessageRequestDto messageRequestDto) {
        return null;
    }

    @Override
    public MessageResponseDto getMessage(Long id) {
        return null;
    }

    @Override
    public void deleteMessageById(Long id) {

    }

    @Override
    public List<MessageResponseDto> getAllMessages() {
        return null;
    }

    @Override
    public List<MessageResponseDto> getAllMessagesByRoomId() {
        return null;
    }
}
