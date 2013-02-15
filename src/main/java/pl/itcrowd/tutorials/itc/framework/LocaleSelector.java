package pl.itcrowd.tutorials.itc.framework;

import org.jboss.seam.international.Alter;
import org.jboss.solder.core.Client;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Locale;

@Named
@RequestScoped
public class LocaleSelector {

    @Inject
    @Alter
    @Client
    private Event<Locale> localeEvent;

    public void setLocale(Locale locale)
    {
        localeEvent.fire(locale);
    }
}
