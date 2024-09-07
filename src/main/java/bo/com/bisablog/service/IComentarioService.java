package bo.com.bisablog.service;

import java.util.List;

import bo.com.bisablog.entity.dto.ComentarioDto;

public interface IComentarioService {
    public List<ComentarioDto> findAll();
    public ComentarioDto findById(Long id);
    public ComentarioDto save(ComentarioDto comentarioDto, Long blogId);
}
