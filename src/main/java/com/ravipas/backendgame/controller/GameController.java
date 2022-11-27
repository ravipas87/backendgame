package com.ravipas.backendgame.controller;

import com.ravipas.backendgame.dto.GameResult;
import com.ravipas.backendgame.models.PlayOption;
import com.ravipas.backendgame.services.PlayService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class GameController {

    @Autowired
    PlayService playService;

    @Operation(summary = "Get the result of a new play")
    @GetMapping("/play/{playOption}")
    public GameResult getNewPlay(@PathVariable PlayOption playOption,@CookieValue(name = "rps-user-id" ,defaultValue = "anon_user") String userId) {
        //TODO: review why swagger has trouble with cookie header, in order to adress that I added defaultValue
        log.info("Getting a new play for user "+ "user" + playOption.toString());
        return this.playService.createPlay(userId,playOption);

    }

    //TODO: remove for this we have SPRING ACTUATOR
    @Operation(summary = "Simple tester that system is available CHANGE FOR SPRING ACTUATOR")
    @GetMapping("/available")
    public String available() {
        log.info("up and running");
        return "{\"text\":\"I'm up and runnig\"}";

    }
}
