package com.IServerBE.controller.controller_FE_SE;

import com.IServerBE.dto.roomDto.RoomResponseDto;
import com.IServerBE.entity.Room;
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
    private final RoomServiceImpl roomService;
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
        Optional<List<RoomResponseDto>> roomResponseDtoList = Optional.of(roomService.getAllRooms());
        if(roomResponseDtoList.isPresent()){
            return ResponseEntity.ok().body(roomResponseDtoList);
        }else{
            return new ResponseEntity<>("No room exists", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> saveRoom(@RequestBody Room room){
        RoomResponseDto roomResponseDto = roomService.saveRoom(room);
        return ResponseEntity.ok().body(roomResponseDto);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id){
        roomService.deleteRoomById(id);
    }
}
