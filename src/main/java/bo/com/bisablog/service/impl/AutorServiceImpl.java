package bo.com.bisablog.service.impl;

import bo.com.bisablog.entity.Autor;
import bo.com.bisablog.entity.dto.AutorDto;
import bo.com.bisablog.respository.AutorDao;
import bo.com.bisablog.service.IAutorService;
import bo.com.bisablog.service.mapper.AutorMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class AutorServiceImpl implements IAutorService {
    private AutorDao autorDao;
    private AutorMapper autorMapper;
    @Override
    public List<AutorDto> findAll() {
        List<Autor> autors = autorDao.findAll();
        List<AutorDto> autorDtos = autorMapper.toAutorDtoList(autors);
        return autorDtos;
    }

    @Override
    public AutorDto findById(Long id) {
        Autor autor = autorDao.findById(id).get();
        AutorDto autorDto = autorMapper.toGoDto(autor);
        return autorDto;
    }

    @Override
    public AutorDto save(AutorDto autorDto) throws ParseException {
        Autor autor = new Autor();
        autor.setNombres(autorDto.getNombres());
        autor.setApellidoPaterno(autorDto.getApellidoPaterno());
        autor.setApellidoMaterno(autorDto.getApellidoMaterno());
        autor.setCorreoElectronico(autorDto.getCorreoElectronico());
        autor.setFechaNacimiento(this.convertirFecha( autorDto.getFechaNacimiento()));
        autor.setPaisResidencia(autorDto.getPaisResidencia());
        
        autor = autorDao.save(autor);
        AutorDto autorDto2 = autorMapper.toGoDto(autor);
        return autorDto2;
    }

    @Override
    public AutorDto update(AutorDto autorDto, Long autorId) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Autor autor = autorDao.findById(id).get();
        autorDao.delete(autor);
    }
    
    private Date convertirFecha(String fecha) throws ParseException {
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	Date date = sdf.parse(fecha);
    	return date;
    }
}
