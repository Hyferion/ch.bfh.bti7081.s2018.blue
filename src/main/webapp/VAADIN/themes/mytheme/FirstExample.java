package Blue.Startsite;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


public class FirstExample extends UI {

	public FirstExample(String message) {
		
		Panel panel = new Panel("Software-Name");
		panel.setWidth("300px");
		
		VerticalLayout panelContent = new VerticalLayout();
		panelContent.setMargin(true);
		panel.setContent(panelContent);
		
		Label label = new Label(message);
		label.setSizeUndefined();
		panelContent.addComponent(label);
		
		Button button = new Button("Buttonname1");
		
		panelContent.setSizeUndefined();
		panel.setSizeUndefined();
		setSizeUndefined();

		//set the composition root
		setCompositionRoot(panel);
	}
}
