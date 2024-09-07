package bo.com.bisablog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.com.bisablog.entity.dto.ComentarioDto;
import bo.com.bisablog.service.IComentarioService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/comentario")
public class ComentarioController {

	private static final Logger log = LoggerFactory.getLogger(BlogController.class);

	private IComentarioService comentarioService;

	@GetMapping("/find-all")
	public ResponseEntity<?> listar() {
		log.info("====Find All Comentario=====");
		Map<String, Object> response = new HashMap<>();
		try {
			List<ComentarioDto> comentarioDtos = this.comentarioService.findAll();
			response.put("message", "Consulta satisfactoria");
			response.put("status", true);
			response.put("data", comentarioDtos);

		} catch (DataAccessException e) {
			response.put("message", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("status", false);
			response.put("data", null);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> buscarComentario(@PathVariable("id") Long id) {
		log.info("====Find comentario=====");
		Map<String, Object> response = new HashMap<>();
		try {
			ComentarioDto comentarioDto = this.comentarioService.findById(id);
			response.put("message", "Consulta satisfactoria");
			response.put("status", true);
			response.put("data", comentarioDto);

		} catch (DataAccessException e) {
			response.put("message", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("status", false);
			response.put("data", null);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PostMapping("/save/{blogId}")
	public ResponseEntity<?> guardar(@RequestBody ComentarioDto comentarioDto, @PathVariable("blogId") Long blogId) {
		log.info("====guardar Comentario=====");
		Map<String, Object> response = new HashMap<>();
		try {
			ComentarioDto comentarioDto2 = this.comentarioService.save(comentarioDto, blogId);
			if (comentarioDto2.getId() != null) {
				response.put("message", "Consulta satisfactoria");
				response.put("status", true);
				response.put("data", comentarioDto2);
			} else {
				response.put("message", "No se puede registrar el comentario, blog no permite comentarios");
				response.put("status", true);
				response.put("data", null);
			}

		} catch (DataAccessException e) {
			response.put("message", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("status", false);
			response.put("data", null);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
