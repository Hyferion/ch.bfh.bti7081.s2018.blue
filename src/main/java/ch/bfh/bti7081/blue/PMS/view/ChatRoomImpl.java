package ch.bfh.bti7081.blue.PMS.view;

import ch.bfh.bti7081.blue.PMS.model.ChatModel;
import ch.bfh.bti7081.blue.PMS.model.ChatRoomModel;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import sun.jvm.hotspot.debugger.Page;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.soap.Text;
import java.util.List;

public class ChatRoomImpl extends CustomComponent implements View {
    private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("relativeHelper");
    private EntityManager em = emFactory.createEntityManager();




    public ChatRoomImpl(){
        HeaderFooter root = new HeaderFooter("ChatRoom");
        setCompositionRoot(root);
        VerticalLayout mainLayout = new VerticalLayout();
        HorizontalLayout addBtns = new HorizontalLayout();
        HorizontalLayout chatroomBtns = new HorizontalLayout();

        TextField txtTitle = new TextField("Name");
        TextField txtDescription = new TextField("Description");
        Button addBtn = new Button("Add");
        addBtn.addClickListener(clickEvent -> {
            em.getTransaction().begin();
            ChatRoomModel chmods = new ChatRoomModel();
            chmods.setName(txtTitle.getValue());
            chmods.setDescription(txtDescription.getValue());
            em.persist(chmods);
            em.getTransaction().commit();

            Button btn = new Button("Name: " + txtTitle.getValue() + " Description: " + txtDescription.getValue());
            chatroomBtns.addComponent(btn);
        });
        addBtns.addComponent(txtTitle);
        addBtns.addComponent(txtDescription);
        addBtns.addComponent(addBtn);

        Query q = em.createQuery("select t from ChatRoomModel t");
        List<ChatRoomModel> chmod = q.getResultList();
        for (ChatRoomModel mod : chmod) {
            Button btn = new Button("Name: " + mod.getName() + " Description: " + mod.getDescription());
            btn.addClickListener(clickEvent -> {
                getUI().getSession().setAttribute("room",mod.getId());
                getUI().getNavigator().navigateTo("Chat"  + "/" + mod.getId());
            });

            chatroomBtns.addComponent(btn);
        }

        mainLayout.addComponent(addBtns);
        mainLayout.addComponent(chatroomBtns);
        root.getlayout().addComponent(mainLayout,1);

    }








}
