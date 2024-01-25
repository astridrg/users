package com.app.user.repository.jpa;

import com.app.user.repository.model.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CreateUserRepository extends JpaRepository <UserRepository, UUID> {

}
