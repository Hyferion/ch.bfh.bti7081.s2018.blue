package ch.bfh.bti7081.blue.PMS;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;


class ChatBox extends CustomComponent {
    private static final long serialVersionUID = 4889740559403910624L;

    VerticalLayout messages = new VerticalLayout();

    public ChatBox() {
        setSizeFull();

        VerticalLayout content = new VerticalLayout();
        content.setSizeFull();
        setCompositionRoot(content);

        Panel messagesPanel = new Panel();
        messagesPanel.setSizeFull();
        messagesPanel.setContent(messages);
        content.addComponent(messagesPanel);
        content.setExpandRatio(messagesPanel, 1.0f);

        HorizontalLayout sendBar = new HorizontalLayout();
        sendBar.setWidth("100%");

        TextField input = new TextField();
        input.setWidth("100%");
        sendBar.addComponent(input);
        sendBar.setExpandRatio(input, 1.0f);

        Button send = new Button("Send");
        send.setClickShortcut(KeyCode.ENTER);
        send.addClickListener(event -> { // Java 8
            // Broadcast the input to others
            broadcast(input.getValue());
            addMessage(input.getValue()); // Add to self

            input.setValue("");
        });
        sendBar.addComponent(send);
        content.addComponent(sendBar);
    }


    // Send a message
    private void broadcast(String msg) {

    }

    private void addMessage(String msg) {
        messages.addComponent(new Label(msg));
    }
}