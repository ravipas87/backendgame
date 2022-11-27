package com.ravipas.backendgame.services;

import com.ravipas.backendgame.models.Play;
import com.ravipas.backendgame.models.PlayResult;

public interface ISavePlayService {

    public Play savePlay(Play play, PlayResult playResult);

}
