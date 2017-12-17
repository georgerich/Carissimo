package de.hdm.gwt.carissimo.client.gui;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.gwt.carissimo.shared.bo.Profil;
/**
 * Klasse die zur Ansicht für die Profilbearbeitung dient
 * @author Kevin C. Batista
 */
public class ProfilBearbeiten extends Composite {
	
	VerticalPanel vPanel = new VerticalPanel();
	
	// Deklaration einer FlexTable um die Profilattribute anzuzeigen
		private FlexTable profilBearbeitungsTabelle;
		
		//Instanziierung der Labels fuer die Auswahl-Eigenschaften
		Label vorname = new Label("Vorname");
		Label nachname = new Label("Nachname");
		Label geburtsdatum = new Label("Geburtsdatum");
		Label haarfarbe = new Label("Haarfarbe");
		Label koerpergroesse = new Label("K\u00F6rpergroesse");
		Label raucher = new Label("Raucher");
		Label religion = new Label("Religion");
		Label geschlecht = new Label("Geschlecht");
		
		/**
		 * Instanziierung der Labels fuer die Werte der Eigenschaften
		 */
		TextBox vornameTextBox = new TextBox();
		TextBox nachnameTextBox = new TextBox();
		
		// Wird noch ersetzt durch ein DatePicker
		TextBox geburtsdatumtextBox = new TextBox();
		
		//Buttons fuer die Auswahl der Haarfarbe
		RadioButton haarfarbeRadioButton1 = new RadioButton("geschlechtsButton", "blond");
		RadioButton haarfarbeRadioButton2 = new RadioButton("geschlechtsButton", "braun");
		RadioButton haarfarbeRadioButton3 = new RadioButton("geschlechtsButton", "schwarz");
		RadioButton haarfarbeRadioButton4 = new RadioButton("geschlechtsButton", "grau");
		RadioButton haarfarbeRadioButton5 = new RadioButton("geschlechtsButton", "rot");
		FlowPanel haarfarbeRadioButtonPanel = new FlowPanel();
		
		
		TextBox koerpergroesseTextBox = new TextBox();
	
		
		// Buttons fuer die Auswahl der Raucherangabe
		RadioButton raucherRadioButton1 = new RadioButton("geschlechtsButton", "nein");
		RadioButton raucherRadioButton2 = new RadioButton("geschlechtsButton", "ja");
		RadioButton raucherRadioButton3 = new RadioButton("geschlechtsButton", "gelegentlich");
		FlowPanel raucherRadioButtonPanel = new FlowPanel();
		
		// Buttons fuer die Auswahl des Geschlechts
		RadioButton geschlechtRadioButton1 = new RadioButton("geschlechtsButton", "m\u00E4nnlich");
		RadioButton geschlechtRadioButton2 = new RadioButton("geschlechtsButton", "weiblich");
		RadioButton geschlechtRadioButton3 = new RadioButton("geschlechtsButton", "transgender");
		FlowPanel geschlechtRadioButtonPanel = new FlowPanel();
		
		//Buttons fuer die Angabe der Religionszugehörigkeit
		RadioButton religionRadioButton1 = new RadioButton("geschlechtsButton", "Christentum");
		RadioButton religionRadioButton2 = new RadioButton("geschlechtsButton", "Islam");
		RadioButton religionRadioButton3 = new RadioButton("geschlechtsButton", "Buddhismus");
		RadioButton religionRadioButton4 = new RadioButton("geschlechtsButton", "Hinduismus");
		RadioButton religionRadioButton5 = new RadioButton("geschlechtsButton", "Zeugen Jehovas");
		RadioButton religionRadioButton6 = new RadioButton("geschlechtsButton", "Atheismus ");
		RadioButton religionRadioButton7 = new RadioButton("geschlechtsButton", "sonstige ");
		FlowPanel religionRadioButtonPanel = new FlowPanel();
		

	

	public ProfilBearbeiten(){
		initWidget(vPanel);

		Label label = new Label("Du befindest dich hier bei: Profil bearbeiten");
		vPanel.add(label);
		
		/**
		 * Buttons werden dem zugehörigen Panel zugeweisen
		 */
		haarfarbeRadioButtonPanel.add(haarfarbeRadioButton1);
		haarfarbeRadioButtonPanel.add(haarfarbeRadioButton2);
		haarfarbeRadioButtonPanel.add(geschlechtRadioButton3);
		haarfarbeRadioButtonPanel.add(haarfarbeRadioButton4);
		haarfarbeRadioButtonPanel.add(haarfarbeRadioButton5);
		
		raucherRadioButtonPanel.add(raucherRadioButton1);
		raucherRadioButtonPanel.add(raucherRadioButton2);
		raucherRadioButtonPanel.add(raucherRadioButton3);
		
		religionRadioButtonPanel.add(religionRadioButton1);
		religionRadioButtonPanel.add(religionRadioButton2);
		religionRadioButtonPanel.add(religionRadioButton3);
		religionRadioButtonPanel.add(religionRadioButton4);
		religionRadioButtonPanel.add(religionRadioButton5);
		religionRadioButtonPanel.add(religionRadioButton6);
		religionRadioButtonPanel.add(religionRadioButton7);
		
		geschlechtRadioButtonPanel.add(geschlechtRadioButton1);
		geschlechtRadioButtonPanel.add(geschlechtRadioButton2);
		geschlechtRadioButtonPanel.add(geschlechtRadioButton3);
		
		/**
		 * Instanzzierung der FlexTable und Zuweisung der Widgets (Labels)
		 */
		this.profilBearbeitungsTabelle = new FlexTable();
		profilBearbeitungsTabelle.setText(0, 0, "Eigenschaft");
		profilBearbeitungsTabelle.setText(0, 1, "Angabe");
		
		profilBearbeitungsTabelle.setWidget(1, 0, vorname);
		profilBearbeitungsTabelle.setWidget(1, 1, vornameTextBox);
		profilBearbeitungsTabelle.setWidget(2, 0, nachname);
		profilBearbeitungsTabelle.setWidget(2, 1, nachnameTextBox);
		profilBearbeitungsTabelle.setWidget(3, 0, geburtsdatum);
		profilBearbeitungsTabelle.setWidget(3, 1, geburtsdatumtextBox);
		profilBearbeitungsTabelle.setWidget(4, 0, haarfarbe);
		profilBearbeitungsTabelle.setWidget(4, 1, haarfarbeRadioButtonPanel);
		profilBearbeitungsTabelle.setWidget(5, 0, koerpergroesse);
		profilBearbeitungsTabelle.setWidget(5, 1, koerpergroesseTextBox);
		profilBearbeitungsTabelle.setWidget(6, 0, raucher);
		profilBearbeitungsTabelle.setWidget(6, 1, raucherRadioButtonPanel);
		profilBearbeitungsTabelle.setWidget(7, 0, religion);
		profilBearbeitungsTabelle.setWidget(7, 1, religionRadioButtonPanel);
		profilBearbeitungsTabelle.setWidget(8, 0, geschlecht);
		profilBearbeitungsTabelle.setWidget(8, 1, geschlechtRadioButtonPanel);
		

		/**
		 * Die Bearbeitungstabelle für das Profil wird dem Panel zugewiesen
		 */
		profilBearbeitungsTabelle.setCellPadding(6);
		profilBearbeitungsTabelle.setBorderWidth(2);
		vPanel.add(profilBearbeitungsTabelle);
		


	}
	
	// ------- Ende Konstruktor -------
	
	public class ProfilSeiteCallback implements AsyncCallback<Profil> {

		/**
		 * Setzen der Eigenschaften.
		 * Die Eigenschaften werden in der FlexTable den Labels zugeweisen und 
		 * auf dieser Weise angezeigt.
		 */
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(Profil result) {
			// TODO Auto-generated method stub
			
		}
		
	}



	

	
	
	
	
}
