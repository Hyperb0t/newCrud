package ru.itis.userscrud.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class WebInitializer extends AbstractDispatcherServletInitializer {

  @Override
  protected WebApplicationContext createRootApplicationContext() {
    AnnotationConfigWebApplicationContext cxt = new AnnotationConfigWebApplicationContext();
    cxt.register(RootConfig.class);
    cxt.register(PersistanceJpaConfig.class);
    return cxt;
  }

  @Override
  protected WebApplicationContext createServletApplicationContext() {
    AnnotationConfigWebApplicationContext cxt = new AnnotationConfigWebApplicationContext();
    cxt.register(WebConfig.class);
    return cxt;
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/"};
  }

}
