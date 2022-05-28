package com.project.mabarba.service.impl;

import com.project.mabarba.models.*;
import com.project.mabarba.payload.request.*;
import com.project.mabarba.repository.CarnetRepository;
import com.project.mabarba.repository.CoiffeurRepository;
import com.project.mabarba.repository.CoiffureRepository;
import com.project.mabarba.repository.SalonRepository;
import com.project.mabarba.service.ManagerUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;

@Service
public class ManagerUpdateImpl implements ManagerUpdateService {
    @Autowired
    SalonRepository salonRepository;

    @Autowired
    CoiffeurRepository coiffeurRepository;

    @Autowired
    CoiffureRepository coiffureRepository;

    @Autowired
    CarnetRepository carnetRepository;

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

    /**
     * Gestion des coiffeurs
     */
    @Override
    //Creation d'un coiffeur
    public Coiffeur barberCreation(CoiffeurRequest coiffeurRequest) {
        Supplier<Coiffeur> coiffeur = ()->new Coiffeur(coiffeurRequest.getNom(), coiffeurRequest.getTelephone());
        return coiffeurRepository.save(coiffeur.get());
    }

    @Override
    //Mise à jour du coiffeur
    public Coiffeur barberModification(CoiffeurRequest coiffeurRequest, Long id) {
        Supplier<Coiffeur> coiffeur = ()->new Coiffeur(id,coiffeurRequest.getNom(), coiffeurRequest.getTelephone());
        return coiffeurRepository.save(coiffeur.get());
    }



    /**
     * Gestion des Coiffures
     */
    @Override
    //Creation d'une coiffure
    public Coiffure coiffureCreation(CoiffureRequest coiffureRequest){
        Coiffure coiffure = new Coiffure(coiffureRequest.getNom(), coiffureRequest.getPrix());
        return coiffureRepository.save(coiffure);
    }

    @Override
    public Coiffure coiffureModification(CoiffureRequest coiffureRequest, Long id) {
        Coiffure coiffure = new Coiffure(id,coiffureRequest.getNom(),coiffureRequest.getPrix());
        return coiffureRepository.save(coiffure);
    }
    /**
     * Gestion des carnets
     */
    @Override
    public Carnet carnetCreation(CarnetRequest carnetRequest){
        Carnet carnet = new Carnet(carnetRequest.getNom());
        return carnetRepository.save(carnet);
    }
    @Override
    public Carnet carnetModification(CarnetRequest carnetRequest, Long id){
        Carnet carnet = new Carnet(id,carnetRequest.getNom());
        return carnetRepository.save(carnet);
    }
    //Création d'un plage horaire
    @Override
    public PlageHoraire plageHoraireCreation(PlageHoraireRequest plageHoraireRequest) {
        PlageHoraire plageHoraire = new PlageHoraire(plageHoraireRequest.getDebut(), plageHoraireRequest.getFin(), plageHoraireRequest.getFin());
        return plageHoraire;
    }
    //Modification d'une plage horaire
    @Override
    public PlageHoraire plageHoraireModification(PlageHoraireRequest plageHoraireRequest, Long id) {
        PlageHoraire plageHoraire = new PlageHoraire(id,plageHoraireRequest.getDebut(),plageHoraireRequest.getFin(), plageHoraireRequest.getJour());
        return plageHoraire;
    }

}
