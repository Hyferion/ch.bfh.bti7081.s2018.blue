package ch.bfh.bti7081.blue.PMS;

public class CalendarPresenter implements CalendarView.CreateTaskListener {

	private CalendarView view;
	
	public CalendarPresenter(CalendarView view) {
		this.view = view;
		view.addCTListener(this);
		
	}
	

	@Override
	public void buttonClick() {
		// TODO Auto-generated method stub
		
	}

}
