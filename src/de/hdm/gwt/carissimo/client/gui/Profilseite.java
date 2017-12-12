package de.hdm.gwt.carissimo.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;

public class Profilseite extends Composite {
	
	private HorizontalPanel hPanel = new HorizontalPanel();
		
		public Profilseite() {
			initWidget(this.hPanel);
			
			FlexTable profilinformation = new FlexTable();
			
			profilinformation.setStyleName("profilInfoTable");
			profilinformation.setText(0, 0, "Vorname");
			profilinformation.setText(0, 1, "Nachname");
			
			hPanel.add(profilinformation);
			
			RootPanel.get("contentBox").add(hPanel);
			
		}

}
