package ru.itis.services;

import ru.itis.forms.auditoriumForm;
import ru.itis.models.Auditorium;
import ru.itis.repositories.AuditoriumRepository;

import java.util.List;

public class AuditoriumServiceImpl implements AuditoriumService {
    public AuditoriumRepository auditoriumRepository;
    public AuditoriumServiceImpl(AuditoriumRepository auditoriumRepository){
        this.auditoriumRepository = auditoriumRepository;
    }

    @Override
    public Auditorium getAudById(Long id) {
        return auditoriumRepository.findOne(id);
    }

    @Override
    public void deleteAuditorium(Long id) {
        auditoriumRepository.delete(id);
    }

    @Override
    public void editAuditorium(Auditorium auditorium) {
        auditoriumRepository.update(auditorium);
    }

    @Override
    public void addAuditorium(auditoriumForm auditoriumForm) {
        Auditorium auditorium = Auditorium.builder()
                .id(auditoriumForm.getId())
                .name(auditoriumForm.getName())
                .seats_id(auditoriumForm.getNumberOfSeats())
                .build();
        auditoriumRepository.save(auditorium);
    }

    @Override
    public List<Auditorium> getAllAud() {
        return auditoriumRepository.findAll();
    }
}
