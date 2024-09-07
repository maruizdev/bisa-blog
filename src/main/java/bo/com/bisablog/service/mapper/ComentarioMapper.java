package bo.com.bisablog.service.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import bo.com.bisablog.entity.Comentario;
import bo.com.bisablog.entity.dto.ComentarioDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ComentarioMapper {
	  ComentarioDto toGoDto(Comentario comentario);

	    @InheritInverseConfiguration
	    Comentario toEntity(ComentarioDto comentarioDto);

	    List<ComentarioDto> toComentarioDtoList(List<Comentario> comentarios);

	    List<Comentario> toComentarioList(List<ComentarioDto> comentarioDtos);
}
