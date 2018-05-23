package ch.bfh.bti7081.blue.PMS;

import com.vaadin.annotations.Push;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.*;

@Push
class ChatBox extends CustomComponent implements Broadcaster.BroadcastListener {
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
            Broadcaster.broadcast(input.getValue());
         //   addMessage(input.getValue()); // Add to self

            input.setValue("");
        });
        sendBar.addComponent(send);
        content.addComponent(sendBar);

        Broadcaster.register(this);

    }

    /*private void addMessage(String msg) {
        messages.addComponent(new Label(msg));
    }*/

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