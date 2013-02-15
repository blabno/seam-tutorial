package pl.itcrowd.tutorials.itc.security;

import org.jboss.seam.international.status.Messages;
import org.jboss.seam.international.status.builder.BundleKey;
import org.jboss.seam.security.BaseAuthenticator;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;
import org.picketlink.idm.impl.api.PasswordCredential;
import org.picketlink.idm.impl.api.model.SimpleUser;
import pl.itcrowd.tutorials.itc.dao.UserDAO;
import pl.itcrowd.tutorials.itc.domain.User;

import javax.inject.Inject;

public class UserAuthenticator extends BaseAuthenticator {

    @Inject
    private Credentials credentials;

    @Inject
    private Identity identity;

    @Inject
    private UserDAO userDAO;

    @Inject
    private Messages messages;

    @Override
    public void authenticate()
    {
        final User user = userDAO.getUserByEmail(credentials.getUsername());
        final String password = ((PasswordCredential) credentials.getCredential()).getValue();
        if (user == null || password == null || !password.equals(user.getPassword())) {
            setStatus(AuthenticationStatus.FAILURE);
            messages.error(new BundleKey("messages", "pl.itcrowd.tutorials.itc.security.UserAuthenticator.loginFailed"));
        } else {
            setStatus(AuthenticationStatus.SUCCESS);
            setUser(new SimpleUser(user.getEmail()));
            identity.addRole(user.getRole(), "USERS", "GROUP");
        }
    }
}
