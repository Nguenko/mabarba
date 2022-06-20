package com.project.mabarba.controllers;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.models.Coiffure;
import com.project.mabarba.models.PlageHoraire;
import com.project.mabarba.models.Salon;
import com.project.mabarba.payload.response.ResponseStatus;
import com.project.mabarba.payload.response.RestResponse;
import com.project.mabarba.service.UserRetrieveService;
import com.project.mabarba.service.UserUpdateService;
import io.swagger.annotations.ApiOperation;
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRetrieveService userRetrieveService;
    @Autowired
    UserUpdateService userUpdateService;

    @GetMapping(path = "/salon/{id}", name = "read")
    @ApiOperation("Affichage d'un Salon de coiffure")
    public RestResponse salonDisplayed(@PathVariable long id) throws NoDataFoundException {
        if (id > 0) {
            Salon salon = userRetrieveService.salonDisplayed(id);
            if (salon != null) {
                return new RestResponse(salon, "Salon sucessfully displayed!", ResponseStatus.SUCCESS, 200);
            } else {
                return new RestResponse("this salon does not exist", ResponseStatus.ABORTED, 404);
            }
        } else {
            return new RestResponse("Fatal error : this Id does not existe", ResponseStatus.FAILED, 400);
        }
    }

    @GetMapping(path = "/salons-by-page", name = "list")
    @ApiOperation("Affichage de la liste de tous les Salons avec pagination")
    public RestResponse salonDisplayedPage(@RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
                                           @RequestParam(name = "pageSize", defaultValue = "2") int pageSize) {
        if (pageNo >= 0 && pageSize >= 0) {
            Map<String, Object> salon = userRetrieveService.salonDisplayedPage(pageNo, pageSize);
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
    /**
     *
     * @param salonId
     * @return
     * @throws NoDataFoundException
     */
    @GetMapping(path = "/salon-barber/{salonId}", name = "")
    @ApiOperation("Afficher la liste des coiffeurs d'un salon")
    public RestResponse salonDisplayedCoiffeur(@PathVariable Long salonId) throws NoDataFoundException{
        if(salonId<0) return new RestResponse("Fatal Error: this salon id does not exist",ResponseStatus.FAILED,400);
        List<Coiffeur> coiffeurList = userRetrieveService.salonDisplayedCoiffeur(salonId);
        if(coiffeurList.isEmpty()) return new RestResponse("There is no barber in this salon", ResponseStatus.ABORTED,404);
        return new RestResponse(coiffeurList,"Liste des coiffeurs d'un salon", ResponseStatus.SUCCESS,200);
    }
    //Liste des coiffures d'un salon de coiffuere
    /**
     *
     * @param salonId
     * @return
     * @throws NoDataFoundException
     */
    @GetMapping(path = "/salon-coiffure/{salonId}")
    @ApiOperation("Liste des coiffures enregistrées dans un salon")
    public RestResponse salonDisplayedCoiffure(@PathVariable Long salonId) throws NoDataFoundException{
        if(salonId<0) return new RestResponse("Fatal Error: this salon id does not exist",ResponseStatus.FAILED,400);
        List<Coiffure> coiffureList = userRetrieveService.salonDisplayedCoiffure(salonId);
        if(coiffureList.isEmpty()) return new RestResponse("There is no coiffure in this salon", ResponseStatus.ABORTED,404);
        return new RestResponse(coiffureList,"Liste des coiffures d'un salon", ResponseStatus.SUCCESS,200);
    }
    //Liste des plages horaires d'un coiffeur pour une journee
    @GetMapping(path = "/plagehoraire-coiffeur-jour")
    @ApiOperation("Les plages Horaires d'une journee pour un coiffeur")
    public RestResponse plageHoraireCoiffeurJour(@RequestParam(name = "coiffeurId") Long coiffeurId, @RequestParam(name = "jour") String jour) throws Exception{
        if(coiffeurId<0) return new RestResponse("Fatal Error: this coiffeur id does not exist", ResponseStatus.FAILED,400);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parsedDate = dateFormat.parse(jour);
        Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
        List<PlageHoraire> plageHoraireList = userRetrieveService.plageHoraireByCoiffeurByJour(coiffeurId,timestamp);
        if(plageHoraireList.isEmpty())
            return new RestResponse("Aucune plage horaire pour cette journee",ResponseStatus.ABORTED,404);
        return new RestResponse(plageHoraireList,"Liste des plage horaire pour un coiffeur pour une journee", ResponseStatus.SUCCESS,200);
    }
}
