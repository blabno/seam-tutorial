package pl.itcrowd.tutorials.itc;

import org.jboss.seam.international.locale.LocaleUtils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.util.Locale;

@FacesConverter(value = "localeConverter", forClass = Locale.class)
public class LocaleConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value)
    {
        try {
            return LocaleUtils.toLocale(value);
        } catch (IllegalArgumentException e) {
            throw new ConverterException(e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value)
    {
        return value.toString();
    }
}
