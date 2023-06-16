package com.IServerBE.controller.controller_FE_SE;

import com.IServerBE.dto.roomDto.RoomRequestDto;
import com.IServerBE.dto.roomDto.RoomResponseDto;
import com.IServerBE.dto.userDto.response.UserResponseDto;
import com.IServerBE.entity.Room;
import com.IServerBE.service.RoomService;
import com.IServerBE.service.impl.RoomServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getRoom(@PathVariable Long id){
        Optional<RoomResponseDto> roomResponseDto = Optional.of(roomService.getRoom(id));
        if(roomResponseDto.isPresent()){
            return ResponseEntity.ok().body(roomResponseDto);
        } else {
            return new ResponseEntity<>("Room doesn't exist", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getAllRooms(){
        List<RoomResponseDto> roomResponseDtoList = roomService.getAllRooms();
        if(roomResponseDtoList != null){
            return ResponseEntity.ok().body(roomResponseDtoList);
        }else{
            return new ResponseEntity<>("No room exists", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> saveRoom(@RequestBody RoomRequestDto roomRequestDto){
        RoomResponseDto roomResponseDto = roomService.saveRoom(roomRequestDto);
        return ResponseEntity.ok().body(roomResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editRoom(@RequestBody RoomRequestDto roomRequestDto, @PathVariable Long id){
        Optional<RoomResponseDto> searchRoom = Optional.of(roomService.getRoom(id));
        if (searchRoom.isPresent()) {
           RoomResponseDto roomResponseDto = roomService.updateRoom(roomRequestDto, id);
            return ResponseEntity.ok().body(roomResponseDto);
        }
        return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id){
        roomService.deleteRoomById(id);
    }
}
