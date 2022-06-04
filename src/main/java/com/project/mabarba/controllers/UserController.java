package com.project.mabarba.controllers;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.models.Salon;
import com.project.mabarba.payload.response.ResponseStatus;
import com.project.mabarba.payload.response.RestResponse;
import com.project.mabarba.service.UserRetrieveService;
import com.project.mabarba.service.UserUpdateService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
}
