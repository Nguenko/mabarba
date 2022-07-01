package com.project.mabarba.service.impl;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.models.*;
import com.project.mabarba.payload.request.*;
import com.project.mabarba.repository.*;
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

    @Autowired
    PlageHoraireRepository plageHoraireRepository;

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

    @Override
    public Boolean salonDelete(Long salonId) throws NoDataFoundException{
        Salon salon = salonRepository.findById(salonId).orElseThrow(()->new NoDataFoundException(salonId));
        salon.setDeleted(true);
        salonRepository.save(salon);
        return true;
    }
    /**
     * Gestion des coiffeurs
     */
    @Override
    //Creation d'un coiffeur
    public Coiffeur barberCreation(CoiffeurRequest coiffeurRequest) throws NoDataFoundException {
        Salon salon = salonRepository.findByIdAndDeletedIsFalse(coiffeurRequest.getSalonId())
                .orElseThrow(()->new NoDataFoundException("Salon"));
        Supplier<Coiffeur> coiffeurSupplier = ()->new Coiffeur(coiffeurRequest.getNom(), coiffeurRequest.getTelephone());
        Coiffeur coiffeur = coiffeurSupplier.get();
        coiffeur.setSalon(salon);
        return coiffeurRepository.save(coiffeur);
    }

    @Override
    //Mise à jour du coiffeur
    public Coiffeur barberModification(CoiffeurRequest coiffeurRequest, Long id) {
        Supplier<Coiffeur> coiffeur = ()->new Coiffeur(id,coiffeurRequest.getNom(), coiffeurRequest.getTelephone());
        return coiffeurRepository.save(coiffeur.get());
    }
    @Override
    public Boolean barberDelete(Long coiffeurId) throws NoDataFoundException{
        Coiffeur coiffeur = coiffeurRepository.findByIdAndDeletedIsFalse(coiffeurId).orElseThrow(()->new NoDataFoundException(coiffeurId));
        coiffeur.setDeleted(true);
        coiffeurRepository.save(coiffeur);
        return true;
    }



    /**
     * Gestion des Coiffures
     */
    @Override
    //Creation d'une coiffure
    public Coiffure coiffureCreation(CoiffureRequest coiffureRequest){
        Optional<Salon> salon = salonRepository.findByIdAndDeletedIsFalse(coiffureRequest.getSalonId());
        Coiffure coiffure = new Coiffure(coiffureRequest.getNom(), coiffureRequest.getPrix(),salon.get());
        return coiffureRepository.save(coiffure);
    }

    @Override
    public Boolean coiffureDelete(Long coiffureId) throws NoDataFoundException {
        Coiffure coiffure = coiffureRepository.findByIdAndDeletedIsFalse(coiffureId).orElseThrow(()->new NoDataFoundException(coiffureId));
        coiffure.setDeleted(true);
        coiffureRepository.save(coiffure);
        return true;
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
        Optional<Coiffeur> coiffeurOptional= coiffeurRepository.findByIdAndDeletedIsFalse(carnetRequest.getCoiffeurId());
        Coiffeur coiffeur = coiffeurOptional.get();
        coiffeur.setCarnet(carnet);
        coiffeurRepository.save(coiffeur);
        return coiffeur.getCarnet();
    }
    @Override
    public Carnet carnetModification(CarnetRequest carnetRequest, Long id){
        Carnet carnet = new Carnet(id,carnetRequest.getNom());
        return carnetRepository.save(carnet);
    }

    @Override
    public Boolean carnetDelete(Long carnetId) throws NoDataFoundException {
        Carnet carnet = carnetRepository.findByIdAndDeletedIsFalse(carnetId).orElseThrow(()-> new NoDataFoundException(carnetId));
        carnet.setDeleted(true);
        carnetRepository.save(carnet);
        return true;
    }

    //Création d'un plage horaire
    @Override
    public PlageHoraire plageHoraireCreation(PlageHoraireRequest plageHoraireRequest) {
        PlageHoraire plageHoraire = new PlageHoraire(plageHoraireRequest.getDebut(), plageHoraireRequest.getFin(), plageHoraireRequest.getJour());
        Optional<Carnet> carnetOptional = carnetRepository.findByIdAndDeletedIsFalse(plageHoraireRequest.getCarnetId());

        plageHoraire.setCarnet(carnetOptional.get());
        plageHoraire.setEtat(EEtat.NON_RESERVEE);
        return plageHoraireRepository.save(plageHoraire);
    }
    //Modification d'une plage horaire
    @Override
    public PlageHoraire plageHoraireModification(PlageHoraireRequest plageHoraireRequest, Long id) {
        PlageHoraire plageHoraire = new PlageHoraire(id,plageHoraireRequest.getDebut(),plageHoraireRequest.getFin(), plageHoraireRequest.getJour());
        return plageHoraireRepository.save(plageHoraire);
    }

    @Override
    public Boolean plageHoraireDelete(Long plageHoraireId) throws NoDataFoundException{
        PlageHoraire plageHoraire = plageHoraireRepository.findByIdAndDeletedIsFalse(plageHoraireId).orElseThrow(()-> new NoDataFoundException(plageHoraireId));
        plageHoraire.setDeleted(true);
        plageHoraireRepository.save(plageHoraire);
        return true;
    }

}
