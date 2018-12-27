package ru.itis.services;

import ru.itis.forms.auditoriumForm;
import ru.itis.models.Auditorium;

import java.util.List;

public interface AuditoriumService {
    public Auditorium getAudById(Long id);
    public void deleteAuditorium(Long id);
    public void editAuditorium(Auditorium auditorium);
    public void addAuditorium(auditoriumForm auditoriumForm);
    public List<Auditorium> getAllAud();
}
