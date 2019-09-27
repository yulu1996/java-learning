package com.demo.order.util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

@Converter(autoApply = true)
public class ListConverter implements AttributeConverter<List<String>, String> {

    private static final String SEPARATOR = ",";

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
      return Joiner.on(SEPARATOR).join(attribute);
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
      return new ArrayList<>(
          Splitter.on(SEPARATOR).trimResults().omitEmptyStrings().splitToList(dbData));
    }
  }
