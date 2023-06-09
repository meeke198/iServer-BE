package com.IServerBE.dto.roomDto;

import com.IServerBE.dto.roomUserDto.response.RoomUserResponseDto;
import com.IServerBE.entity.Message;
import com.IServerBE.entity.RoomUser;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class RoomResponseDto {
    private Long id;
    @Nullable
    private String name;
//    @Nullable
//    private LocalDateTime createAt = LocalDateTime.now();
//    @Nullable
    private List<RoomUserResponseDto> RoomUserResponseDtoList;
    @Nullable
    private List<Message> messageList;
}
