package de.hdm.gwt.carissimo.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
/**
 * Klasse die zur Ansicht für die Profilbearbeitung dient
 * @author Kevin C. Batista
 */
public class ProfilBearbeiten extends Composite {
	
	VerticalPanel vPanel = new VerticalPanel();

	public ProfilBearbeiten(){
		initWidget(vPanel);

		Label label = new Label("Du befindest dich hier bei: Profil bearbeiten");
		vPanel.add(label);

	}
	

	
	
	
	
}
