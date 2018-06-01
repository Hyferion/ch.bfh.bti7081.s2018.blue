package ch.bfh.bti7081.blue.PMS.view;

import ch.bfh.bti7081.blue.PMS.model.ChatModel;
import ch.bfh.bti7081.blue.PMS.presenter.Broadcaster;
//import com.sun.tools.javac.comp.Todo;
import com.vaadin.annotations.Push;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.View;
import com.vaadin.ui.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

@Push
public class ChatBox extends CustomComponent implements Broadcaster.BroadcastListener, View {
    private static final long serialVersionUID = 4889740559403910624L;


    VerticalLayout messages = new VerticalLayout();
    private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("relativeHelper");
    private EntityManager em = emFactory.createEntityManager();

    public ChatBox() {
        HeaderFooter root = new HeaderFooter("Chat");
       // setSizeFull();

        VerticalLayout content = new VerticalLayout();
       // content.setSizeFull();
        setCompositionRoot(root);

        Panel messagesPanel = new Panel();
        messagesPanel.setSizeFull();
        messagesPanel.setContent(messages);
        messagesPanel.setWidth("100%");
        messagesPanel.setHeight("600px");
        content.addComponent(messagesPanel);
        content.setExpandRatio(messagesPanel, 1.0f);

        HorizontalLayout sendBar = new HorizontalLayout();
        sendBar.setWidth("100%");

        TextField input = new TextField();
        input.setWidth("100%");
        sendBar.addComponent(input);
        sendBar.setExpandRatio(input, 1.0f);

        Query q = em.createQuery("select t from ChatModel t");
        List<ChatModel> chmod = q.getResultList();
        for (ChatModel mod : chmod) {
           addMessage(mod.getUsername()+ ": " + mod.getMessage());
        }

        Button send = new Button("Send");
        send.setClickShortcut(KeyCode.ENTER);
        send.addClickListener(event -> { // Java 8
            // Broadcast the input to others
            Broadcaster.broadcast(UI.getCurrent().getSession().getAttribute("user").toString() + ":" + input.getValue());
         //   addMessage(input.getValue()); // Add to self
            em.getTransaction().begin();
            ChatModel chmods = new ChatModel();
            chmods.setMessage(input.getValue());
            chmods.setUsername(UI.getCurrent().getSession().getAttribute("user").toString());
            em.persist(chmods);
            em.getTransaction().commit();


            input.setValue("");

        });
        sendBar.addComponent(send);
        content.addComponent(sendBar);
        root.getlayout().addComponent(content,1);

        Broadcaster.register(this);

    }

    private void addMessage(String msg) {
        messages.addComponent(new Label(msg));
    }

    @Override
    public void receiveBroadcast(final String message) {
              messages.addComponent(new Label(message));
    }

    @Override
    public void detach() {
        Broadcaster.unregister(this);
        super.detach();
    }

}