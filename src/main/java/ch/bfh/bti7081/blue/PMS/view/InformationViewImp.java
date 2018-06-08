package ch.bfh.bti7081.blue.PMS.view;

import java.util.List;

import javax.persistence.Query;

import com.vaadin.navigator.View;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import ch.bfh.bti7081.blue.PMS.model.Information;

/**
 * 
 * @author Sinthujah
 *
 */
public class InformationViewImp extends CustomComponent implements View {

	private static final long serialVersionUID = 1L;
	
	Grid<Information> grid;

	public InformationViewImp() {

		//Set root Layout with title
		HeaderFooter root = new HeaderFooter("Informationen über Suchtkrankheiten"); 

		//MainLayout for this view
		VerticalLayout mainLayout = new VerticalLayout();
		mainLayout.setSizeFull(); // mainLayout
		
		

		
	        
		grid = new Grid<>();
		grid.setSizeFull();
		grid.addColumn(Information::getName).setCaption("Suchtart").setResizable(false);
		grid.addColumn(Information::getText).setCaption("Beschreibung").setResizable(false);

		mainLayout.addComponent(grid);
		
		mainLayout.setExpandRatio(grid, 0.6f);
		
		
		
		
		//HorizontalLayout for the Buttons "Order history" and "Send order"
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setSizeFull();

		
		//Add horziontalLayout to the mainLayout
		mainLayout.addComponent(horizontalLayout);
		
		//Add mainLayout to the root View
		root.getlayout().addComponent(mainLayout, 1);

		setCompositionRoot(root);
	}

	public Grid getGrid() {
		return this.grid;
	}


}