package pl.itcrowd.tutorials.itc;

import org.jboss.seam.faces.event.PhaseIdType;
import org.jboss.seam.faces.security.RestrictAtPhase;
import org.jboss.seam.security.annotations.SecurityBindingType;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@RestrictAtPhase(
    {PhaseIdType.RESTORE_VIEW, PhaseIdType.APPLY_REQUEST_VALUES, PhaseIdType.INVOKE_APPLICATION, PhaseIdType.PROCESS_VALIDATIONS, PhaseIdType.RENDER_RESPONSE,
        PhaseIdType.UPDATE_MODEL_VALUES})
@SecurityBindingType
@Target({TYPE, METHOD, PARAMETER, FIELD})
@Retention(RUNTIME)
public @interface AccessDenied {

}
