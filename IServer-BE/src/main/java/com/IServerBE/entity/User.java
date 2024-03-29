package com.IServerBE.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "username", length = 20,nullable = false)
    private String userName;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "email", length = 255, nullable = false)
    private String email;


    @Column(name = "avatar", columnDefinition = "text", nullable = true)
    private String avatar;

    @Column(name = "is_active", nullable = true)
    private Boolean isActive = true;
    @Column(name = "is_online", nullable = true)
    private Boolean isOnline = false;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<RoomUser> RoomUserList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Message> messageList;
}
//

//        One-to-Many relationship between User and RoomUser: Each User can be associated with multiple RoomUser records, representing the rooms they have joined.
//        One-to-Many relationship between Room and RoomUser: Each Room can be associated with multiple RoomUser records, representing the users who have joined the room.
//        One-to-Many relationship between Room and Message: Each Room can be associated with multiple Message records, representing the messages sent in that room.
//        One-to-Many relationship between User and Message: Each User can be associated with multiple Message records, representing the messages they have sent.