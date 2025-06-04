package com.decode_code.clean_architecture_spring.application.mappers;

import org.modelmapper.ModelMapper;

import java.util.List;

public final class MapperUtil {

    private static final ModelMapper modelMapper = new ModelMapper();

    private MapperUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static <S, T> T convert(S source, Class<T> targetClass) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(source, targetClass);
    }

    public static <S, T> List<T> convertList(List<S> sourceList, Class<T> targetClass) {
        return sourceList.stream()
                .map(source -> convert(source, targetClass))
                .toList();
    }

}
