package bo.com.bisablog.service;

import java.text.ParseException;
import java.util.List;

import bo.com.bisablog.entity.dto.BlogDto;
import bo.com.bisablog.entity.dto.BlogGeneralDto;

public interface IBlogService {
    public List<BlogGeneralDto> findAll();
    public BlogGeneralDto findById(Long id);
    public BlogDto create(BlogDto blog) throws ParseException;
    public BlogDto update(BlogDto blog, Long blogId);
    public BlogDto delete(Long id);

}
