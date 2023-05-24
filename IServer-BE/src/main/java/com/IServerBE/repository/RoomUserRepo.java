package com.IServerBE.repository;
import com.IServerBE.entity.RoomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomUserRepo extends JpaRepository<RoomUser, Long> {
}
