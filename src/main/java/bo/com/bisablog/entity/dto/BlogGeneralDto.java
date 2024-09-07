package bo.com.bisablog.entity.dto;

import java.util.List;

import lombok.Data;


@Data
public class BlogGeneralDto {
	private BlogDto blog;
	private List<AutorDto> autores;
	private List<ComentarioDto> comentarios;
}
