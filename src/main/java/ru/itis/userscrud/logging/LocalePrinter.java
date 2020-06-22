package ru.itis.userscrud.logging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.format.Printer;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class LocalePrinter implements Printer {

    @Autowired
    private MessageSource messageSource;

    @Override
    public String print(Object object, Locale locale) {
        String key;
        try {
            key = (String) object;
        }
        catch (Exception e) {
            throw new IllegalArgumentException("string with message key must be passed as an argument");
        }
        return messageSource.getMessage(key, (new Object[1]) , locale);
    }
}
