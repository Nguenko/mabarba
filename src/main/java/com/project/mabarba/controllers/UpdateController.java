package com.project.mabarba.controllers;

import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.models.Salon;
import com.project.mabarba.payload.request.CoiffeurRequest;
import com.project.mabarba.payload.request.SalonRequest;
import com.project.mabarba.payload.response.ResponseStatus;
import com.project.mabarba.payload.response.RestResponse;
import com.project.mabarba.service.UpdateService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
public class UpdateController {

    @Autowired
    UpdateService updateService;

    @PostMapping("/salonCreated")
    @Operation(summary="Creation d'un salon de coiffure")
    public RestResponse salonCreated (@Valid @RequestBody SalonRequest salonRequest)  {

        if(salonRequest!=null){
            Salon salon = updateService.salonCreation(salonRequest);
            if (salon!=null){

                return new RestResponse(salon,"Salon successfully created!", ResponseStatus.SUCCESS, 200);
            }
            else{
                return new RestResponse("this Salon does not exist", ResponseStatus.ABORTED, 404);
            }
        }
        else{
            return new RestResponse("Fatal error : can't create empty salon", ResponseStatus.FAILED, 400);
        }
    }

    @PostMapping("/salonUpdated")
    @Operation(summary="Mise à jour d'un salon de coiffure")
    public RestResponse salonUpdated (@Valid @RequestBody SalonRequest salonRequest)  {

        if(salonRequest!=null){
            Salon salon = updateService.salonModification(salonRequest);
            if (salon!=null){

                return new RestResponse(salon,"Salon successfully created!", ResponseStatus.SUCCESS, 200);
            }
            else{
                return new RestResponse("this Salon does not exist", ResponseStatus.ABORTED, 404);
            }
        }
        else{
            return new RestResponse("Fatal error : can't create empty salon", ResponseStatus.FAILED, 400);
        }
    }

    @PostMapping("/barberCreated")
    @Operation(summary="Creation d'un coiffeur du salon")
    public RestResponse barberCreated (@Valid @RequestBody CoiffeurRequest coiffeurRequest)  {

        if(coiffeurRequest!=null){
            Coiffeur coiffeur = updateService.barberCreation(coiffeurRequest);
            if (coiffeur!=null){

                return new RestResponse(coiffeur,"Barber successfully created!", ResponseStatus.SUCCESS, 200);
            }
            else{
                return new RestResponse("this Barber does not exist", ResponseStatus.ABORTED, 404);
            }
        }
        else{
            return new RestResponse("Fatal error : can't create empty barber", ResponseStatus.FAILED, 400);
        }
    }

    @PostMapping("/barberUpdated")
    @Operation(summary="Mise à jour des informations d'un coiffeur du salon")
    public RestResponse barberUpdated (@Valid @RequestBody CoiffeurRequest coiffeurRequest)  {

        if(coiffeurRequest!=null){
            Coiffeur coiffeur = updateService.barberModification(coiffeurRequest);
            if (coiffeur!=null){

                return new RestResponse(coiffeur,"Barber successfully updated!", ResponseStatus.SUCCESS, 200);
            }
            else{
                return new RestResponse("this Barber does not exist", ResponseStatus.ABORTED, 404);
            }
        }
        else{
            return new RestResponse("Fatal error : can't create empty barber", ResponseStatus.FAILED, 400);
        }
    }

}
