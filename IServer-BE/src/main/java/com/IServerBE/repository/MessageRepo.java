package com.IServerBE.repository;
import com.IServerBE.dto.messageDto.response.MessageResponseDto;
import com.IServerBE.entity.Message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {
//    @Query(value="SELECT m FROM Message m WHERE m.room.id = ?1")
//    Optional<List<Message>> getAllMessageByRoomId(Long roomId);

    List<Message> getMessagesByRoomId(Long roomId);
    @Query(value="SELECT m FROM Message m WHERE m.user.id = ?1")
    List<Message> getMessagesByUserId(Long userId);

}
