package com.IServerBE.controller.controller_FE_SE;

import com.IServerBE.converter.MessageConverter;
import com.IServerBE.dto.messageDto.request.MessageRequestDto;
import com.IServerBE.dto.messageDto.response.MessageResponseDto;
import com.IServerBE.dto.userDto.response.UserResponseDto;
import com.IServerBE.entity.Message;
import com.IServerBE.service.MessageService;
import com.IServerBE.service.impl.MessageServiceImpl;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping("/messages")
public class MessageController {
    private final MessageService messageService;

    @GetMapping("")
    public ResponseEntity<?> getAllMessages() {
        List<MessageResponseDto> messageResponseDtoList = messageService.getAllMessages();
        if (!messageResponseDtoList.isEmpty()) {
            return ResponseEntity.ok().body(messageResponseDtoList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/groupMessages/{roomId}")
    public ResponseEntity<?> getAllMessagesByRoomId(@PathVariable Long roomId) {
        Optional<List<MessageResponseDto>> messageResponseDtoList = Optional.of(messageService.getAllMessagesByRoomId(roomId));
        if (messageResponseDtoList.isPresent()) {
            return ResponseEntity.ok().body(messageResponseDtoList);
        } else {
            return new ResponseEntity<>("No messages found", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/sentMessages/{userId}")
    public ResponseEntity<?> getAllMessagesByUserId(@PathVariable Long userId) {
        Optional<List<MessageResponseDto>> messageResponseDtoList = Optional.of(messageService.getAllMessagesByUserId(userId));
        if (messageResponseDtoList.isPresent()) {
            return ResponseEntity.ok().body(messageResponseDtoList);
        } else {
            return new ResponseEntity<>("No messages found", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> saveMessage(@RequestBody MessageRequestDto messageRequestDto) {
       MessageResponseDto messageResponseDto = messageService.saveMessage(messageRequestDto);
        return ResponseEntity.ok().body(messageResponseDto);
    }
}

