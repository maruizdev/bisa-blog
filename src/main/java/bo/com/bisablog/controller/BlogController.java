package bo.com.bisablog.controller;

import java.text.ParseException;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.com.bisablog.entity.dto.BlogDto;
import bo.com.bisablog.entity.dto.BlogGeneralDto;
import bo.com.bisablog.service.IBlogService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/blog")
public class BlogController {
    private static final Logger log = LoggerFactory.getLogger(BlogController.class);

    private IBlogService blogService;

    @GetMapping("/")
    public ResponseEntity<?> listarBlog(){
        log.info("====Find All Blogs=====");
        Map<String, Object> response = new HashMap<>();
        try {
            List<BlogGeneralDto> blogDtos = this.blogService.findAll();
            response.put("message", "Consulta satisfactoria");
            response.put("status", true);
            response.put("data", blogDtos);

        } catch (DataAccessException e) {
            response.put("message", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            response.put("status", false);
            response.put("data", null);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
    
    
   /* @GetMapping("/find-all")
    public ResponseEntity<?> listar(){
        log.info("====Find All Blogs=====");
        Map<String, Object> response = new HashMap<>();
        try {
            List<BlogDto> blogDtos = this.blogService.findAll();
            response.put("message", "Consulta satisfactoria");
            response.put("status", true);
            response.put("data", blogDtos);

        } catch (DataAccessException e) {
            response.put("message", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            response.put("status", false);
            response.put("data", null);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }*/
    
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarBlog(@PathVariable("id") Long id){
        log.info("====Find Blogs=====");
        Map<String, Object> response = new HashMap<>();
        try {
            BlogGeneralDto blogDtos = this.blogService.findById(id);
            response.put("message", "Consulta satisfactoria");
            response.put("status", true);
            response.put("data", blogDtos);

        } catch (DataAccessException e) {
            response.put("message", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            response.put("status", false);
            response.put("data", null);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
    
    @PostMapping("/save")
    public ResponseEntity<?> guardar(@RequestBody BlogDto blogDto){
        log.info("====Save Blog=====" );
        Map<String, Object> response = new HashMap<>();
        try {
            BlogDto blogDtoResponse = this.blogService.create(blogDto);
            response.put("message", "Consulta satisfactoria");
            response.put("status", true);
            response.put("data", blogDtoResponse);

        } catch (DataAccessException e) {
            response.put("message", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            response.put("status", false);
            response.put("data", null);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (ParseException e) {
            response.put("message", "Error de formato");
            response.put("status", false);
            response.put("data", null);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
    
    @PutMapping("/update/{blogId}")
    public ResponseEntity<?> update(@RequestBody BlogDto blogDto, @PathVariable("blogId") Long blogId){
        log.info("====update Blog=====" );
        Map<String, Object> response = new HashMap<>();
        try {
            BlogDto blogDtoResponse = this.blogService.update(blogDto,blogId);
            response.put("message", "Consulta satisfactoria");
            response.put("status", true);
            response.put("data", blogDtoResponse);

        } catch (DataAccessException e) {
            response.put("message", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            response.put("status", false);
            response.put("data", null);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }


}
