package ch.bfh.bti7081.blue.PMS;

public interface LarsOrderView {
	public void setDisplay(double value);

	interface CalculatorViewListener {
		void buttonClick(char operation);
	}

	public void addListener(CalculatorViewListener listener);
	
}