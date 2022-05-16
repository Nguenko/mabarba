package com.project.mabarba.service.impl;

import java.util.List;
import java.util.Map;

import com.google.common.base.Supplier;
import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.helpers.FunctionalUtilities;
import com.project.mabarba.models.Salon;
import com.project.mabarba.payload.request.SalonRequest;
import com.project.mabarba.repository.SalonRepository;
import com.project.mabarba.service.SalonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SalonServiceImpl implements SalonService{
    
    @Autowired
    SalonRepository salonRepository;

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
    public List<Salon> salonDisplayedList() {
         Supplier<List<Salon>> salonList = ()->salonRepository.findAllByOrderByCreatedAtDesc();
         return salonList.get();
    }
    
    @Override
    public Map<String, Object> salonDisplayedPage(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        try {
            Page<Salon> salonPage = salonRepository.findAllByOrderByCreatedAtDesc(pageable);
            //on appel la mathode utilitaire qui gere la pagination
             return new FunctionalUtilities<Salon>().paginator(salonPage);
        }catch (Exception e){
            e.getMessage();
        }

        return null;
    }

    /** Update Service implements */
    @Override
    //Creation d'un salon
    public Salon salonCreation(SalonRequest salonRequest) {
        Supplier<Salon> salon = ()->new Salon(salonRequest.getNom(), salonRequest.getTelephone());
        return salonRepository.save(salon.get());
    }

    @Override
    //Mise à jour d'un salon
    public Salon salonModification(SalonRequest salonRequest, Long id) {
        Supplier<Salon> salon = ()->new Salon(id, salonRequest.getNom(), salonRequest.getTelephone());
        return salonRepository.save(salon.get());
    }
}
