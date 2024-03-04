package Listener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppContextAttributeListener
        implements ServletContextAttributeListener {

    @Override
    public void
            attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println(
                "ServletContext attribute added::{"
                + servletContextAttributeEvent.getName() + ","
                + servletContextAttributeEvent.getValue()
                + "}");
    }

    @Override
    public void
            attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println(
                "ServletContext attribute replaced::{"
                + servletContextAttributeEvent.getName() + ","
                + servletContextAttributeEvent.getValue()
                + "}");
    }

    @Override
    public void
            attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println(
                "ServletContext attribute removed::{"
                + servletContextAttributeEvent.getName() + ","
                + servletContextAttributeEvent.getValue()
                + "}");
    }
}
