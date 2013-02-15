package pl.itcrowd.tutorials.itc.web;

import org.jboss.seam.faces.event.PhaseIdType;
import org.jboss.seam.faces.security.RestrictAtPhase;
import org.jboss.seam.faces.view.config.ViewConfig;
import org.jboss.seam.faces.view.config.ViewPattern;
import pl.itcrowd.tutorials.itc.security.AccessDenied;

@ViewConfig
public interface PagesConfig {

    static enum Pages {
        @AccessDenied @RestrictAtPhase(PhaseIdType.RESTORE_VIEW) @ViewPattern("/layout/*")
        COMPONENTS
    }
}
