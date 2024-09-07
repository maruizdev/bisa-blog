package bo.com.bisablog.respository;

import bo.com.bisablog.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioDao extends JpaRepository<Comentario, Long> {
}
