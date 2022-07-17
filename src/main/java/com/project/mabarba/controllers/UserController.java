package com.project.mabarba.controllers;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.models.*;
import com.project.mabarba.payload.request.ReservationRequest;
import com.project.mabarba.payload.response.ResponseStatus;
import com.project.mabarba.payload.response.RestResponse;
import com.project.mabarba.service.UserRetrieveService;
import com.project.mabarba.service.UserUpdateService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/user")
@RestController
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
     * @param salonId
     * @return
     * @throws NoDataFoundException
     */
    @GetMapping(path = "/salon-barber/{salonId}", name = "")
    @Operation(summary = "Afficher la liste des coiffeurs d'un salon")
    public RestResponse coiffeursBySalon(@PathVariable Long salonId) throws NoDataFoundException{
        if(salonId<0) return new RestResponse("Fatal Error: this salon id does not exist",ResponseStatus.FAILED,400);
        List<Coiffeur> coiffeurList = userRetrieveService.salonDisplayedCoiffeur(salonId);
        if(coiffeurList.isEmpty()) return new RestResponse("There is no barber in this salon", ResponseStatus.ABORTED,404);
        return new RestResponse(coiffeurList,"Liste des coiffeurs d'un salon", ResponseStatus.SUCCESS,200);
    }

    @GetMapping("/salon-user/{userId}")
    @Operation(summary = "Afficher la liste des salons d'un quartier dans la ville d'un utilisateur")
    public RestResponse salonDisplayByUser(@PathVariable Long userId) throws NoDataFoundException{
        if(userId<0)return new RestResponse("Fatal Error: this user id does not exist", ResponseStatus.FAILED,400);
        List<Salon>salonList = userRetrieveService.salonDisplayedByUser(userId);
        if(salonList.isEmpty()) return new RestResponse("There is no salon found", ResponseStatus.ABORTED,404);
        return new RestResponse(salonList,"Liste des salons trouvés",ResponseStatus.SUCCESS,200);
    }
    @GetMapping("/salon-search/{name}")
    @Operation(summary = "Rechercher les salons à partir d'un nom")
    public RestResponse searchSalonsByName(@PathVariable String name){
        List<Salon>salonList = userRetrieveService.displaySalonsByName(name);
        return new RestResponse(salonList,"Liste des salon correspondant au name", ResponseStatus.SUCCESS,200);
    }
    @GetMapping("/coiffeur-search/{name}")
    @Operation(summary = "Rechercher les coiffeurs à partir d'un nom")
    public RestResponse searchCoiffeursByName(@PathVariable String name){
        List<Coiffeur>coiffeurList = userRetrieveService.displayCoiffeursByName(name);
        return new RestResponse(coiffeurList,"Liste des coiffeurs correspondant au name", ResponseStatus.SUCCESS,200);
    }
    /**
     * @param ville
     * @param quartier
     * @return
     * @throws NoDataFoundException
     */
    @GetMapping("/salon-user")
    @Operation(summary = "Afficher la liste des salons d'un quartier dans une ville donnée")
    public RestResponse salonDisplayByUser(@RequestParam String ville, @RequestParam String quartier) throws NoDataFoundException{
        List<Salon>salonList = userRetrieveService.salonDisplayedByUserAdvanced(ville, quartier);
        if(salonList.isEmpty()) return new RestResponse("There is no salon found", ResponseStatus.ABORTED,404);
        return new RestResponse(salonList,"Liste des salons trouvés",ResponseStatus.SUCCESS,200);
    }

    //Liste des coiffures d'un salon de coiffuere
    /**
     * @param salonId
     * @return
     * @throws NoDataFoundException
     */
    @GetMapping(path = "/salon-coiffure/{salonId}")
    @ApiOperation("Liste des coiffures enregistrées dans un salon")
    public RestResponse coiffuresBySalon(@PathVariable Long salonId) throws NoDataFoundException{
        if(salonId<0) return new RestResponse("Fatal Error: this salon id does not exist",ResponseStatus.FAILED,400);
        List<Coiffure> coiffureList = userRetrieveService.salonDisplayedCoiffure(salonId);
        if(coiffureList.isEmpty()) return new RestResponse("There is no coiffure in this salon", ResponseStatus.ABORTED,404);
        return new RestResponse(coiffureList,"Liste des coiffures d'un salon", ResponseStatus.SUCCESS,200);
    }
    @GetMapping(path = "/coiffure/{id}")
    @ApiOperation("Afficher une coiffure")
    public RestResponse coiffureDisplayed(@PathVariable Long coiffureId) throws NoDataFoundException{
        if(coiffureId<0) return new RestResponse("Fatal Error: this coiffure id does not exist", ResponseStatus.FAILED,400);
        Coiffure coiffure = userRetrieveService.coiffureDisplayed(coiffureId);
        return new RestResponse(coiffure,"Displayed coiffure",ResponseStatus.SUCCESS,200);
    }
    @GetMapping("/coiffure-search/{name}")
    @Operation(summary = "Rechercher les coiffures à partir d'un nom")
    public RestResponse searchCoiffuresByName(@PathVariable String name){
        List<Coiffure>coiffureList = userRetrieveService.displayCoiffuresByName(name);
        return new RestResponse(coiffureList,"Liste des coiffures correspondant au name", ResponseStatus.SUCCESS,200);
    }
    /******************* endpoints de carnet ****************************/
    @GetMapping("/carnet-coiffeur/{coiffeurId}")
    @ApiOperation("Afficher le carnet d'un coiffeur")
    public RestResponse carnetByCoiffeur(@PathVariable Long coiffeurId) throws NoDataFoundException{
        if (coiffeurId<0) return new RestResponse("Fatal Error: this coiffeur id does not exist", ResponseStatus.FAILED,400);
        Carnet carnet = userRetrieveService.carnetByCoiffeur(coiffeurId);
        return new RestResponse(carnet,"Le carnet d'un coiffeur", ResponseStatus.SUCCESS,200);
    }
    @GetMapping("/carnet/{id}")
    @ApiOperation("Afficher un carnet")
    public RestResponse carnetDisplayed(@PathVariable Long carnetId) throws NoDataFoundException{
        if(carnetId<0) return new RestResponse("Fatal Error:this carnet id does not exisit",ResponseStatus.FAILED,400);
        Carnet carnet = userRetrieveService.carnetDisplayed(carnetId);
        return new RestResponse(carnet,"Displayed carnet successfully",ResponseStatus.SUCCESS,200);
    }

    /************************* endpoints des plages horaires *************************/
    @GetMapping("/plagehoraire-carnet/{carnetId}")
    @ApiOperation("Afficher les plages horaires d'un carnet")
    public RestResponse plageHorairesByCarnet(@PathVariable long carnetId) throws NoDataFoundException {
        if(carnetId<0) return new RestResponse("Fatal error: carnet id doest not exist",ResponseStatus.FAILED,400);
        List<PlageHoraire> plageHoraireList = userRetrieveService.plageHorairesByCarnet(carnetId);
        if(plageHoraireList.isEmpty()) return new RestResponse("Aucune plage horaire pour ce carnet",ResponseStatus.ABORTED,404);
        return new RestResponse(plageHoraireList,"Liste des plages horaires du carnet",ResponseStatus.SUCCESS,200);
    }

    @GetMapping("/plagehoraire/{plageHoraireId}")
    @ApiOperation("Afficher une plage horaire")
    public RestResponse plageHoraireDisplayed(@PathVariable long plageHoraireId) throws NoDataFoundException{
        if(plageHoraireId<0) return new RestResponse("Fatal error: plage horaire id does not exist", ResponseStatus.FAILED,400);
        PlageHoraire plageHoraire = userRetrieveService.plageHoraireDisplayed(plageHoraireId);
        return new RestResponse(plageHoraire,"Plage horaire displayed", ResponseStatus.SUCCESS,200);
    }

    //Liste des plages horaires d'un coiffeur pour une journee
    @GetMapping(path = "/plagehoraire-coiffeur-jour")
    @ApiOperation("Les plages Horaires d'une journee pour un coiffeur")
    public RestResponse plageHoraireCoiffeurJour(@RequestParam(name = "coiffeurId") Long coiffeurId, @RequestParam(name = "jour") String jour) throws ParseException, NoDataFoundException{
        if(coiffeurId<0) return new RestResponse("Fatal Error: this coiffeur id does not exist", ResponseStatus.FAILED,400);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parsedDate = dateFormat.parse(jour);
        Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
        List<PlageHoraire> plageHoraireList = userRetrieveService.plageHoraireByCoiffeurByJour(coiffeurId,timestamp);
        if(plageHoraireList.isEmpty())
            return new RestResponse("Aucune plage horaire pour cette journee",ResponseStatus.ABORTED,404);
        return new RestResponse(plageHoraireList,"Liste des plage horaire pour un coiffeur pour une journee", ResponseStatus.SUCCESS,200);
    }

    /*======================================================================*/
    /*                             LES RESERVATIONS                        */
    /*====================================================================*/
    @PostMapping("/reservation")
    @Operation(summary = "Réserver une plage horaire", description = "Réservation d'une plage horaire à partir de l'id de la plage et l'id de l'utilisateur")
    public RestResponse plageHoraireReservation(@RequestBody ReservationRequest reservationRequest) throws NoDataFoundException,Exception {
        Reservation reservation = userUpdateService.userCreateReservation(reservationRequest);
        return new RestResponse(reservation,"Create reservation successfully",ResponseStatus.SUCCESS,200);
    }
}
