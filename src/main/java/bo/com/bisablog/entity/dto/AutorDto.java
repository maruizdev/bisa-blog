package bo.com.bisablog.entity.dto;

import java.util.Date;

import lombok.Data;

@Data
public class AutorDto {
	 private Long id;
	    private String nombres;
	    private String apellidoPaterno;
	    private String apellidoMaterno;
	    private String fechaNacimiento;
	    private String correoElectronico;
	    private String paisResidencia;
}
