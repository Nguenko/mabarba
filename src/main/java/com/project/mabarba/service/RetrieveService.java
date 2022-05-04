package com.project.mabarba.service;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.models.Salon;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RetrieveService {
   //Display a salon information
   Salon salonDisplayed(long salonId) throws NoDataFoundException;

   //Delete a salon information
   boolean salonDeleted(long salonId) throws NoDataFoundException;

   //Display a barba information
   Coiffeur barberDisplayed(long coiffeurId) throws NoDataFoundException;

   //Delete a barber information
   boolean barberDeleted(long coiffeurId) throws NoDataFoundException;

//------------------------------List of ellements ----------------------------------
   //Display a salon information
   List<Salon> salonDisplayedList(long salonId);


   //Display a barba information
   List<Coiffeur> barberDisplayedList(long coiffeurId);

//------------------------------Page of ellements ----------------------------------
   //Display a salon information
   Page<Salon>  salonDisplayedPage(long salonId);


   //Display a barba information
   Page<Salon>  barberDisplayedPage(long coiffeurId);


}
