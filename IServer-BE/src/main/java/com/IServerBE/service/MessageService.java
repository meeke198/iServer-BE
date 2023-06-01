package com.IServerBE.service;

import com.IServerBE.dto.messageDto.request.MessageRequestDto;
import com.IServerBE.dto.messageDto.response.MessageResponseDto;
import com.IServerBE.dto.userDto.request.UserRequestDto;
import com.IServerBE.dto.userDto.response.UserResponseDto;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface MessageService {
    MessageResponseDto saveMessage(MessageRequestDto messageRequestDto);

//    void deleteMessageById(Long id);

    List<MessageResponseDto> getAllMessages();
    List<MessageResponseDto> getAllMessagesByRoomId(Long roomId);


}
