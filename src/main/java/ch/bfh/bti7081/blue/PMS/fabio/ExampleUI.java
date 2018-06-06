package ch.bfh.bti7081.blue.PMS.fabio;
/*package ch.bfh.bti7081.blue.PMS;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ExampleUI {

	final static HorizontalLayout layoutH = new HorizontalLayout();
	final static VerticalLayout layoutV = new VerticalLayout();
	static GridLayout grid = new GridLayout(1, 1);

	public static HorizontalLayout start() {

		List<TaskModelTest> list = TaskModelTest.getRandomTasks(30);

		NativeSelect<String> ns = new NativeSelect<String>("Filter Tasks");
		ns.setItems("Today", "This Week", "This Month", "This Year", "Show All");
		ns.setEmptySelectionAllowed(false);
		ns.addValueChangeListener(e -> filterList(ns.getValue(), list));

		Button button = new Button("+ Create New Task");
		layoutV.addComponent(ns);
		layoutH.addComponents(layoutV, button);

		return layoutH;

	}

	public static void filterList(String filter, List<TaskModelTest> list) {

		System.out.println(filter);
		List<TaskModelTest> filterList = new ArrayList<>();

		switch (filter) {
		case "Today":
			filterList = list.stream().filter(t -> t.getDate().now() == LocalDate.now()).collect(Collectors.toList());
			break;

		case "This Week":
			break;
		case "This Month":
			filterList = list.stream().filter(t -> t.getDate().getMonthValue() == LocalDate.now().getMonthValue())
					.collect(Collectors.toList());
			break;
		case "This Year":
			filterList = list.stream().filter(t -> t.getDate().getYear() == LocalDate.now().getYear())
					.collect(Collectors.toList());
		case "Show All":
			filterList = list;
			break;
		default:
			System.out.println("Didn't work!");
		}

		int col = 4;
		int row = filterList.size();
		System.out.println(row);

		if (row == 0) {
			grid.removeAllComponents();
			System.out.println("i was here task not found");
			grid.addComponent(new Label("No Tasks found."), 0, 0);
		} else {
			grid.removeAllComponents();
			grid = new GridLayout(col, row);
			for (int i = 0; i < filterList.size(); i++) {
				grid.addComponent(
						new Label(filterList.get(i).getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))), 0, i);
				i++;
			}
		}
		layoutV.removeComponent(grid);
		layoutV.addComponent(grid);
		filterList.forEach(t -> t.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
		filterList.forEach(t -> System.out.println(t.getDate()));

	}

}*/
