package by.pvt.dumping.managers;

import by.pvt.dumping.constants.ConfigConstants;
import by.pvt.dumping.constants.Parameters;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.ResourceBundle;


@Component
public class MessageManager {

    public MessageManager() {}

    public String getProperty(String key, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Locale locale = (Locale) session.getAttribute(Parameters.LOCALE);
        if (locale == null) {
            locale = new Locale("ru", "RU");
            session.setAttribute(Parameters.LOCALE, locale);
        }
        return ResourceBundle.getBundle(ConfigConstants.MESSAGES_SOURCE, locale).getString(key);
    }
}
