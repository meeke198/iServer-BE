package com.IServerBE.repository;
import com.IServerBE.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.userName = ?1")
    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.userName = ?1 AND u.password = ?2")
    Optional<User> loginUser(String username, String password);

}
