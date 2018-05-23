package ch.bfh.bti7081.blue.PMS;

import com.vaadin.annotations.Push;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

@Push
public class BroadcasterUI extends UI implements Broadcaster.BroadcastListener {

    @Override
    protected void init(VaadinRequest request) {
        // Register broadcast listener
        Broadcaster.register(this);
    }

    @Override
    public void detach() {
        Broadcaster.unregister(this);
        super.detach();
    }

    @Override
    public void receiveBroadcast(final String message) {
        access(new Runnable() {
            @Override
            public void run() {
                Notification n = new Notification("Message received",
                        message, Notification.Type.TRAY_NOTIFICATION);
                n.show(getPage());
            }
        });
    }
}
