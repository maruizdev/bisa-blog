package bo.com.bisablog.service.impl;

import bo.com.bisablog.entity.Blog;
import bo.com.bisablog.entity.Comentario;
import bo.com.bisablog.entity.dto.ComentarioDto;
import bo.com.bisablog.respository.BlogDao;
import bo.com.bisablog.respository.ComentarioDao;
import bo.com.bisablog.service.IComentarioService;
import bo.com.bisablog.service.mapper.ComentarioMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ComentarioServiceImpl implements IComentarioService {
    private static final Logger log = LoggerFactory.getLogger(ComentarioServiceImpl.class);
   
    private ComentarioDao comentarioDao;
    private ComentarioMapper comentarioMapper;
    private BlogDao blogDao;

    @Override
    public List<ComentarioDto> findAll() {
        List<Comentario> comentarios = comentarioDao.findAll();
        List<ComentarioDto> comentarioDtos = comentarioMapper.toComentarioDtoList(comentarios);
        return comentarioDtos;
    }

    @Override
    public ComentarioDto findById(Long id) {
        Comentario comentario = comentarioDao.findById(id).get();
        ComentarioDto comentarioDto = comentarioMapper.toGoDto(comentario);
        return comentarioDto;
    }

    @Override
    public ComentarioDto save(ComentarioDto comentarioDto, Long blogId) {
        log.info("crear comentario");
        Blog blog = blogDao.findById(blogId).get();
        Comentario comentario = new Comentario();
        if (blog != null && blog.getHabilitarComentario()) {
        	comentario.setCorreoElectronico(comentarioDto.getCorreoElectronico());
        	comentario.setDescripcion(comentarioDto.getDescripcion());
        	comentario.setNombre(comentarioDto.getNombre());
        	comentario.setPaisResidencia(comentarioDto.getPaisResidencia());
        	comentario.setPuntuacion(comentarioDto.getPuntuacion());
        	comentario.setBlog(blog);
            this.comentarioDao.save(comentario);
        }
        ComentarioDto comentarioDto2 = comentarioMapper.toGoDto(comentario);
        log.info(comentarioDto2.toString());
        return comentarioDto2;
    }

}
