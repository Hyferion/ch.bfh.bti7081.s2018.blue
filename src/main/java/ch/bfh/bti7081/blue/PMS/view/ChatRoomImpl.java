package ch.bfh.bti7081.blue.PMS.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ClassResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.bti7081.blue.PMS.model.ChatRoomModel;

public class ChatRoomImpl extends CustomComponent implements View {
    private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("relativeHelper");
    private EntityManager em = emFactory.createEntityManager();
    private UI ui = UI.getCurrent();


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        com.vaadin.server.Page.getCurrent().replaceState("/");
    }

    public ChatRoomImpl() {
        HeaderFooter root = new HeaderFooter("ChatRoom");
        setCompositionRoot(root);
        VerticalLayout mainLayout = new VerticalLayout();
        HorizontalLayout addBtns = new HorizontalLayout();
        HorizontalLayout chatroomBtns = new HorizontalLayout();

        TextField txtTitle = new TextField("Name");
        TextField txtDescription = new TextField("Description");
        Image image = new Image(null, new ClassResource("/icons/add.png"));
        image.addClickListener(clickEvent -> {
            writetoDB(txtTitle.getValue(), txtDescription.getValue());
            Notification.show("Chatroom created!", Notification.TYPE_TRAY_NOTIFICATION);

            Button btn = new Button("Name: " + txtTitle.getValue() + " Description: " + txtDescription.getValue());
            chatroomBtns.addComponent(btn);
        });

        Query q = em.createQuery("select t from ChatRoomModel t");
        List<ChatRoomModel> chmod = q.getResultList();
        for (ChatRoomModel mod : chmod) {
            Button btn = new Button("Name: " + mod.getName() + " Description: " + mod.getDescription());
            btn.addClickListener(clickEvent -> {
                //ui.getSession().setAttribute("room", mod.getName());
                com.vaadin.server.Page.getCurrent().pushState("/" + mod.getId().toString());
                getUI().getNavigator().navigateTo("Chat");
            });

            chatroomBtns.addComponent(btn);
        }

        addBtns.addComponent(txtTitle);
        addBtns.addComponent(txtDescription);
        addBtns.addComponent(image);

        mainLayout.addComponent(addBtns);
        mainLayout.addComponent(chatroomBtns);
        root.getlayout().addComponent(mainLayout, 1);

    }

    public void writetoDB(String txtTitle, String txtDescription) {
        em.getTransaction().begin();
        ChatRoomModel chmods = new ChatRoomModel();
        chmods.setName(txtTitle);
        chmods.setDescription(txtDescription);
        em.persist(chmods);
        em.getTransaction().commit();
    }

}
