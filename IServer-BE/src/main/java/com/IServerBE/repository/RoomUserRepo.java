package com.IServerBE.repository;
import com.IServerBE.dto.roomUserDto.response.RoomUserResponseDto;
import com.IServerBE.dto.userDto.response.UserResponseDto;
import com.IServerBE.entity.RoomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomUserRepo extends JpaRepository<RoomUser, Long> {
    List<RoomUser> findByRoomId(Long roomId);
    List<RoomUser> findByUserId(Long userId);

}
