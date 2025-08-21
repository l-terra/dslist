package com.lucasterra.project.repositories;

import com.lucasterra.project.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
