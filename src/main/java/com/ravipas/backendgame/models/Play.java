package com.ravipas.backendgame.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Builder
public class Play extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private String userId;
    private PlayOption systemPlay;
    private PlayOption userPlay;

}
