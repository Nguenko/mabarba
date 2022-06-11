package com.project.mabarba.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.helpers.FunctionalUtilities;
import com.project.mabarba.models.*;
import com.project.mabarba.repository.*;
import com.project.mabarba.service.ManagerRetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class ManagerRetrieveImpl implements ManagerRetrieveService{
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
    public Salon salonDisplayed(long salonId) throws NoDataFoundException {
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

    /**
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
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

    @Override
    public List<Coiffeur> salonDisplayedCoiffeur(long salonId) throws NoDataFoundException {
        Salon salon = salonRepository.findByIdAndDeletedIsFalse(salonId).orElseThrow(()->new NoDataFoundException(salonId));
        List<Coiffeur> coiffeurList = coiffeurRepository.findBySalonId(salonId);
        return coiffeurList;
    }

    @Override
    public List<Coiffure>salonDisplayedCoiffure(long salonId) throws NoDataFoundException{
        Salon salon = salonRepository.findByIdAndDeletedIsFalse(salonId).orElseThrow(()->new NoDataFoundException(salonId));
        List<Coiffure> coiffureList = coiffureRepository.findBySalonId(salonId);
        return coiffureList;
    }

    /**
     * Gestion des coiffeurs
     */
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
    public List<Coiffeur> barberDisplayedList() {
        Supplier<List<Coiffeur>> coiffeurList = ()->coiffeurRepository.findAllByOrderByCreatedAtDesc();
        return coiffeurList.get();
    }

    /**
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public Map<String, Object>  barberDisplayedPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        try {
            Page<Coiffeur> barberPage = coiffeurRepository.findAllByOrderByCreatedAtDesc(pageable);
            //on appel la mathode utilitaire qui gere la pagination
            return new FunctionalUtilities<Coiffeur>().paginator(barberPage);
        }catch (Exception e){
            e.getMessage();
        }

        return null;
    }

    /**
     * Gestion des Coiffures
     */

    @Override
    public Coiffure coiffureDisplayed(long coiffureId) throws NoDataFoundException {
        return coiffureRepository.findByIdAndDeletedIsFalse(coiffureId).orElseThrow(()->new NoDataFoundException(coiffureId));
    }

    @Override
    public boolean coiffureDeleted(long coiffureId) throws NoDataFoundException {
        return false;
    }

    @Override
    public List<Coiffure> coiffureDisplayedList() {
        return coiffureRepository.findAllByOrderByCreatedAtDesc();
    }

    /**
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public Map<String, Object> coiffureDisplayedPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        try {
            Page<Coiffure> coiffurePage = coiffureRepository.findAllByOrderByCreatedAtDesc(pageable);
            //on appel la mathode utilitaire qui gere la pagination
            return new FunctionalUtilities<Coiffure>().paginator(coiffurePage);
        }
        catch (Exception e){
            e.getMessage();
        }
        return null;
    }

    /**
     * Gestion des carnets
     */
    @Override
    public Carnet carnetDisplayed(long carnetId) throws NoDataFoundException {
        return carnetRepository.findByIdAndDeletedIsFalse(carnetId).orElseThrow(()->new NoDataFoundException(carnetId));
    }
    public List<Carnet> carnetDisplayedList(){
        return carnetRepository.findAllByOrderByCreatedAtDesc();
    }

    /**
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public Map<String,Object> carnetDisplayedPage(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        try {
            Page<Carnet> carnetPage = carnetRepository.findAllByOrderByCreatedAtDesc(pageable);;
            return new FunctionalUtilities<Carnet>().paginator(carnetPage);
        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }

    @Override
    public Carnet carnetDisplayByCoiffeur(Long coiffeurId) throws NoDataFoundException{
        Carnet carnet = carnetRepository.findByCoiffeurIdAndDeletedIsFalse(coiffeurId).orElseThrow(()->new NoDataFoundException(coiffeurId));
        return carnet;
    }

    /**
     * Gestion des plages horaires
     */
    @Override
    public PlageHoraire plageHoraireDisplayed(long plageId) throws NoDataFoundException {
        //return plageHoraireRepository.findByIdAndDeleteIsFalse(plageId).orElseThrow(()->new NoDataFoundException(plageId));
        return null;
    }

    @Override
    public List<PlageHoraire> plageHoraireDisplayedList() {
        //List<PlageHoraire> plageHoraireList = plageHoraireRepository.findAllByOrderByCreatedAtDesc();
        //return plageHoraireList;
        return null;
    }

    @Override
    public Map<String, Object> plageHoraireDisplayedPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        try {
            //Page<PlageHoraire> plageHorairesPage = plageHoraireRepository.findAllByOrderByCreatedAtDesc(pageable);;
            //return new FunctionalUtilities<PlageHoraire>().paginator(plageHorairesPage);
        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }

    @Override
    public Carnet displayBarberPlaning(Long coiffeurId) throws NoDataFoundException {
        System.out.println("1");
        Optional<Carnet> carnetOptional = carnetRepository.findByCoiffeurIdAndDeletedIsFalse(coiffeurId);
        System.out.println("2");
        Carnet carnet = new Carnet();
        Carnet carnetResult = new Carnet();
        ObjectMapper carnetMapper = new ObjectMapper();
        try{
            System.out.println("3");
            if(carnetOptional.isPresent()){
                System.out.println("4");
                carnet = carnetOptional.get();
                System.out.println(carnet.getNom());
                System.out.println(carnet.getId());
                //carnetResult=carnetMapper.convertValue(carnet,Carnet.class);
                //System.out.println(carnetResult.toString());
                return  carnet;
            }
            System.out.println("5");
        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }
}
