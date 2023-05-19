package com.IServerBE.entity;
import com.IServerBE.entity.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDateTime createAt = LocalDateTime.now();
    @JsonIgnore
    @OneToMany(mappedBy = "room")
    private List<RoomUser> RoomUserList;

    @JsonIgnore
    @OneToMany(mappedBy = "room")
    private List<Message> messageList;

}
//    The associations between the entities are as follows:

//        One-to-Many relationship between User and RoomUser: Each User can be associated with multiple RoomUser records, representing the rooms they have joined.
//        One-to-Many relationship between Room and RoomUser: Each Room can be associated with multiple RoomUser records, representing the users who have joined the room.
//        One-to-Many relationship between Room and Message: Each Room can be associated with multiple Message records, representing the messages sent in that room.
//        One-to-Many relationship between User and Message: Each User can be associated with multiple Message records, representing the messages they have sent.