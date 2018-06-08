package ch.bfh.bti7081.blue.PMS.steve;

import com.vaadin.server.ClassResource;
import com.vaadin.server.FileDownloader;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

public class TaskWindowImpl extends Window {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TaskWindowImpl() {
		
		VerticalLayout layout = new VerticalLayout();
		Label title = new Label("Task 1");//Name of Task
		title.setStyleName(ValoTheme.LABEL_H1);
		Label desctitle = new Label("Description");
		Label description = new Label("Some\nMultiline\nDescription", ContentMode.PREFORMATTED);
		Label filetitle = new Label ("Related Files");
		layout.addComponent(title);
		layout.addComponent(desctitle);
		layout.addComponent(description);
		layout.addComponent(filetitle);
		
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
		
		layout.addComponent(downloadfile1button);
		layout.addComponent(downloadfile2button);
		layout.addComponent(downloadfile3button);
		
		HorizontalLayout layouttaskbuttons = new HorizontalLayout();
		
		CheckBox donecheckbox = new CheckBox("Done");
		layouttaskbuttons.addComponent(donecheckbox);
		
		Button savebutton = new Button("Save");
		layouttaskbuttons.addComponent(savebutton);
		
		Button editbutton = new Button("Edit");
		layouttaskbuttons.addComponent(editbutton);
		
		Button deletebutton = new Button("Delete");
		layouttaskbuttons.addComponent(deletebutton);
		
		layout.addComponent(layouttaskbuttons);
		
		setHeight("550px");
		setWidth("400px");
		center();
		setContent(layout);
		
			
	}
	
	public void fileButtonClick(ClickEvent event) {
		
	}

}
