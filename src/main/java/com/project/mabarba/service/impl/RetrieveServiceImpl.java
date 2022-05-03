package com.project.mabarba.service.impl;

import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.models.Salon;
import com.project.mabarba.service.RetrieveService;
import org.springframework.data.domain.Page;

import java.util.List;

public class RetrieveServiceImpl  implements RetrieveService {
    @Override
    public Salon salonDisplayed(long salonId) {
        return null;
    }

    @Override
    public boolean salonDeleted(long salonId) {
        return false;
    }

    @Override
    public Coiffeur barberDisplayed(long coiffeurId) {
        return null;
    }

    @Override
    public boolean barberDeleted(long coiffeurId) {
        return false;
    }

    @Override
    public List<Salon> salonDisplayedList(long salonId) {
        return null;
    }

    @Override
    public List<Coiffeur> barberDisplayedList(long coiffeurId) {
        return null;
    }

    @Override
    public List<Page> salonDisplayedPage(long salonId) {
        return null;
    }

    @Override
    public List<Page> barberDisplayedPage(long coiffeurId) {
        return null;
    }
}
