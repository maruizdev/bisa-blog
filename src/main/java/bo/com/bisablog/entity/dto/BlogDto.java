package bo.com.bisablog.entity.dto;

import bo.com.bisablog.entity.enums.Periodicidad;
import lombok.Data;

@Data
public class BlogDto {
    private Long id;
    private String nombreTitulo;
    private String tema;
    private String contenido;
    private Periodicidad periodicidad;
    private Boolean habilitarComentario;
    private AutorDto autor;
}
