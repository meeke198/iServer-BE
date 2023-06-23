package com.IServerBE.dto.roomDto;


import com.IServerBE.dto.roomUserDto.response.RoomUserResponseDto;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

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
//    private List<RoomUserResponseDto> RoomUserResponseDtoList;
}
