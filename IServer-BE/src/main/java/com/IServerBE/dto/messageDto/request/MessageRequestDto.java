package com.IServerBE.dto.messageDto.request;

import com.IServerBE.entity.Room;
import com.IServerBE.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class MessageRequestDto {
    private String content;
    private Room room;
    private User user;
    private LocalDateTime sentAt = LocalDateTime.now();

}
