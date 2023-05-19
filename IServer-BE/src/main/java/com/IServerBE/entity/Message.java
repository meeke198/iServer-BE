package com.IServerBE.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name="room_id", referencedColumnName = "id")
    private Room room;
    private LocalDateTime sentAt = LocalDateTime.now();

}
//    The associations between the entities are as follows:

//        One-to-Many relationship between User and RoomUser: Each User can be associated with multiple RoomUser records, representing the rooms they have joined.
//        One-to-Many relationship between Room and RoomUser: Each Room can be associated with multiple RoomUser records, representing the users who have joined the room.
//        One-to-Many relationship between Room and Message: Each Room can be associated with multiple Message records, representing the messages sent in that room.
//        One-to-Many relationship between User and Message: Each User can be associated with multiple Message records, representing the messages they have sent.