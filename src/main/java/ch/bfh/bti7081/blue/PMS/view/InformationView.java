package ch.bfh.bti7081.blue.PMS.view;

import com.vaadin.navigator.View;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;


public class InformationView extends CustomComponent implements View {

	private static final long serialVersionUID = 4889740559403910624L;
	
			public InformationView() {
				
				//Layout with title			
				HeaderFooter root = new HeaderFooter("Informationen über Suchtkrankheiten");
				
				//MainLayout for the view
				VerticalLayout mainLayout = new VerticalLayout();
				mainLayout.setSizeFull(); // mainLayout
				
				//GridLayout to display all addictions
				GridLayout GridLayout = new GridLayout(10, 0); 
				mainLayout.addComponent(GridLayout);
				GridLayout.setSpacing(true);
				GridLayout.setSizeFull();
				
				//Caption for the table
				Label captionFirstColumn = new Label("Suchtkrankheiten");
				captionFirstColumn.addStyleName(ValoTheme.LABEL_H2);
				GridLayout.addComponent(captionFirstColumn);
				
				
				//Fill the table with informations from the database
				for (int i = 0; i < 10; i++) {
					GridLayout.addComponent(new Label("test1"));
				}
				
				//Add mainLayout to the root View
				root.getlayout().addComponent(mainLayout, 1);

				setCompositionRoot(root);
			}		
				
		}