package app_gestion.app_gestion.service;

import app_gestion.app_gestion.model.AutoModel;

import java.util.List;

public interface IAutoService {
    public List<AutoModel> listarAutos();

    public AutoModel guardarAuto(AutoModel autoModel);

    /*public AutoModel actualizarAuto(AutoModel autoModel);*/
    boolean actualizarAuto(AutoModel autoModel);


    public void eliminarAuto(Long id);
    AutoModel obtenerAutoPorId(Long id);
}
