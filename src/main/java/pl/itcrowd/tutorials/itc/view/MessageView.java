package pl.itcrowd.tutorials.itc.view;

import org.jboss.seam.mail.api.MailMessage;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class MessageView {

    private String content;

    @Inject
    private MailMessage mailMessage;

    private String recipient;

    private String title;

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
        mailMessage.to(recipient).subject(title).bodyText(content).send();
    }
}
