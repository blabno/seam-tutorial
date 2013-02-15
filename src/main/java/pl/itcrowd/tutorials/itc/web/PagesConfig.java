package pl.itcrowd.tutorials.itc.web;

import org.jboss.seam.faces.event.PhaseIdType;
import org.jboss.seam.faces.security.AccessDeniedView;
import org.jboss.seam.faces.security.LoginView;
import org.jboss.seam.faces.security.RestrictAtPhase;
import org.jboss.seam.faces.view.config.ViewConfig;
import org.jboss.seam.faces.view.config.ViewPattern;
import pl.itcrowd.tutorials.itc.security.AccessDenied;
import pl.itcrowd.tutorials.itc.security.Admin;

@ViewConfig
public interface PagesConfig {

    static enum Pages {
        @Admin @RestrictAtPhase(PhaseIdType.RESTORE_VIEW) @ViewPattern("/admin/*")
        ADMIN,
        @AccessDenied @RestrictAtPhase(PhaseIdType.RESTORE_VIEW) @ViewPattern("/layout/*")
        COMPONENTS,
        @RestrictAtPhase(PhaseIdType.RESTORE_VIEW) @AccessDeniedView("/401.xhtml") @LoginView("/login.xhtml") @ViewPattern("/*")
        ALL
    }
}
