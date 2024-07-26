package app_gestion.app_gestion.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "autos")
public class AutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private int anio;
    private String placa;

    public AutoModel() {

    }
    @Override
    public String toString() {
        return "Estudiante [id=" + id + ", nombre=" + marca + ", apellido=" + modelo + ", email=" + anio + "]";
    }
}
