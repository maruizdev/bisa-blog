package bo.com.bisablog.service;

import java.text.ParseException;
import java.util.List;

import bo.com.bisablog.entity.dto.AutorDto;

public interface IAutorService {

    public List<AutorDto> findAll();
    public AutorDto findById(Long id);
    public AutorDto save(AutorDto autor) throws ParseException;
    public AutorDto update(AutorDto autor, Long autorId);
    public void delete(Long id);
}
