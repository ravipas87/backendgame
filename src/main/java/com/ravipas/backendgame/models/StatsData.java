package com.ravipas.backendgame.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
@Getter
@Setter
public class StatsData {
    @Id
    private int id;
    private String userId;
    private Integer winCount=0;
    private Integer loseCount=0;
    private Integer tieCount=0;

}
