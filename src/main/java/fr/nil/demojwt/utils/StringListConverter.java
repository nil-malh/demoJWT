package fr.nil.demojwt.utils;

import jakarta.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.List;

public class StringListConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return String.join(",", attribute);
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        return Arrays.asList(dbData.split(","));
    }
}