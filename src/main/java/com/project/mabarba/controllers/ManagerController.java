package com.project.mabarba.controllers;

import java.util.List;
import java.util.Map;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.models.*;
import com.project.mabarba.payload.request.*;
import com.project.mabarba.payload.response.ResponseStatus;
import com.project.mabarba.payload.response.RestResponse;
import com.project.mabarba.service.ManagerRetrieveService;
import com.project.mabarba.service.ManagerUpdateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class ManagerController {
    @Autowired
    ManagerRetrieveService managerRetrieveService;

    @Autowired
    ManagerUpdateService managerUpdateService;

    /******************* Salon endpoints ************************/
    @GetMapping(path = "/salon/{id}", name = "read")
    @ApiOperation("Affichage d'un Salon de coiffure")
    public RestResponse salonDisplayed(@PathVariable long id) throws NoDataFoundException {
        if (id > 0) {
            Salon salon = managerRetrieveService.salonDisplayed(id);
            if (salon != null) {
                return new RestResponse(salon, "Salon sucessfully displayed!", ResponseStatus.SUCCESS, 200);
            } else {
                return new RestResponse("this salon does not exist", ResponseStatus.ABORTED, 404);
            }
        } else {
            return new RestResponse("Fatal error : this Id does not existe", ResponseStatus.FAILED, 400);
        }
    }

    @GetMapping(path = "/salons-all", name = "all")
    @ApiOperation("Affichage de la liste de tous les Salons de coiffure sans pagination")
    public RestResponse salonDisplayedList() throws NoDataFoundException {
        List<Salon> salonList = managerRetrieveService.salonDisplayedList();
        if (!salonList.isEmpty()) {
            return new RestResponse(salonList, "Salon List displayed!", ResponseStatus.SUCCESS, 200);
        } else {
            return new RestResponse("No salon at the moment !", ResponseStatus.ABORTED, 404);
        }
    }

    @GetMapping(path = "/salons-by-page", name = "list")
    @ApiOperation("Affichage de la liste de tous les Salons avec pagination")
    public RestResponse salonDisplayedPage(@RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", defaultValue = "2") int pageSize) {
        if (pageNo >= 0 && pageSize >= 0) {
            Map<String, Object> salon = managerRetrieveService.salonDisplayedPage(pageNo, pageSize);
            if (salon != null) {

                return new RestResponse(salon, "Salons with pagination displayed!", ResponseStatus.SUCCESS, 200);
            } else {
                return new RestResponse("this salon does not exist", ResponseStatus.ABORTED, 404);
            }
        } else {
            return new RestResponse("Fatal error : pagesize and page number must be positif", ResponseStatus.FAILED,
                    400);
        }
    }

    @PostMapping(path = "/salon", name = "create")
    @ApiOperation("Création d'un salon de coiffure")
    public RestResponse salonCreation(@RequestBody SalonRequest salonRequest){
        Salon salon = managerUpdateService.salonCreation(salonRequest);
        return new RestResponse(salon,"Salon created successfuly", ResponseStatus.SUCCESS,200);
    }

    @PutMapping(path="/salon/{id}", name="update")
    @ApiOperation("Modification d'un salon de coiffure à l'aide de son id")
    public RestResponse salonModification(@RequestBody SalonRequest salonRequest, @PathVariable Long id){
        Salon salon = managerUpdateService.salonModification(salonRequest, id);
        return new RestResponse(salon,"Salon updated successfuly", ResponseStatus.SUCCESS,200);
    }

    /******************* Coiffeur endpoints ************************/
    @GetMapping(path = "/barber/{id}", name = "read")
    @ApiOperation("Affichage d'un Coiffeur")
    public RestResponse barberDisplayed(@PathVariable long id) throws NoDataFoundException {
        if (id > 0) {
            Coiffeur coiffeur = managerRetrieveService.barberDisplayed(id);
            if (coiffeur != null) {

                return new RestResponse(coiffeur, "Barber successfully displayed!", ResponseStatus.SUCCESS, 200);
            } else {
                return new RestResponse("this Barber does not exist", ResponseStatus.ABORTED, 404);
            }
        } else {
            return new RestResponse("Fatal error : this Id does not existe", ResponseStatus.FAILED, 400);
        }
    }

    @GetMapping(path = "/barbers-all", name = "all")
    @ApiOperation("Affichage de la liste de tous les Coiffeurs sans pagination")
    public RestResponse barberDisplayedList() {
        List<Coiffeur> coiffeur = managerRetrieveService.barberDisplayedList();
        if (coiffeur != null) {
            return new RestResponse(coiffeur, "Barber List displayed!", ResponseStatus.SUCCESS, 200);
        } else {
            return new RestResponse("Barbers empty", ResponseStatus.ABORTED, 404);
        }

    }

    @GetMapping(path = "/barber-by-page", name = "list")
    @ApiOperation("Affichage de la liste de tous les coiffeurs avec pagination")
    public RestResponse barberDisplayedPage(@RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", defaultValue = "2") int pageSize) {

        if (pageNo >= 0 && pageSize >= 0) {
            Map<String, Object> coiffeur = managerRetrieveService.barberDisplayedPage(pageNo, pageSize);
            if (coiffeur != null) {
                return new RestResponse(coiffeur, "Barbers with pagination displayed!", ResponseStatus.SUCCESS, 200);
            } else {
                return new RestResponse("this Barber does not exist", ResponseStatus.ABORTED, 404);
            }
        } else {
            return new RestResponse("Fatal error : pagesize and page number must be positif", ResponseStatus.FAILED,
                    400);
        }
    }

    @PostMapping(path = "/barber", name = "create")
    @ApiOperation("Création d'un coiffeur")
    public RestResponse barberCreation(@RequestBody CoiffeurRequest coiffeurRequest){
        Coiffeur coiffeur = managerUpdateService.barberCreation(coiffeurRequest);
        return new RestResponse(coiffeur,"Barber created successfuly",ResponseStatus.SUCCESS,201);
    }

    @PutMapping(path = "/barber/{id}", name = "update")
    @ApiOperation("Modification d'un coiffeur à l'aide de son id")
    public RestResponse barberModification(@RequestBody CoiffeurRequest coiffeurRequest, @PathVariable Long id){
        Coiffeur coiffeur = managerUpdateService.barberModification(coiffeurRequest,id);
        return new RestResponse(coiffeur,"Barber updated successfully", ResponseStatus.SUCCESS,200);
    }

    /**************** Coiffure endpoints *******************************/
    //Création d'une coiffure
    @PostMapping(path = "/coiffure", name = "create")
    @ApiOperation("Création d'une coiffure")
    public RestResponse coiffureCreation(@RequestBody CoiffureRequest coiffureRequest){
        Coiffure coiffure = managerUpdateService.coiffureCreation(coiffureRequest);
        return new RestResponse(coiffure,"La création de la coiffure a réussie",ResponseStatus.SUCCESS,201);
    }
    //Modificqtion d'une coiffure
    @PutMapping(path = "/coiffure/{id}", name = "Update")
    @ApiOperation("Modificqtion d'une coiffure")
    public RestResponse coiffureModification(@RequestBody CoiffureRequest coiffureRequest, @PathVariable Long id){
        Coiffure coiffure = managerUpdateService.coiffureModification(coiffureRequest,id);
        return new RestResponse(coiffure, "Modification de la coiffure avec succes",ResponseStatus.SUCCESS,200);
    }
    //Information sur une coiffure
    /**
     *
     * @param id
     * @return
     */
    @GetMapping(path = "/coiffure/{id}")
    @ApiOperation("Afficher les informations sur une coiffure")
    public RestResponse coiffureDisplayed(@PathVariable Long id) throws NoDataFoundException{
        if(id<0) return new RestResponse("Fatal error : this Id does not exist",ResponseStatus.FAILED,400);
        Coiffure coiffure = managerRetrieveService.coiffureDisplayed(id);
        if(coiffure==null) return new RestResponse("Cette coiffure n'exsite pas",ResponseStatus.FAILED,404);
        return new RestResponse(coiffure,"La coiffure a été retrouvée",ResponseStatus.SUCCESS,200);
    }

    //Liste des coiffures
    /**
     *
     * @return
     */
    @GetMapping(path = "/coiffures", name = "all")
    @ApiOperation("Liste de toutes les coiffures")
    public RestResponse coiffureDisplayedList(){
        List<Coiffure> coiffureList = managerRetrieveService.coiffureDisplayedList();
        if(coiffureList.isEmpty()) return new RestResponse("Coiffures is empty",ResponseStatus.ABORTED,404);
        return new RestResponse("Coiffure list displayed successfully", ResponseStatus.SUCCESS,200);
    }

    //Liste des coiffures par page
    /**
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping(path = "/coiffures-by-page", name = "list")
    @ApiOperation("Liste des coiffures par page")
    public RestResponse coiffureDisplayedPage(@RequestParam(name = "pageNo", defaultValue = "0") int pageNo, @RequestParam(name = "pageSize", defaultValue = "2") int pageSize){
        if(pageNo<0||pageSize<0) return new RestResponse("Fatal error: pageSize and pageNo must positive",ResponseStatus.FAILED,400);
        Map<String, Object> coiffure = managerRetrieveService.coiffureDisplayedPage(pageNo, pageSize);
        if(coiffure==null) return new RestResponse("this coiffure does'nt exist",ResponseStatus.ABORTED,404);
        return new RestResponse(coiffure,"coiffure displayed with pagination", ResponseStatus.SUCCESS,200);
    }

    /******************* Carnet endpoints ******************************************/
    //Création d'un carnet
    @PostMapping(path = "/carnet", name = "create")
    @ApiOperation("Création du carnet d'un coiffeur")
    public RestResponse carnetCreation(@RequestBody CarnetRequest carnetRequest){
        Carnet carnet = managerUpdateService.carnetCreation(carnetRequest);
        return new RestResponse(carnet,"Création du carnet avec succes",ResponseStatus.SUCCESS,201);
    }
    //Modification d'un carnet

    /**
     *
     * @param carnetRequest
     * @param id
     * @return
     */
    @PutMapping(path="/carnet/{id}", name = "update")
    @ApiOperation("Modification du carnet d'un coiffeur")
    public RestResponse carnetModification(@RequestBody CarnetRequest carnetRequest, @PathVariable Long id){
        Carnet carnet = managerUpdateService.carnetModification(carnetRequest,id);
        return new RestResponse(carnet,"La modification a été effectuée avec succes",ResponseStatus.SUCCESS,201);
    }
    //Afficher un carnet

    /**
     *
     * @param id
     * @return
     * @throws NoDataFoundException
     */
    @GetMapping(path = "/carnet/{id}", name = "read")
    @ApiOperation("Afficher les informations sur un carnet")
    public RestResponse carnetDisplayed(@PathVariable Long id)throws NoDataFoundException{
        if(id<0) return new RestResponse("Fatal error: This id does not exist", ResponseStatus.FAILED,400);
        Carnet carnet = managerRetrieveService.carnetDisplayed(id);
        if(carnet==null) return new RestResponse("Ce carnet n'existe pas", ResponseStatus.FAILED,404);
        return new RestResponse(carnet, "Le carnet a ete trouve", ResponseStatus.SUCCESS,200);
    }
    //Afficher tous les carnets
    @GetMapping(path = "/carnets", name = "All")
    @ApiOperation("Affiche tous les carnets")
    public RestResponse carnetDisplayedList(){
        List<Carnet> carnetList = managerRetrieveService.carnetDisplayedList();
        if(carnetList.isEmpty()) return new RestResponse("Carnet is empty",ResponseStatus.ABORTED,401);
        return new RestResponse(carnetList,"Liste des carnets",ResponseStatus.SUCCESS,200);
    }
    //Lister les carnet par page

    /**
     *
     * @param pageSize
     * @param pageNo
     * @return
     */
    @GetMapping(path = "/carnets-by-page", name = "List")
    @ApiOperation("Afficher les informations sur les carnets par page")
    public RestResponse carnetDisplayedPage(@RequestParam(name = "pageNo", defaultValue = "0") int pageSize, @RequestParam(name = "pageSize", defaultValue = "0") int pageNo){
        if(pageNo<0||pageSize<0) return new RestResponse("Fatal error: pageSize and pageNo must positive",ResponseStatus.FAILED,400);
        Map<String, Object> carnet = managerRetrieveService.coiffureDisplayedPage(pageNo, pageSize);
        if(carnet==null) return new RestResponse("this carnet does'nt exist",ResponseStatus.ABORTED,404);
        return new RestResponse(carnet,"carnet displayed with pagination", ResponseStatus.SUCCESS,200);
    }

    /**
     * Gestion des plages horaires
     */
    //Créer une plage horaire
    @PostMapping(path = "/plage-horaire",name = "create")
    @ApiOperation("Créer une plage horaire")
    public RestResponse plageHoraireCreation(@RequestBody PlageHoraireRequest plageHoraireRequest){
        PlageHoraire plageHoraire = managerUpdateService.plageHoraireCreation(plageHoraireRequest);
        return new RestResponse(plageHoraire,"Création d'une plage horaire a réussie",ResponseStatus.SUCCESS,200);
    }
    //Modifier une plage horaire
    @PutMapping(path = "/plage-horaire/{id}", name = "update")
    @ApiOperation("Modifier une plage horaire")
    public RestResponse plageHoraireModification(@RequestBody PlageHoraireRequest plageHoraireRequest, @PathVariable Long id){
        PlageHoraire plageHoraire = managerUpdateService.plageHoraireModification(plageHoraireRequest, id);
        return new RestResponse(plageHoraire,"Modification de la plage horaire avec succes",ResponseStatus.SUCCESS,200);
    }
    //Afficher une plage horaire

    /**
     *
     * @param id
     * @return
     * @throws NoDataFoundException
     */
    @GetMapping(path = "/plage-horaire/{id}", name = "read")
    @ApiOperation("Afficher une plage horaire")
    public RestResponse plageHoraireDisplayed(@PathVariable Long id) throws NoDataFoundException{
        if(id<0) return new RestResponse("Fatal error: l'id doit être un nombre positif",ResponseStatus.FAILED,400);
        PlageHoraire plageHoraire = managerRetrieveService.plageHoraireDisplayed(id);
        if(plageHoraire==null) return new RestResponse("Cette plage horaire n'existe pas", ResponseStatus.FAILED,404);
        return new RestResponse(plageHoraire, "La plage horaire a ete trouve", ResponseStatus.SUCCESS,200);
    }
    //Afficher la liste des plages horaire
    @GetMapping(path = "/plages-horaires", name = "all")
    @ApiOperation("Afficher la liste des plages horaires")
    public RestResponse plageHoraireDisplayedList(){
        List<PlageHoraire> plageHoraireList = managerRetrieveService.plageHoraireDisplayedList();
        if(plageHoraireList.isEmpty()) return new RestResponse("Aucune plage horaire trouvée",ResponseStatus.ABORTED,404);
        return new RestResponse(plageHoraireList, "Liste des plages horaires", ResponseStatus.SUCCESS,200);
    }
    //Afficher la liste des plages horaires par page

    /**
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    public RestResponse plageHoraireDisplayedPage(@RequestParam(name = "pageNo", defaultValue = "0") int pageNo, @RequestParam(name = "pageSize", defaultValue = "2") int pageSize){
        if(pageNo<0||pageSize<0) return new RestResponse("Fatal error: pageSize and pageNo must positive",ResponseStatus.FAILED,400);
        Map<String, Object> plageHoraire = managerRetrieveService.plageHoraireDisplayedPage(pageNo, pageSize);
        if(plageHoraire==null) return new RestResponse("Cette plage horaire n'existe pas",ResponseStatus.ABORTED,404);
        return new RestResponse(plageHoraire,"Liste des plages horaires avec pagination", ResponseStatus.SUCCESS,200);
    }
}

