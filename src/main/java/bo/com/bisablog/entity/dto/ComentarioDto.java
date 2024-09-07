package bo.com.bisablog.entity.dto;

import lombok.Data;

@Data
public class ComentarioDto {
	private Long id;
	private String descripcion;
	private String nombre;
	private String correoElectronico;
	private String paisResidencia;
	private Integer puntuacion;
}
