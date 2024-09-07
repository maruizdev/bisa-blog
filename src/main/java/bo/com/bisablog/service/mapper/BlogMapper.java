package bo.com.bisablog.service.mapper;

import bo.com.bisablog.entity.Blog;
import bo.com.bisablog.entity.dto.BlogDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BlogMapper {

    BlogDto toGoDto(Blog blog);

    @InheritInverseConfiguration
    Blog toEntity(BlogDto blogDto);

    List<BlogDto> toBlogDtoList(List<Blog> blogList);

    List<Blog> toBlogList(List<BlogDto> blogDtoList);
}
