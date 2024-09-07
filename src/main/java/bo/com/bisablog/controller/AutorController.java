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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.com.bisablog.entity.dto.AutorDto;
import bo.com.bisablog.service.IAutorService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/autor")
public class AutorController {
	 private static final Logger log = LoggerFactory.getLogger(AutorController.class);

	    private IAutorService autorService;
	
	    @GetMapping("/find-all")
	    public ResponseEntity<?> listar(){
	        log.info("====Find All autor=====");
	        Map<String, Object> response = new HashMap<>();
	        try {
	            List<AutorDto> autorDtos = autorService.findAll();
	            response.put("message", "Consulta satisfactoria");
	            response.put("status", true);
	            response.put("data", autorDtos);

	        } catch (DataAccessException e) {
	            response.put("message", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	            response.put("status", false);
	            response.put("data", null);
	            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	    }
	    
	    @GetMapping("/find/{id}")
	    public ResponseEntity<?> buscarAutor(@PathVariable("id") Long id){
	        log.info("====Find Blogs=====");
	        Map<String, Object> response = new HashMap<>();
	        try {
	            AutorDto autorDto = autorService.findById(id);
	            response.put("message", "Consulta satisfactoria");
	            response.put("status", true);
	            response.put("data", autorDto);

	        } catch (DataAccessException e) {
	            response.put("message", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	            response.put("status", false);
	            response.put("data", null);
	            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	    }
}
