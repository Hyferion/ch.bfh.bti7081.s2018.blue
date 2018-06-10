package ch.bfh.bti7081.blue.PMS.steve;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ClassResource;
import com.vaadin.server.FileDownloader;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.blue.PMS.model.Task;

public class TaskWindowImpl extends Window {
	
	
	private static final long serialVersionUID = 1L;
	private Task task;
	

	public TaskWindowImpl() {
		
		VerticalLayout vLayout = new VerticalLayout();
		
		//Name of Task
		Label title = new Label("Task");
		title.setStyleName(ValoTheme.LABEL_H1);
		title.setHeight("0px");
		
		// Create form layout
		FormLayout fLayout = new FormLayout();
		
		// Create subject field
		final TextField subjectField  = new TextField("Subject");
		subjectField.setWidth(100.0f, Unit.PERCENTAGE);
		subjectField.setReadOnly(true);
		
		// Create due date field
		final TextField dueDateField  = new TextField("Due Date");
		dueDateField.setWidth(20.0f, Unit.PERCENTAGE);
		dueDateField.setReadOnly(true);
		
		// Create description Area
		final TextArea descriptionField = new TextArea("Description");
		descriptionField.setWidth(100.0f, Unit.PERCENTAGE);
		descriptionField.setReadOnly(true);
		
		// Create status label
		final Label statusLabel = new Label();
		statusLabel.setCaption("Status");
		statusLabel.setValue("Done");		
	
		// Files to download
		HorizontalLayout hLayout = new HorizontalLayout();
		ClassResource resourcefile1 = new ClassResource("File1.txt");
		ClassResource resourcefile2 = new ClassResource("File2.txt");
		ClassResource resourcefile3 = new ClassResource("File3.txt");
		
		Button downloadfile1button = new Button("File1.txt");
		downloadfile1button.setStyleName(ValoTheme.BUTTON_LINK);
		Button downloadfile2button = new Button("File2.txt");
		downloadfile2button.setStyleName(ValoTheme.BUTTON_LINK);
		Button downloadfile3button = new Button("File3.txt");
		downloadfile3button.setStyleName(ValoTheme.BUTTON_LINK);
		
		FileDownloader downloaderfile1 = new FileDownloader(resourcefile1);
		downloaderfile1.extend(downloadfile1button);
		FileDownloader downloaderfile2 = new FileDownloader(resourcefile2);
		downloaderfile2.extend(downloadfile2button);
		FileDownloader downloaderfile3 = new FileDownloader(resourcefile3);
		downloaderfile3.extend(downloadfile3button);
		
		hLayout.addComponent(downloadfile1button);
		hLayout.addComponent(downloadfile2button);
		hLayout.addComponent(downloadfile3button);
		hLayout.setCaption("Downloads");
		hLayout.setMargin(false);
		
		// Add components to form layout
		fLayout.addComponents(subjectField, dueDateField, descriptionField, statusLabel, hLayout);
		
		
		// components to vertical layout and set content		
		vLayout.addComponents(title, fLayout);
		
		setContent(vLayout);
		
		// Specify the window size
		setHeight("500px");
		setWidth("700px");
		center();
		
		
		
			
	}
	
	public void fileButtonClick(ClickEvent event) {
		
	}

}
