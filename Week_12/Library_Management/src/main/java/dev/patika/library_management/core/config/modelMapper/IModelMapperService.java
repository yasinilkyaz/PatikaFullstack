package dev.patika.library_management.core.config.modelMapper;

import org.modelmapper.ModelMapper;

public interface IModelMapperService {

    ModelMapper forRequest();
    ModelMapper forResponse();
}
