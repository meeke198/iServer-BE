package com.IServerBE.dto.userDto.request;
import com.IServerBE.entity.Message;
import com.IServerBE.entity.RoomUser;
import lombok.*;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
//enable method-level validation in addition to the default bean validation
public class UserCreateRequestDto {
    @NotNull
    private String fullName;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_]{3,20}$", message = "Invalid username with special characters")
    private String userName;
    @NotNull
    @Email
    //    The regexp attribute specifies the regex pattern to validate the username.
    @Pattern(regexp ="^[A-Za-z0-9_.-]+@[A-Za-z0-9.-]+${8,}$", message = "Invalid email with special characters")
    private String email;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Minimum 8 characters, contains at least 1 uppercase letter, and 1 special character")
    private String password;
    private String phone;
    @Nullable
    private String avatar;
    @NotNull
    private Boolean isActive = true;
    private String rememberToken;
    private List<RoomUser> RoomUserList;
    private List<Message> messageList;

}
