package bo.com.bisablog.config;

import org.springframework.http.HttpStatus;

public class AppException {
	private static final long serialVersionUID = 1L;

	private HttpStatus estado;
	private String mensaje;

	public AppException() {

	}

	public AppException(HttpStatus estado, String mensaje) {
		super();
		this.estado = estado;
		this.mensaje = mensaje;
	}

	public HttpStatus getEstado() {
		return estado;
	}

	public void setEstado(HttpStatus estado) {
		this.estado = estado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
