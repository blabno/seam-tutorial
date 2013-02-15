package pl.itcrowd.tutorials.itc.view;

import org.jboss.seam.mail.api.MailMessage;
import org.jboss.seam.mail.attachments.InputStreamAttachment;
import org.jboss.seam.mail.core.enumerations.ContentDisposition;
import org.jboss.seam.mail.templating.freemarker.FreeMarkerTemplate;
import org.jboss.solder.resourceLoader.ResourceProvider;
import pl.itcrowd.tutorials.itc.domain.User;
import pl.itcrowd.tutorials.itc.security.CurrentUser;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

@Named
@RequestScoped
public class MessageView {

    private String content;

    @Inject
    private ExternalContext externalContext;

    @Inject
    private MailMessage mailMessage;

    private String recipient;

    @Inject
    private ResourceProvider resourceProvider;

    private String title;

    @CurrentUser
    @Inject
    private User user;

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getRecipient()
    {
        return recipient;
    }

    public void setRecipient(String recipient)
    {
        this.recipient = recipient;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void send()
    {
        mailMessage.to(recipient)
            .subject(title)
            .bodyHtml(new FreeMarkerTemplate(resourceProvider.loadResourceStream("mail/mailTemplate.ftl")))
            .bodyText(content)
            .put("content", content)
            .put("currentUser", user)
            .put("date", new Date())
            .addAttachment(
                new InputStreamAttachment("footer-logo.png", "image/png", ContentDisposition.ATTACHMENT, externalContext.getResourceAsStream("/logo.png")))
            .send();
    }
}
