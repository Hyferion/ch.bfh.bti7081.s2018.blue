package ch.bfh.bti7081.blue.PMS;

public interface OrderView {
	public void setDisplay(double value);

	interface CalculatorViewListener {
		void buttonClick(char operation);
	}

	public void addListener(CalculatorViewListener listener);
	
}