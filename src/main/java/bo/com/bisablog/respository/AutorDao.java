package bo.com.bisablog.respository;

import bo.com.bisablog.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorDao extends JpaRepository<Autor,Long> {
}
