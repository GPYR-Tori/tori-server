package com.server.tori.repository;

import com.server.tori.entity.Dotori;
import com.server.tori.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DotoriRepository extends JpaRepository<Dotori, Long> {
    int countByUser(User user);
}
