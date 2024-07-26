package app_gestion.app_gestion.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "historial_mantenimiento")

public class HistorialMatenimientoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "tarea_mantenimiento_id", nullable = false)
    private TareaModel tareaMantenimiento;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioModel usuario;

    @Column(name = "fecha_realizacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaRealizacion;

    @Column(name = "notas", columnDefinition = "TEXT")
    private String notas;



}


