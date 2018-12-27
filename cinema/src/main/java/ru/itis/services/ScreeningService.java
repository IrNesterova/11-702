package ru.itis.services;

import ru.itis.forms.screeningForm;
import ru.itis.models.Movie;
import ru.itis.models.Screening;

import java.util.List;

public interface ScreeningService {
    void editScreening(Screening screening);
    void addScreening(screeningForm screeningForm);
    void deleteScreening(Long id);
    public List<Screening> getScreening();
    public Screening getScreeningById(Long ScreeningId);
}
