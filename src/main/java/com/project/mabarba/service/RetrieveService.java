package com.project.mabarba.service;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.models.Salon;
import com.project.mabarba.models.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

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
   List<Salon> salonDisplayedList();


   //Display a barba information
   List<Coiffeur> barberDisplayedList();

//------------------------------Page of ellements ----------------------------------
   //Display a salon information
  Map<String, Object> salonDisplayedPage(int pageNo, int pageSize);


   //Display a barba information
  Map<String, Object>  barberDisplayedPage(int pageNo, int pageSize);

  List<User> userDisplayedList();

  User userDisplayed(long id)  throws NoDataFoundException;
}
