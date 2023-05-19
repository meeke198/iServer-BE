package com.IServerBE.dto.messageDto.request;

import com.IServerBE.entity.Room;
import com.IServerBE.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class MessageRequestDto {
    private String content;
    private Room room;
    private LocalDateTime sentAt = LocalDateTime.now();

}
