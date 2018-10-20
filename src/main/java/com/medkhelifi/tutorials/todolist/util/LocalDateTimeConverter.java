package com.medkhelifi.tutorials.todolist.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

/**
 * Faces converter for support of LocalDate
 * @author Juneau
 */
@FacesConverter(value="localDateTimeConverter")
public class LocalDateTimeConverter implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        DateTimeFormatter formatter =     DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");

        return LocalDateTime.parse(value, formatter);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        LocalDateTime dateValue = (LocalDateTime) value;

        return dateValue.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
    }
}