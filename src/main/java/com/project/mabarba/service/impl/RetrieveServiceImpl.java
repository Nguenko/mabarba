package com.project.mabarba.service.impl;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.models.Salon;
import com.project.mabarba.service.RetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import com.project.mabarba.repository.CoiffeurRepository;
import com.project.mabarba.repository.SalonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class RetrieveServiceImpl  implements RetrieveService {


    @Autowired
    SalonRepository salonRepository;

    @Autowired
    CoiffeurRepository coiffeurRepository;


    @Override
    public Salon salonDisplayed(long salonId) throws NoDataFoundException{
        return salonRepository.findByIdAndDeletedIsFalse(salonId).orElseThrow(()->new NoDataFoundException(salonId));

    }

    @Override
    public boolean salonDeleted(long salonId) throws NoDataFoundException{
        Salon salon = salonRepository.findByIdAndDeletedIsFalse(salonId).orElseThrow(()->new NoDataFoundException(salonId));
        salon.setDeleted(true);
        salonRepository.save(salon);
        return true;
    }

    @Override
    public Coiffeur barberDisplayed(long coiffeurId) throws NoDataFoundException{
        return   coiffeurRepository.findByIdAndDeletedIsFalse(coiffeurId).orElseThrow(()->new NoDataFoundException(coiffeurId));
    }

    @Override
    public boolean barberDeleted(long coiffeurId) throws NoDataFoundException{
        Coiffeur coiffeur = coiffeurRepository.findByIdAndDeletedIsFalse(coiffeurId).orElseThrow(()->new NoDataFoundException(coiffeurId));
        coiffeur.setDeleted(true);
        coiffeurRepository.save(coiffeur);
        return true;
    }

    @Override
    public List<Salon> salonDisplayedList(long salonId) {
         Supplier<List<Salon>> salonList = ()->salonRepository.findAllByIdAndDeletedIsFalse(salonId);
         return salonList.get();
    }

    @Override
    public List<Coiffeur> barberDisplayedList(long coiffeurId) {
        Supplier<List<Coiffeur>> coiffeurList = ()->coiffeurRepository.findAllByIdAndDeletedIsFalse(coiffeurId);
        return coiffeurList.get();
    }

    @Override
    public Page<Salon> salonDisplayedPage(long salonId) {
        return null;
    }

    @Override
    public Page<Salon>  barberDisplayedPage(long coiffeurId) {
        return null;
    }
}
