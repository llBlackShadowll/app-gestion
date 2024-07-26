package app_gestion.app_gestion.contoller;

import app_gestion.app_gestion.model.AutoModel;
import app_gestion.app_gestion.service.IAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AutoController {
    @Autowired
    private IAutoService autoService;

    @GetMapping({ "/autos", "/" })
    public String listarAutos(Model modelo) {
        modelo.addAttribute("autos", autoService.listarAutos());
        return "viewautos"; //
    }


     @PostMapping("/guardar")
     public ResponseEntity<String> guardarAuto(@RequestBody AutoModel auto) {
         try {

             if (auto.getId() != null && auto.getId() > 0) {
                autoService.actualizarAuto(auto);
             } else {
                 autoService.guardarAuto(auto);
             }
                 return ResponseEntity.ok("{\"success\": true}");

         } catch (Exception e) {
             e.printStackTrace();
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .body("{\"success\": false, \"message\": \"Error al procesar la solicitud\"}");
         }
     }






    @GetMapping("/autos/{id}")
    public String eliminarAuto(@PathVariable Long id) {
        autoService.eliminarAuto(id);
        return "redirect:/autos";
    }
}
