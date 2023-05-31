package com.IServerBE.repository;
import com.IServerBE.dto.messageDto.response.MessageResponseDto;
import com.IServerBE.entity.Message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {
    @Query(value="SELECT m FROM Message m WHERE m.room.id = ?1")
    List<MessageResponseDto> getAllMessageByRoomId(Long roomId);

}
