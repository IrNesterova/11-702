package ru.itis.services;

import ru.itis.forms.screeningForm;
import ru.itis.models.Screening;
import ru.itis.repositories.ScreeningRepository;

import java.util.List;

public class ScreeningServiceImpl implements ScreeningService {
    private ScreeningRepository screeningRepository;

    public ScreeningServiceImpl(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;

    }

    @Override
    public void editScreening(Screening screening) {
        screeningRepository.update(screening);
    }

    @Override
    public void addScreening(screeningForm screeningForm) {
        Screening screening = Screening.builder()
                .id_screening(screeningForm.getId_screening())
                .id_movie(screeningForm.getId_movie().toString())
                .auditorium_id(screeningForm.getAuditorium_id().toString())
                .screening_start(screeningForm.getScreening_start())
                .build();
        screeningRepository.save(screening);
    }

    @Override
    public void deleteScreening(Long id) {
        screeningRepository.delete(id);
    }

    @Override
    public List<Screening> getScreening() {
        return screeningRepository.findAll();
    }

    @Override
    public Screening getScreeningById(Long ScreeningId) {
       return screeningRepository.findOne(ScreeningId);
    }
}



