package ch.bfh.bti7081.blue.PMS;

public class TaskPresenter {
	private TaskModel model;
	private TaskViewImpl view;
	
	public TaskPresenter(TaskModel model, TaskViewImpl view) {
		this.model = model;
		this.view = view;
	}
}
