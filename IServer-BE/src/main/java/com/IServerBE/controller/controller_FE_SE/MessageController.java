package com.IServerBE.controller.controller_FE_SE;

import com.IServerBE.converter.MessageConverter;
import com.IServerBE.dto.messageDto.request.MessageRequestDto;
import com.IServerBE.dto.messageDto.response.MessageResponseDto;
import com.IServerBE.entity.Message;
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
@CrossOrigin(value = "*")
@RequestMapping("/messages")
public class MessageController {
    private final MessageServiceImpl messageService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getMessage(@PathVariable Long id){
        Optional<MessageResponseDto> messageResponseDto = Optional.ofNullable(messageService.getMessage(id));
        if(messageResponseDto.isPresent()){
            return ResponseEntity.ok().body(messageResponseDto.get());
        } else {
            return new ResponseEntity<>("Message doesn't exist", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getAllMessages(){
        Optional<List<MessageResponseDto>> messageResponseDtoList = Optional.of(messageService.getAllMessages());
        if(messageResponseDtoList.isPresent()){
            return ResponseEntity.ok().body(messageResponseDtoList);
        } else {
            return new ResponseEntity<>("No messages found", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<?> getAllMessagesByRoomId(@PathVariable Long roomId){
        Optional<List<MessageResponseDto>> messageResponseDtoList = Optional.of(messageService.getAllMessagesByRoomId(roomId));
        if(messageResponseDtoList.isPresent()){
            return ResponseEntity.ok().body(messageResponseDtoList);
        } else{
            return new ResponseEntity<>("No messages found", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> saveMessage(@RequestBody MessageRequestDto messageRequestDto){
        Optional<MessageResponseDto> messageResponseDto = Optional.of(messageService.saveMessage(messageRequestDto));
        if(messageResponseDto.isPresent()){
            return ResponseEntity.ok().body(messageResponseDto);
        } else {
            return new ResponseEntity<>("Couldn't save message", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable Long id){
        Optional<MessageResponseDto> messageResponseDto = Optional.ofNullable(messageService.getMessage(id));
        if(messageResponseDto.isPresent()){
            return ResponseEntity.ok().body(messageResponseDto);
        } else {
            return new ResponseEntity<>("Message doesn't exist", HttpStatus.BAD_REQUEST);
        }
    }
}


