package ch.bfh.bti7081.blue.PMS.steve;

import ch.bfh.bti7081.blue.PMS.model.Task;

public class TaskWindowPresenter {
	private Task model;
	private TaskWindowImpl view;
	
	public TaskWindowPresenter(Task model, TaskWindowImpl view) {
		this.model = model;
		this.view = view;
	}
}
