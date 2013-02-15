package pl.itcrowd.tutorials.itc.security;

import org.jboss.seam.security.AuthorizationException;
import org.jboss.solder.exception.control.CaughtException;
import org.jboss.solder.exception.control.Handles;
import org.jboss.solder.exception.control.HandlesExceptions;
import org.jboss.solder.logging.Logger;
import org.jboss.solder.servlet.http.ContextPath;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.IOException;

@HandlesExceptions
public class SecurityExceptionHandler {

    @Inject
    @ContextPath
    private String contextPath;

    @SuppressWarnings({"CdiInjectionPointsInspection"})
    @Inject
    private FacesContext facesContext;

    @SuppressWarnings("CdiInjectionPointsInspection")
    @Inject
    private Logger log;

    @SuppressWarnings("UnusedDeclaration")
    public void handleAuthorizationException(@Handles CaughtException<AuthorizationException> evt)
    {
        final String deniedView = contextPath + "/login.jsf";
        try {
            facesContext.getExternalContext().redirect(deniedView);
        } catch (IOException ignored) {
            log.errorv(ignored, "Cannot redirect to {0}", deniedView);
        }
        evt.handled();
    }
}
