package bo.com.bisablog.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import bo.com.bisablog.entity.Autor;
import bo.com.bisablog.entity.Blog;
import bo.com.bisablog.entity.Comentario;
import bo.com.bisablog.entity.dto.AutorDto;
import bo.com.bisablog.entity.dto.BlogDto;
import bo.com.bisablog.entity.dto.BlogGeneralDto;
import bo.com.bisablog.entity.dto.ComentarioDto;
import bo.com.bisablog.respository.BlogDao;
import bo.com.bisablog.service.IBlogService;
import bo.com.bisablog.service.mapper.AutorMapper;
import bo.com.bisablog.service.mapper.BlogMapper;
import bo.com.bisablog.service.mapper.ComentarioMapper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BlogServiceImpl implements IBlogService {
    private static final Logger log = LoggerFactory.getLogger(BlogServiceImpl.class);
    
    private BlogDao blogDao;
    private BlogMapper blogMapper;
    private AutorMapper autorMapper;
    private ComentarioMapper comentarioMapper;
    
    @Override
    public List<BlogGeneralDto> findAll() {
    	log.info("service");
        List<Blog> blogs = blogDao.findAll();
       List<BlogGeneralDto>blogGeneralDtos = new ArrayList<BlogGeneralDto>();
       for(Blog it: blogs) {
    	Blog blog = it;
    	List<Autor> autores = it.getAutores();
    	List<Comentario> comentarios =  it.getComentarios();
    	BlogGeneralDto blogGeneralDto = new BlogGeneralDto();
    	BlogDto blogDto = blogMapper.toGoDto(blog);
    	blogGeneralDto.setBlog(blogDto);
    	List<AutorDto> autorDtos = autorMapper.toAutorDtoList(autores);
    	blogGeneralDto.setAutores(autorDtos);
    	List<ComentarioDto> comentarioDtos = comentarioMapper.toComentarioDtoList(comentarios);
    	blogGeneralDto.setComentarios(comentarioDtos);
    	blogGeneralDtos.add(blogGeneralDto);
       }
       
        return blogGeneralDtos;
    }

    @Override
    public BlogGeneralDto findById(Long id) {
        Blog blog = blogDao.findById(id).get();
        BlogGeneralDto blogGeneralDto = new BlogGeneralDto();
    	
        BlogDto blogDto = blogMapper.toGoDto(blog);
    	blogGeneralDto.setBlog(blogDto);
    	
        List<Autor> autores = blog.getAutores();
    	List<Comentario> comentarios =  blog.getComentarios();
    	
    	List<AutorDto> autorDtos = autorMapper.toAutorDtoList(autores);
    	blogGeneralDto.setAutores(autorDtos);
    	List<ComentarioDto> comentarioDtos = comentarioMapper.toComentarioDtoList(comentarios);
    	blogGeneralDto.setComentarios(comentarioDtos);
        return blogGeneralDto;
    }

    @Override
    public BlogDto create(BlogDto blogDto) throws ParseException {
        Blog blog = new Blog();
        blog.setTema(blogDto.getTema());
        blog.setNombreTitulo(blogDto.getNombreTitulo());
        blog.setHabilitarComentario(blogDto.getHabilitarComentario());
        blog.setContenido(blogDto.getContenido());
        blog.setPeriodicidad(blogDto.getPeriodicidad());   
        
        Autor autor = new Autor();
        autor.setNombres(blogDto.getAutor().getNombres());
        autor.setApellidoPaterno(blogDto.getAutor().getApellidoPaterno());
        autor.setApellidoMaterno(blogDto.getAutor().getApellidoMaterno());
		autor.setFechaNacimiento(this.convertirFecha( blogDto.getAutor().getFechaNacimiento()));
		autor.setCorreoElectronico(blogDto.getAutor().getCorreoElectronico());
		autor.setPaisResidencia(blogDto.getAutor().getPaisResidencia());
        blog.addAutor(autor);
        blog = blogDao.save(blog);
        BlogDto dto = blogMapper.toGoDto(blog);
        return dto;
    }

    @Override
    public BlogDto update(BlogDto blogDto, Long blogId) {
    	Blog blog = blogDao.findById(blogId).get();
    	blog.setTema(blogDto.getTema());
        blog.setNombreTitulo(blogDto.getNombreTitulo());
        blog.setHabilitarComentario(blogDto.getHabilitarComentario());
        blog.setContenido(blogDto.getContenido());
        blog.setPeriodicidad(blogDto.getPeriodicidad());   
        blog = blogDao.save(blog);
        BlogDto dto = blogMapper.toGoDto(blog);
        return dto;
    }

    @Override
    public BlogDto delete(Long id) {
    	 return null;
    }
    
    private Date convertirFecha(String fecha) throws ParseException {
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	Date date = sdf.parse(fecha);
    	return date;
    }
}
