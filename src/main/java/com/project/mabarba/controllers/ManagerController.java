package com.project.mabarba.controllers;

import java.util.List;
import java.util.Map;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.models.Salon;
import com.project.mabarba.payload.request.CoiffeurRequest;
import com.project.mabarba.payload.request.SalonRequest;
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
    ManagerUpdateService managerUpadateService;

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
        Salon salon = managerUpadateService.salonCreation(salonRequest);
        return new RestResponse(salon,"Salon created successfuly", ResponseStatus.SUCCESS,200);
    }

    @PutMapping(path="/salon/{id}", name="update")
    @ApiOperation("Modification d'un salon de coiffure à l'aide de son id")
    public RestResponse salonModification(@RequestBody SalonRequest salonRequest, @PathVariable Long id){
        Salon salon = managerUpadateService.salonModification(salonRequest, id);
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
        Coiffeur coiffeur = managerUpadateService.barberCreation(coiffeurRequest);
        return new RestResponse(coiffeur,"Barber created successfuly",ResponseStatus.SUCCESS,200);
    }

    @PutMapping(path = "/barber/{id}", name = "update")
    @ApiOperation("Modification d'un coiffeur à l'aide de son id")
    public RestResponse barberModification(@RequestBody CoiffeurRequest coiffeurRequest, @PathVariable Long id){
        Coiffeur coiffeur = managerUpadateService.barberModification(coiffeurRequest,id);
        return new RestResponse(coiffeur,"Barber updated successfully", ResponseStatus.SUCCESS,201);
    }
}
