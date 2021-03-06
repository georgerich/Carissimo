package de.hdm.gwt.carissimo.client.gui;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.gwt.carissimo.shared.bo.Profil;

/**
 * Klasse die zur Ansicht des Profils dient - diese zeigt die Eigenschaften bzw. das Profil an
 * @author Kevin C. Batista & Georg Erich
 *
 */

public class ProfilSeite extends Composite {
	
	HorizontalPanel hPanel = new HorizontalPanel();
	HorizontalPanel buttonsPanel = new HorizontalPanel();
	VerticalPanel vPanel = new VerticalPanel();
	
	ProfilBearbeiten profiledit = new ProfilBearbeiten();

	// Deklaration einer FlexTable um die Profilattribute anzuzeigen
	private FlexTable profilTabelle;
	
	//Instanziierung der Labels fuer die Auswahl-Eigenschaften
	Label vorname = new Label("Vorname");
	Label nachname = new Label("Nachname");
	Label geburtsdatum = new Label("Geburtsdatum");
	Label haarfarbe = new Label("Haarfarbe");
	Label koerpergroesse = new Label("k\u00F6rpergr\u00F6sse");
	Label raucher = new Label("Raucher");
	Label religion = new Label("Religion");
	Label geschlecht = new Label("Geschlecht");
	
	//Instanziierung der Labels fuer die Werte der Eigenschaften
	Label vornameValue = new Label();
	Label nachnameValue = new Label();
	Label geburtsdatumValue = new Label();
	Label haarfarbeValue = new Label();
	Label koerpergroesseValue = new Label();
	Label raucherValue = new Label();
	Label religionValue = new Label();
	Label geschlechtValue = new Label();
		
		public ProfilSeite() {
			initWidget(vPanel);

			Label begruessung = new Label ("Dies ist deine Profilseite, "
					+ " hier kannst du dein Profil bearbeiten oder loeschen");
			hPanel.add(begruessung);
			vPanel.add(hPanel);
		
					
			//Instanzzierung der FlexTable und Zuweisung der Widgets (Labels)
			this.profilTabelle = new FlexTable();
			profilTabelle.setText(0, 0, "Eigenschaft");
			profilTabelle.setText(0, 1, "Angabe");
			
			profilTabelle.setWidget(1, 0, vorname);
			profilTabelle.setWidget(1, 1, vornameValue);
			profilTabelle.setWidget(2, 0, nachname);
			profilTabelle.setWidget(2, 1, nachnameValue);
			profilTabelle.setWidget(3, 0, geburtsdatum);
			profilTabelle.setWidget(3, 1, geburtsdatumValue);
			profilTabelle.setWidget(4, 0, haarfarbe);
			profilTabelle.setWidget(4, 1, haarfarbeValue);
			profilTabelle.setWidget(5, 0, koerpergroesse);
			profilTabelle.setWidget(5, 1, koerpergroesseValue);
			profilTabelle.setWidget(6, 0, raucher);
			profilTabelle.setWidget(6, 1, raucherValue);
			profilTabelle.setWidget(7, 0, religion);
			profilTabelle.setWidget(7, 1, religionValue);
			profilTabelle.setWidget(8, 0, geschlecht);
			profilTabelle.setWidget(8, 1, geschlechtValue);
			
			profilTabelle.setCellPadding(6);
			profilTabelle.setBorderWidth(2);
			vPanel.add(profilTabelle);
			
			// Zwei Buttons um das Profil zu bearbeiten und zu loeschen
			Button ProfilBearbeiten = new Button("Profil bearbeiten");
			Button ProfilLoeschen = new Button("Profil Loeschen");
			buttonsPanel.add(ProfilBearbeiten);
			buttonsPanel.add(ProfilLoeschen);
			vPanel.add(buttonsPanel);
			
			
			ProfilBearbeiten.addClickHandler(new ClickHandler() {
				
				public void onClick(ClickEvent event) {
					ladeProfilBearbeiten();
					
				}
			});
			
			
		}
		
		
		// ------- Ende Konstruktor -------
		
		
		
		public class ProfilSeiteCallback implements AsyncCallback<Profil> {

			/**
			 * Auslesen der Eigenschaften bzw. der Business-Objects,
			 * Die Eigenschaften werden in der FlexTable den Labels zugeweisen und 
			 * auf dieser Weise angezeigt.
			 */
			public void onSuccess(Profil p) {
				vornameValue.setText(p.getVorname());
				nachnameValue.setText(p.getNachname());
				geburtsdatumValue.setText(String.valueOf(p.getGeburtsdatum()));
				haarfarbeValue.setText(p.getHaarfarbe());
				koerpergroesseValue.setText(Integer.toString(p.getKoerpergroesse()));
				raucherValue.setText(p.getRaucher());
				religionValue.setText(p.getReligion());
				geschlechtValue.setText(p.getGeschlecht());
			}

			public void onFailure(Throwable caught) {
			}
			
		}
		
	
		/**
		 * Methode die den Inhalt der Seite Profilbearbeiten l�dt
		 */
		public void ladeProfilBearbeiten(){
			this.vPanel.clear();
			this.vPanel.add(profiledit);
			
		}
		

}
