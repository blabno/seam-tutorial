package pl.itcrowd.tutorials.itc.framework;

import org.jboss.solder.core.ExtensionManaged;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public class EntityManagerProducer {

    @ExtensionManaged
    @Produces
    @PersistenceUnit
    @ConversationScoped
    private EntityManagerFactory conversationEMF;

    @Standalone
    @ExtensionManaged
    @Produces
    @PersistenceUnit
    private EntityManagerFactory standaloneEMF;
}
