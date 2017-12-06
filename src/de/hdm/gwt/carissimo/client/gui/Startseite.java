package de.hdm.gwt.carissimo.client.gui;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;

public class Startseite implements EntryPoint {
	
	public void onModuleLoad() {
		
		/*
		 * Hier wird das Men� f�r die Startseite erstellt, hierzu wird ein <code>HorizontalPanel navigationPanel</code> angelegt.
		 */
		HorizontalPanel navigationPanel = new HorizontalPanel();
		
		/*
		 * Das <code>navigationPanel</code> wird der <code>id="nav"</code> in der Datei Carissimo.html zugeordnet.
		  */
		RootPanel.get("nav").add(navigationPanel);
		
		/*
		 * Hier wird ein Button f�r das Men� erstellt, hierzu wird ein <code>Button homeButton = new Button("Home")</code> angelegt.
		 */
		Button homeButton = new Button("Home");
		
		/*
		 * Dem Button wird eine CSS Klasse hinzugef�gt, mit welcher man den Button mit Styles versehen kann.
		 */
		homeButton.setStylePrimaryName("navigatonButton");
		
		/*
		 * Der Button wird dem navigationPanel hinzugef�gt.
		 */
		navigationPanel.add(homeButton);
	}

}
