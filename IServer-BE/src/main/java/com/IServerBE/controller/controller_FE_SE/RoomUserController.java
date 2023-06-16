package com.IServerBE.controller.controller_FE_SE;

import com.IServerBE.dto.messageDto.request.MessageRequestDto;
import com.IServerBE.dto.messageDto.response.MessageResponseDto;
import com.IServerBE.dto.roomUserDto.request.RoomUserRequestDto;
import com.IServerBE.dto.roomUserDto.response.RoomUserResponseDto;
import com.IServerBE.entity.RoomUser;
import com.IServerBE.service.RoomUserService;
import com.IServerBE.service.impl.RoomUserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping("/roomUsers")
public class RoomUserController {
    private final RoomUserService roomUserService;
    @GetMapping("")
    public ResponseEntity<?> getAllRoomUsers() {
        List<RoomUserResponseDto> roomUserResponseDtoList = roomUserService.getAllRoomUsers();
        if (!roomUserResponseDtoList.isEmpty()) {
            return ResponseEntity.ok().body(roomUserResponseDtoList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/roomId/{roomId}")
    public ResponseEntity<?> getRoomUserByRoomId(@PathVariable Long roomId) {
        List <RoomUserResponseDto> roomUserResponseDto = roomUserService.getRoomUserByRoomId(roomId);
        if (!roomUserResponseDto.isEmpty()) {
            return ResponseEntity.ok().body(roomUserResponseDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<?> getRoomUserByUserId(@PathVariable Long userId) {
        List <RoomUserResponseDto> roomUserResponseDto = roomUserService.getRoomUserByUserId(userId);
        if (!roomUserResponseDto.isEmpty()) {
            return ResponseEntity.ok().body(roomUserResponseDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getRoomUserById(@PathVariable Long id) {
        Optional<RoomUserResponseDto> roomUserResponseDto = Optional.of(roomUserService.getRoomUserById(id));
        if (roomUserResponseDto.isPresent()) {
            return ResponseEntity.ok().body(roomUserResponseDto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<?> saveRoomUser(@RequestBody RoomUserRequestDto roomUserRequestDto) {
        Optional<RoomUserResponseDto> roomUserResponseDto = Optional.of(roomUserService.saveRoomUser(roomUserRequestDto));
        if (roomUserResponseDto.isPresent()){
            return ResponseEntity.ok().body(roomUserResponseDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoomUser(@PathVariable Long id) {
        Optional<RoomUserResponseDto> roomUserResponseDto = Optional.of(roomUserService.getRoomUserById(id));
        if (roomUserResponseDto.isPresent()){
            roomUserService.deleteRoomUserById(id);
            return ResponseEntity.ok().body(roomUserResponseDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
