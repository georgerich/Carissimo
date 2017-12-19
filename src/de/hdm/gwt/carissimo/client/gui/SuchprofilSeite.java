package de.hdm.gwt.carissimo.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SuchprofilSeite extends Composite {
	HorizontalPanel hPanel = new HorizontalPanel();
	Button suchprofilAnlegen = new Button();
	VerticalPanel vPanel = new VerticalPanel();
	
	SuchprofilAnlegen suchprofilEdit = new SuchprofilAnlegen();
 	
	public SuchprofilSeite() {
		initWidget(vPanel);
		
		vPanel.add(hPanel);
		hPanel.add(suchprofilAnlegen);
		
		suchprofilAnlegen.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				ladeSuchprofilAnlegen();
			}

		});
		
	}
	
	private void ladeSuchprofilAnlegen() {
		this.vPanel.clear();	
	}

}
