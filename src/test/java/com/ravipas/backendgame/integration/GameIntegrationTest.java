package com.ravipas.statsService.integration;

import com.ravipas.backendgame.BackendgameApplication;
import com.ravipas.backendgame.dto.GameResult;
import com.ravipas.backendgame.models.PlayOption;
import com.ravipas.backendgame.models.PlayResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest(classes = BackendgameApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GameIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testPlayingGame() {
        assertEquals(
                this.restTemplate
                        .getForObject("http://localhost:" + port + "/play/ROCK", GameResult.class).getUserPlay(), PlayOption.ROCK);
        //TODO: (expand) actual logic is tested at service level, but anyway we could ensure that we receive complete data
    }


    //TODO: expand testing the diferent options
}