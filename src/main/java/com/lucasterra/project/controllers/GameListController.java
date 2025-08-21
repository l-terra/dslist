package com.lucasterra.project.controllers;

import com.lucasterra.project.dto.GameDTO;
import com.lucasterra.project.dto.GameListDTO;
import com.lucasterra.project.dto.GameMinDTO;
import com.lucasterra.project.services.GameListService;
import com.lucasterra.project.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }
}
