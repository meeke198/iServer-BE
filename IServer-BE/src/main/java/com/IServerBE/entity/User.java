package com.IServerBE.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
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

    @NotBlank
    @Column(name = "full_name", length = 255, nullable = false)
    private String fullName;

    @Column(name = "create_at", length = 255, nullable = true)
    private LocalDateTime createAt = LocalDateTime.now();

    @NotBlank
    @Column(name = "username", length = 20, nullable = false)
    private String userName;

    @Column(name = "password", length = 255, nullable = true)
    private String password;

    @NotBlank
    @Column(name = "email", length = 255, nullable = false)
    private String email;


    @Column(name = "phone", length = 12, nullable = true)
    private String phone;


    @Column(name = "avatar",
            columnDefinition = "text", nullable = true)
    private String avatar;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "remember_token", length = 255, nullable = true)
    private String rememberToken;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<RoomUser> RoomUserList;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Message> messageList;
}
//

//        One-to-Many relationship between User and RoomUser: Each User can be associated with multiple RoomUser records, representing the rooms they have joined.
//        One-to-Many relationship between Room and RoomUser: Each Room can be associated with multiple RoomUser records, representing the users who have joined the room.
//        One-to-Many relationship between Room and Message: Each Room can be associated with multiple Message records, representing the messages sent in that room.
//        One-to-Many relationship between User and Message: Each User can be associated with multiple Message records, representing the messages they have sent.