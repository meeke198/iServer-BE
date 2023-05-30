package com.IServerBE.controller.controller_FE_SE;

import com.IServerBE.dto.userDto.request.UserRequestDto;
import com.IServerBE.dto.userDto.response.UserResponseDto;
import com.IServerBE.entity.User;
import com.IServerBE.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        UserResponseDto userResponseDto = userService.findUserById(id);
        if(userResponseDto != null){
            return ResponseEntity.ok().body(userResponseDto);
        }else{
            return new ResponseEntity<>("User doesn't exist", HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("")
    public ResponseEntity<?> getAllUsers(){
        List<UserResponseDto> userResponseDto = userService.getAllUsers();
        if(userResponseDto != null){
            return ResponseEntity.ok().body(userResponseDto);
        }else{
            return new ResponseEntity<>("User doesn't exist", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> saveUser(@RequestBody UserRequestDto userRequestDto){
        UserResponseDto userResponseDto = userService.saveUser(userRequestDto);
            if(userResponseDto != null){
                return ResponseEntity.ok().body(userResponseDto);
            } else {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
       UserResponseDto userResponseDto = userService.findUserById(id);
        if (userResponseDto == null) {
            return new ResponseEntity<String>("delete failed", HttpStatus.BAD_REQUEST);
        }
       return ResponseEntity.ok().body(userResponseDto);
    }
}
