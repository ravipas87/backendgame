package com.ravipas.backendgame.dto;

import com.ravipas.backendgame.models.PlayOption;
import com.ravipas.backendgame.models.PlayResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GameResult {
    private PlayOption userPlay;
    private PlayOption systemPlay;
    private PlayResult result;
}

