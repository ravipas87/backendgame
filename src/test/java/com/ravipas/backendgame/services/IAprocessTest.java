package com.ravipas.backendgame.services;

import com.ravipas.backendgame.models.PlayOption;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

@SpringBootTest
public class IAprocessTest {
    @Autowired
    IAprocess iaprocess;

    @Test
    public void IAprocessGivesValidValues() {
        assertTrue(Arrays.stream(PlayOption.values()).collect(Collectors.toList()).contains(iaprocess.generatePlayOption()));
        //give it a few more runs
        assertTrue(Arrays.stream(PlayOption.values()).collect(Collectors.toList()).contains(iaprocess.generatePlayOption()));
        assertTrue(Arrays.stream(PlayOption.values()).collect(Collectors.toList()).contains(iaprocess.generatePlayOption()));
        assertTrue(Arrays.stream(PlayOption.values()).collect(Collectors.toList()).contains(iaprocess.generatePlayOption()));

    }

    @Test
    public void IAgivesBalancedValues() {
        //TODO: improve using statistical algorithms
        int scissors_score=0;
        int paper_score=0;
        int rock_score=0;
        for (int i=0;i<100;i++){
            switch(iaprocess.generatePlayOption()) {
                case PAPER:
                    paper_score++;
                    break;
                case SCISSORS:
                    scissors_score++;
                    break;
                case ROCK:
                    rock_score++;
                    break;
                default:
                    throw new RuntimeException("no valid option");
            }
        }

        assertTrue(rock_score>20);
        assertTrue(paper_score>20);
        assertTrue(scissors_score>20);
    }

}
