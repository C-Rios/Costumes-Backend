package com.mintic.reto3ciclo3.service;

import com.mintic.reto3ciclo3.model.Reservation;
import com.mintic.reto3ciclo3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getReservations();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation reservation){
        if(reservation.getId()==null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> e = reservationRepository.getReservation(reservation.getId());

            if(e.isEmpty())
                return reservationRepository.save(reservation);
            else
                return reservation;
        }
    }

    public Reservation update(Reservation reservation){
        if(reservation.getId()!=null){
            Optional<Reservation> e = reservationRepository.getReservation(reservation.getId());
            if(!e.isEmpty()){
                if(reservation.getCostume()!=null)
                    e.get().setCostume(reservation.getCostume());
                if(reservation.getClient()!=null)
                    e.get().setClient(reservation.getClient());
                if(reservation.getScore()!=null)
                    e.get().setScore(reservation.getScore());
                if(reservation.getStartDate()!=null)
                    e.get().setStartDate(reservation.getStartDate());
                if(reservation.getEndDate()!=null)
                    e.get().setEndDate(reservation.getEndDate());

                reservationRepository.save(e.get());
                return e.get();
            }else{
                return reservation;
            }

        }else{
            return reservation;
        }
    }

    public boolean delete(int id){
        Boolean isDeleted = getReservation(id).map(reservation -> {
           reservationRepository.delete(reservation);
           return true;
        }).orElse(false);
        return isDeleted;
    }
}
