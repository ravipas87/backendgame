package com.ravipas.backendgame.services;

import com.ravipas.backendgame.models.PlayOption;
import org.springframework.stereotype.Service;

@Service
public class IAprocess {

    protected PlayOption generatePlayOption(){
        return PlayOption.values()[(int) (Math.random()*3)];
    }

}
