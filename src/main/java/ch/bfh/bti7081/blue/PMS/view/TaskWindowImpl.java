package ch.bfh.bti7081.blue.PMS.view;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

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

import ch.bfh.bti7081.blue.PMS.model.File;
import ch.bfh.bti7081.blue.PMS.model.Task;

public class TaskWindowImpl extends Window {
	
	
	private static final long serialVersionUID = 1L;
	private Task task;
	private List<File> fileList;
	

	public TaskWindowImpl(Task task, List<File> fileList) {
		this.task = task;
		this.fileList = fileList;
		
		VerticalLayout vLayout = new VerticalLayout();
		
		//Name of Task
		Label title = new Label("Task");
		title.setStyleName(ValoTheme.LABEL_H1);
		title.setHeight("0px");
		title.setValue(title.getValue() + " #" + task.getTaskId());
		
		// Create form layout
		FormLayout fLayout = new FormLayout();
		
		// Create subject field
		final TextField subjectField  = new TextField("Subject");
		subjectField.setWidth(100.0f, Unit.PERCENTAGE);
		subjectField.setReadOnly(true);
		subjectField.setValue(task.getSubject());
		
		// Create due date field
		final TextField dueDateField  = new TextField("Due Date");
		dueDateField.setWidth(20.0f, Unit.PERCENTAGE);
		dueDateField.setReadOnly(true);
		dueDateField.setValue(task.getDueDate().toString());
		
		// Create description Area
		final TextArea descriptionField = new TextArea("Description");
		descriptionField.setWidth(100.0f, Unit.PERCENTAGE);
		descriptionField.setReadOnly(true);
		descriptionField.setValue(task.getDescription());
		
		
		// Create status label
		final Label statusLabel = new Label();
		statusLabel.setCaption("Status");
		statusLabel.setValue(task.getStatus());
	
		// Files to download
		HorizontalLayout hLayout = new HorizontalLayout();
		if (fileList != null) {
		for (File file : fileList) {
			Path path = Paths.get(file.getPath());
			ClassResource resourcefile = new ClassResource(path.toString());
			Button downloadfile1button = new Button(resourcefile.getFilename()+"."+resourcefile.getMIMEType());
			downloadfile1button.setStyleName(ValoTheme.BUTTON_LINK);
			FileDownloader downloaderfile1 = new FileDownloader(resourcefile);
			downloaderfile1.extend(downloadfile1button);
			hLayout.addComponent(downloadfile1button);
		}
		}
	
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
