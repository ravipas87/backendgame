package com.ravipas.backendgame.services;

import com.ravipas.backendgame.dto.GameResult;
import com.ravipas.backendgame.models.PlayOption;

public interface IPlayService {
    public GameResult createPlay(String userId, PlayOption UserPlay );

}
