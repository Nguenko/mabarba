package com.project.mabarba.controllers;

import java.util.List;
import java.util.Map;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.payload.request.CoiffeurRequest;
import com.project.mabarba.payload.response.ResponseStatus;
import com.project.mabarba.payload.response.RestResponse;
import com.project.mabarba.service.CoiffeurService;

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
public class CoiffeurController {

    @Autowired
    CoiffeurService coiffeurService;

    @GetMapping(path = "/barber/{id}", name = "read")
    @ApiOperation("Affichage d'un Coiffeur")
    public RestResponse barberDisplayed(@PathVariable long id) throws NoDataFoundException {

        if (id > 0) {
            Coiffeur coiffeur = coiffeurService.barberDisplayed(id);
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

        List<Coiffeur> coiffeur = coiffeurService.barberDisplayedList();
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
            Map<String, Object> coiffeur = coiffeurService.barberDisplayedPage(pageNo, pageSize);
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
        Coiffeur coiffeur = coiffeurService.barberCreation(coiffeurRequest);
        return new RestResponse(coiffeur,"Barber created successfuly",ResponseStatus.SUCCESS,200);
    }

    @PutMapping(path = "/barber/{id}", name = "update")
    @ApiOperation("Modification d'un coiffeur à l'aide de son id")
    public RestResponse barberModification(@RequestBody CoiffeurRequest coiffeurRequest, @PathVariable Long id){
        Coiffeur coiffeur = coiffeurService.barberModification(coiffeurRequest,id);
        return new RestResponse(coiffeur,"Barber updated successfully", ResponseStatus.SUCCESS,201);
    }
}
