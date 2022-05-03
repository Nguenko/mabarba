package com.project.mabarba.service;

import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.models.Salon;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RetrieveService {
   //Display a salon information
   Salon salonDisplayed(long salonId);

   //Delete a salon information
   boolean salonDeleted(long salonId);

   //Display a barba information
   Coiffeur barberDisplayed(long coiffeurId);

   //Delete a barber information
   boolean barberDeleted(long coiffeurId);

//------------------------------List of ellements ----------------------------------
   //Display a salon information
   List<Salon> salonDisplayedList(long salonId);


   //Display a barba information
   List<Coiffeur> barberDisplayedList(long coiffeurId);

//------------------------------Page of ellements ----------------------------------
   //Display a salon information
   List<Page> salonDisplayedPage(long salonId);


   //Display a barba information
   List<Page> barberDisplayedPage(long coiffeurId);


}
