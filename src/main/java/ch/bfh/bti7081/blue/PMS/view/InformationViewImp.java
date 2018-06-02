package ch.bfh.bti7081.blue.PMS.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.View;

import com.vaadin.ui.CheckBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.blue.PMS.model.Information;
import ch.bfh.bti7081.blue.PMS.model.OrderStatus;
import ch.bfh.bti7081.blue.PMS.view.interfaces.SimonOrderViewInterface.OrderViewListener;

/**
 * 
 * @author Sinthujah
 *
 */
public class InformationViewImp extends CustomComponent implements View {

	private static final long serialVersionUID = 1L;
	
	Grid<Information> grid;

	ArrayList<CheckBox> checkBoxList = new ArrayList<CheckBox>();
	List<OrderViewListener> listeners = new ArrayList<OrderViewListener>();

	public InformationViewImp() {

		//Set root Layout with title
		HeaderFooter root = new HeaderFooter("Informationen über Suchtkrankheiten"); 

		//MainLayout for this view
		VerticalLayout mainLayout = new VerticalLayout();
		mainLayout.setSizeFull(); // mainLayout
		
		
		grid = new Grid<>();
		grid.setSizeFull();
		grid.addColumn(Information::getName).setCaption("Suchtart").setResizable(false);
		grid.addColumn(Information::getText).setCaption("Bescheibung").setResizable(false);

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
	
	public void addListener(OrderViewListener listener) {
		listeners.add(listener);

	}


}