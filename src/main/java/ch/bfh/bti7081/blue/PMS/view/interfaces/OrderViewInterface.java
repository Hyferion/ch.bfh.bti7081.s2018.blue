package ch.bfh.bti7081.blue.PMS.view.interfaces;

import java.util.List;

import javax.persistence.EntityManager;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.bti7081.blue.PMS.model.OrderModel;

public interface OrderViewInterface extends View {

	interface OrderViewListener {

		void buttonClick(String string);

		EntityManager getQuery();

		List<OrderModel> getResultList();

	}

	void buttonClick(ClickEvent event);

}