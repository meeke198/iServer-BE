package com.IServerBE.controller.controller_FE_SE;

import com.IServerBE.converter.UserConverter;
import com.IServerBE.dto.userDto.request.UserPasswordRequestDto;
import com.IServerBE.dto.userDto.request.UserRequestDto;
import com.IServerBE.dto.userDto.response.UserResponseDto;
import com.IServerBE.entity.User;
import com.IServerBE.service.UserService;
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
    private final UserService userService;
    private final UserConverter userConverter;


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
    public ResponseEntity<?> getAllActiveUsers(){
        List<UserResponseDto> userResponseDtoList = userService.getAllActiveUsers();
        if(userResponseDtoList != null){
            return ResponseEntity.ok().body(userResponseDtoList);
        }else{
            return new ResponseEntity<>("User doesn't exist", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/signout")
    public ResponseEntity<?> signOut(@RequestBody UserRequestDto userRequestDto){
        String email = userRequestDto.getEmail();
            userRequestDto.setIsOnline(false);
            userService.saveUser(userRequestDto);
            return new ResponseEntity<>("Sign out successfully", HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UserRequestDto userRequestDto, @PathVariable Long id) {
        Optional<UserResponseDto> searchUser = Optional.of(userService.findUserById(id));
        if (searchUser.isPresent()) {
            userService.saveUser(userRequestDto);
            return ResponseEntity.ok().body(userRequestDto);
        }
        return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
    }
//    @PutMapping("/password/{id}")
//    public ResponseEntity<?> updatePassword(@RequestBody UserRequestDto userRequestDto, @PathVariable Long id) {
//        Optional<UserResponseDto> searchUser = Optional.of(userService.findUserById(id));
//        if(searchUser.isPresent()){
//            String newPassword = userRequestDto.getNewPassword();
//            userRequestDto.setPassword(newPassword);
//            userService.saveUser(userRequestDto);
//            searchUser = Optional.of(userService.findUserById(id));
//            return ResponseEntity.ok().body(searchUser.get());
//        }else {
//            return new ResponseEntity<>("User doesn't exist", HttpStatus.BAD_REQUEST);
//        }
//    }
        @PostMapping("/signup")
        public ResponseEntity<?> signUp(@RequestBody UserRequestDto userRequestDto){
        UserResponseDto userEmail = userService.findUserByEmail(userRequestDto.getEmail());
       UserResponseDto userName = userService.findUserByUserName(userRequestDto.getUserName());
        if (userEmail != null || userName != null) {
//            throw new IllegalArgumentException("email & username links with an account, please log in");
            return new ResponseEntity<>("email & username links with an account, please log in", HttpStatus.BAD_REQUEST);
        } else {
            UserResponseDto userResponseDto = userService.saveUser(userRequestDto);
            if (userResponseDto != null) {
                return ResponseEntity.ok().body(userResponseDto);
            } else {
                return new ResponseEntity<>("User exists, please sign-in", HttpStatus.BAD_REQUEST);
            }
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody UserRequestDto userRequestDto){
        String email = userRequestDto.getEmail();
        String password = userRequestDto.getPassword();

       Optional<UserResponseDto> currentUser = Optional.of(userService.getUserByUserNameAndPassword(email, password));
        if (currentUser != null){
            userRequestDto.setIsOnline(true);
            userService.saveUser(userRequestDto);
            currentUser = Optional.of(userService.getUserByUserNameAndPassword(email, password));
            return new ResponseEntity<>(currentUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User doesn't exist, please sign-up", HttpStatus.NOT_FOUND);
        }
    }
//

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Long id) {
       UserResponseDto userResponseDto = userService.findUserById(id);
        if (userResponseDto == null) {
            return new ResponseEntity<String>("User doesn't exist", HttpStatus.BAD_REQUEST);
        } else {
            userService.deleteUserStatusById(id);
            return ResponseEntity.ok().body(userResponseDto);
        }

    }
}
