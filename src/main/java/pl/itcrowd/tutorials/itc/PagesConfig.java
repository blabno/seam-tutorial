package pl.itcrowd.tutorials.itc;

import org.jboss.seam.faces.event.PhaseIdType;
import org.jboss.seam.faces.security.RestrictAtPhase;
import org.jboss.seam.faces.view.config.ViewConfig;
import org.jboss.seam.faces.view.config.ViewPattern;

@ViewConfig
public interface PagesConfig {

    static enum Pages {
        @AccessDenied @RestrictAtPhase(PhaseIdType.RESTORE_VIEW) @ViewPattern("/layout/*")
        COMPONENTS
    }
}
