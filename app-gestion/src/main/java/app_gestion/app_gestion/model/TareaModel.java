package app_gestion.app_gestion.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "tareas_mantenimiento")
public class TareaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "auto_id", nullable = false)
    private AutoModel auto;

    @ManyToOne
    @JoinColumn(name = "tipo_mantenimiento_id", nullable = false)
    private TipoMantenimientoModel tipoMantenimiento;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuario;

    @Column(name = "descripcion_tarea", columnDefinition = "TEXT")
    private String descripcionTarea;

    @Column(name = "estado", length = 50)
    private String estado;

    public TareaModel() {

    }
}
