package bo.com.bisablog.service.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import bo.com.bisablog.entity.Autor;
import bo.com.bisablog.entity.dto.AutorDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AutorMapper {

    AutorDto toGoDto(Autor blog);

    @InheritInverseConfiguration
    Autor toEntity(AutorDto autorDto);

    List<AutorDto> toAutorDtoList(List<Autor> autorList);

    List<Autor> toAutorList(List<AutorDto> autorDtoList);
}
