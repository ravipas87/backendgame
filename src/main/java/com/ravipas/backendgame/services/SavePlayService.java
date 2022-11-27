package com.ravipas.backendgame.services;

import com.ravipas.backendgame.models.Play;
import com.ravipas.backendgame.models.PlayResult;
import com.ravipas.backendgame.models.StatsData;
import com.ravipas.backendgame.persistence.IPlaysRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SavePlayService implements ISavePlayService {

    @Autowired
    IPlaysRepository playRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;
    @Override
    public Play savePlay(Play play, PlayResult playResult) {
        //TODO: we need service discovery instead of hardcoding de url
        //TODO: we could combine request with MONO and return aggregated result of rest inc ase we dont return anything
        // give notice to user that stats systems maybe down and stats will not be saved

        //TODO: hitting endpoint feels very hard-coded and not well designed , revisit this implementation
        //async task
            webClientBuilder.build()
                    .patch()
                    .uri("http://localhost:8081/"+playResult.toString().toLowerCase()+"/" + play.getUserId())
                    .retrieve()
                    .bodyToMono(StatsData.class).subscribe();

        return this.playRepository.save(play);
    }
}
