package ru.itis.userscrud.logging;

import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.userscrud.dao.JpaLoggingRepository;
import ru.itis.userscrud.models.Logging;

import java.time.LocalDateTime;

@Plugin(
        name = "DbAppender",
        category = Core.CATEGORY_NAME,
        elementType = Appender.ELEMENT_TYPE)
public class DbAppender extends AbstractAppender {

    @Autowired
    private JpaLoggingRepository loggingRepository;


    protected DbAppender(String name, Filter filter) {
        super(name, filter, null);
    }

    @PluginFactory
    public static DbAppender createAppender(
            @PluginAttribute("name") String name,
            @PluginElement("Filter") Filter filter) {
        return new DbAppender(name, filter);
    }

    @Override
    public void append(LogEvent event) {
        loggingRepository.save(
                Logging.builder().
                        message(event.getMessage().toString()).
                        dateTime(LocalDateTime.now()).build()
        );
    }
}