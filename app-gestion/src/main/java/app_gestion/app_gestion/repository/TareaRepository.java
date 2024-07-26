package app_gestion.app_gestion.repository;

import app_gestion.app_gestion.model.AutoModel;
import app_gestion.app_gestion.model.TareaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<TareaModel,Long> {
}
