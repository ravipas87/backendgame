package com.ravipas.backendgame.persistence;

import com.ravipas.backendgame.models.Play;
import org.springframework.data.repository.CrudRepository;

public interface IPlaysRepository extends CrudRepository<Play, Integer> {

}
