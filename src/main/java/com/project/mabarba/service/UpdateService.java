package com.project.mabarba.service;

import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.models.Salon;
import com.project.mabarba.payload.request.CoiffeurRequest;
import com.project.mabarba.payload.request.SalonRequest;

public interface UpdateService {

    //Create a salon
    Salon salonCreation(SalonRequest salonRequest);

    //update a salon
    Salon salonModification(SalonRequest salonRequest);

    //create a barber
    Coiffeur barberCreation(CoiffeurRequest coiffeurRequest);

    //update a barberbg
    Coiffeur barberModification(CoiffeurRequest coiffeurRequest);

}
