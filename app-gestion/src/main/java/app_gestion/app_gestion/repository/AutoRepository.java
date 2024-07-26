package app_gestion.app_gestion.repository;

import app_gestion.app_gestion.model.AutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoRepository extends JpaRepository<AutoModel,Long> {
}
