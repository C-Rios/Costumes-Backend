package com.mintic.reto3ciclo3.service;

import com.mintic.reto3ciclo3.model.Score;
import com.mintic.reto3ciclo3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return (List<Score>) scoreRepository.getScores();
    }

    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }

    public Score save(Score score){
        if(score.getId()==null)
            return scoreRepository.save(score);
        else{
            Optional<Score> e = scoreRepository.getScore(score.getId());

            if(e.isEmpty())
                return scoreRepository.save(score);
            else
                return score;
        }
    }

    public Score update(Score score){
        if(score.getId()!=null){
            Optional<Score> e = scoreRepository.getScore(score.getId());
            if(!e.isEmpty()){
                if(score.getReservation()!=null)
                    e.get().setReservation(score.getReservation());
                if(score.getComment()!=null)
                    e.get().setComment(score.getComment());
                if(score.getStars()!=null)
                    e.get().setStars(score.getStars());

                scoreRepository.save(e.get());
                return e.get();
            }else {
                return score;
            }
        }else
            return score;
    }

    public boolean delete(int id){
        return getScore(id).map(score -> {
           scoreRepository.delete(score);
           return true;
        }).orElse(false);
    }
}
