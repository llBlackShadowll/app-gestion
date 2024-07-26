package app_gestion.app_gestion.service;

import app_gestion.app_gestion.model.TareaModel;
import app_gestion.app_gestion.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TareaService implements ITareaService {
    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public List<TareaModel> listarTareas() {
        return tareaRepository.findAll();    }
}
