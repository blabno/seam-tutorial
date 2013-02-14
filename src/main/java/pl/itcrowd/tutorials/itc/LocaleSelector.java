package pl.itcrowd.tutorials.itc;

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

    private Locale locale;

    @Inject
    @Alter
    @Client
    private Event<Locale> localeEvent;

    public LocaleSelector()
    {
    }

    @Inject
    public LocaleSelector(@Client Locale locale)
    {
        this.locale = locale;
    }

    public Locale getLocale()
    {
        return locale;
    }

    public void setLocale(Locale locale)
    {
        this.locale = locale;
        localeEvent.fire(this.locale);
    }
}
