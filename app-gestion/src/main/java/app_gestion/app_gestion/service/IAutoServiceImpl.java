package app_gestion.app_gestion.service;

import app_gestion.app_gestion.model.AutoModel;
import app_gestion.app_gestion.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IAutoServiceImpl implements IAutoService {
    @Autowired
    private AutoRepository autoRepository;

    @Override
    public List<AutoModel> listarAutos() {
        return autoRepository.findAll();
    }

    @Override
    public AutoModel guardarAuto(AutoModel autoModel) {
        return autoRepository.save(autoModel);
    }


    /*public  AutoModel actualizarAuto(AutoModel autoModel) {
        if (autoRepository.existsById(autoModel.getId())) {
            return autoRepository.save(autoModel);
        } else {
            throw new RuntimeException("Auto no encontrado");
        }
    }*/
    @Override
    public boolean actualizarAuto(AutoModel autoModel) {
        if (autoRepository.existsById(autoModel.getId())) {
            autoRepository.save(autoModel);
            return true; // Indica que el auto fue actualizado
        } else {
            return false; // Indica que el auto no fue encontrado
        }
    }

    @Override
    public void eliminarAuto(Long id) {
        autoRepository.deleteById(id);
    }

    @Override
    public AutoModel obtenerAutoPorId(Long id) {
        return autoRepository.findById(id).orElse(null);
    }
}
