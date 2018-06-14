package ch.bfh.bti7081.blue.PMS.view;

import java.util.List;

import javax.persistence.Query;

import com.vaadin.navigator.View;

import com.vaadin.ui.*;
import ch.bfh.bti7081.blue.PMS.model.Information;
import ch.bfh.bti7081.blue.PMS.model.InformationModelController;
import ch.bfh.bti7081.blue.PMS.presenter.InformationControllerView;

/**
 *
 * @author Sinthujah Kaneshan
 * Shows the View
 *
 */
public class InformationView extends CustomComponent implements View {

	private static final long serialVersionUID = 1L;

	Grid<Information> grid;

	public InformationView() {

		//Set root Layout with title
		HeaderFooter root = new HeaderFooter("Information About Addictions");

		//MainLayout for this view
		VerticalLayout mainLayout = new VerticalLayout();
		mainLayout.setSizeFull(); // mainLayout

		InformationModelController controller = new InformationModelController();

		List<Information> informations = controller.getInformations();


		// Accordion
		Accordion accordion = new Accordion();
		for (Information information: informations) {

			String name = information.getName();
			String description = information.getText();
			VerticalLayout tab = new VerticalLayout();
			tab.addComponent(new Label(description));
			accordion.addTab(tab, name, null);
		}


		mainLayout.addComponent(accordion);





		//Add mainLayout to the root View
		root.getlayout().addComponent(mainLayout, 1);

		setCompositionRoot(root);
	}



}