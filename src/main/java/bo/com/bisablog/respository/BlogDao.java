package bo.com.bisablog.respository;

import bo.com.bisablog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogDao extends JpaRepository<Blog, Long> {
}
