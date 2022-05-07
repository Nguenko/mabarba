package com.project.mabarba.controllers;


import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.models.Salon;
import com.project.mabarba.payload.response.ResponseStatus;
import com.project.mabarba.payload.response.RestResponse;
import com.project.mabarba.service.RetrieveService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
public class RetrieveController {

    @Autowired
    RetrieveService retrieveService;

    @GetMapping("/test")
    @ApiOperation("Test Unitaire et d'integration init")
    public String hello (String name){
        return String.format("hello, %s", name);
    }

    @GetMapping("/helloTest")
    @ApiOperation("Test Unitaire et d'integration init")
    public String helloTest (@RequestParam(name="name", defaultValue = "world") String name){
        return String.format("hello, %s", name);
    }

    @GetMapping("/salonDisplayed/{id}")
    @ApiOperation("Affichage d'un Salon de coiffure")
    public RestResponse salonDisplayed (@PathVariable long id) throws NoDataFoundException {

        if(id>0){
            Salon salon = retrieveService.salonDisplayed(id);
            if (salon!=null){

                return new RestResponse(salon,"Salon sucessfully displayed!", ResponseStatus.SUCCESS, 200);
            }
            else{
                return new RestResponse("this salon does not exist", ResponseStatus.ABORTED, 404);
            }
        }
        else{
               return new RestResponse("Fatal error : this Id does not existe", ResponseStatus.FAILED, 400);
        }
    }



    @GetMapping("/barberDisplayed/{id}")
    @ApiOperation("Affichage d'un Coiffeur")
    public RestResponse barberDisplayed (@PathVariable long id) throws NoDataFoundException {

        if(id>0){
            Coiffeur coiffeur = retrieveService.barberDisplayed(id);
            if (coiffeur!=null){

                return new RestResponse(coiffeur,"Barber successfully displayed!", ResponseStatus.SUCCESS, 200);
            }
            else{
                return new RestResponse("this Barber does not exist", ResponseStatus.ABORTED, 404);
            }
        }
        else{
            return new RestResponse("Fatal error : this Id does not existe", ResponseStatus.FAILED, 400);
        }
    }

    @GetMapping("/salonDisplayedList/{id}")
    @ApiOperation("Affichage de la liste de tous les Salons de coiffure sans pagination")
    public RestResponse salonDisplayedList () throws NoDataFoundException {


            List<Salon> salonList = retrieveService.salonDisplayedList();
            if (!salonList.isEmpty()){

                return new RestResponse(salonList,"Salon List displayed!", ResponseStatus.SUCCESS, 200);
            }
            else{
                return new RestResponse("No salon at the moment !", ResponseStatus.ABORTED, 404);
            }


    }

    @GetMapping("/barberDisplayedList")
    @ApiOperation("Affichage de la liste de tous les Coiffeurs sans pagination")
    public RestResponse barberDisplayedList () {


        List<Coiffeur> coiffeur = retrieveService.barberDisplayedList();
        if (coiffeur!=null){

            return new RestResponse(coiffeur,"Barber List displayed!", ResponseStatus.SUCCESS, 200);
        }
        else{
            return new RestResponse("Barbers empty", ResponseStatus.ABORTED, 404);
        }


    }

    @GetMapping("/barberDisplayedPage")
    @ApiOperation("Affichage de la liste de tous les coiffeurs avec pagination")
    public RestResponse barberDisplayedPage (@RequestParam(name="pageNo", defaultValue = "0") int pageNo,
                                             @RequestParam(name="pageSize", defaultValue = "2") int pageSize)  {

        if(pageNo>=0 && pageSize>=0){
            Map<String, Object> coiffeur = retrieveService.barberDisplayedPage(pageNo, pageSize);
            if (coiffeur!=null){

                return new RestResponse(coiffeur,"Barbers with pagination displayed!", ResponseStatus.SUCCESS, 200);
            }
            else{
                return new RestResponse("this Barber does not exist", ResponseStatus.ABORTED, 404);
            }
        }
        else{
            return new RestResponse("Fatal error : pagesize and page number must be positif", ResponseStatus.FAILED, 400);
        }
    }

    @GetMapping("/salonDisplayedPage")
    @ApiOperation("Affichage de la liste de tous les Salons avec pagination")
    public RestResponse salonDisplayedPage (@RequestParam(name="pageNo", defaultValue = "0") int pageNo,
                                            @RequestParam(name="pageSize", defaultValue = "2") int pageSize)  {

        if(pageNo>=0 && pageSize>=0){
            Map<String, Object> salon = retrieveService.salonDisplayedPage(pageNo, pageSize);
            if (salon!=null){

                return new RestResponse(salon,"Salons with pagination displayed!", ResponseStatus.SUCCESS, 200);
            }
            else{
                return new RestResponse("this salon does not exist", ResponseStatus.ABORTED, 404);
            }
        }
        else{
            return new RestResponse("Fatal error : pagesize and page number must be positif", ResponseStatus.FAILED, 400);
        }
    }


}
