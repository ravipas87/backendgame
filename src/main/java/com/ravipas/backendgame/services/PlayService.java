package com.ravipas.backendgame.services;

import com.ravipas.backendgame.dto.GameResult;
import com.ravipas.backendgame.models.Play;
import com.ravipas.backendgame.models.PlayOption;
import com.ravipas.backendgame.models.PlayResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayService implements IPlayService{

    @Autowired
    private IAprocess iaprocess;

    @Autowired
    private SavePlayService savePlayService;

    @Override
    public GameResult createPlay(String userId, PlayOption playerPlay) {
        PlayOption systemPlay=iaprocess.generatePlayOption();
        PlayResult playResult=this.evaluatePlay(systemPlay, playerPlay);
        this.savePlayService.savePlay(Play.builder().userId(userId).userPlay(playerPlay).systemPlay(systemPlay).build(), playResult);

        return new GameResult(playerPlay,systemPlay,playResult);
    }

    private PlayResult evaluatePlay(PlayOption computerPlay, PlayOption playerPlay){
        if (computerPlay==playerPlay){
            return PlayResult.TIE;
        } else if ((computerPlay==PlayOption.ROCK && playerPlay==PlayOption.SCISSORS)
                || (computerPlay==PlayOption.SCISSORS && playerPlay==PlayOption.PAPER)
                || (computerPlay==PlayOption.PAPER && playerPlay==PlayOption.ROCK)) {
            return PlayResult.LOSE;
        } else {
            return PlayResult.WIN;
        }
    }

}

