package app_gestion.app_gestion.contoller;

import app_gestion.app_gestion.model.TareaModel;
import app_gestion.app_gestion.service.ITareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tareas")
public class TareaController {
    @Autowired
    private ITareaService tareaService;

    @GetMapping
    public String listarTareas(Model modelo) {
        List<TareaModel> tareas = tareaService.listarTareas();
        modelo.addAttribute("tareas", tareas);
        return "viewtareas"; //
    }
}
