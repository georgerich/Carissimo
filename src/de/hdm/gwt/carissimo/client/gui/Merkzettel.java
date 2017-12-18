package de.hdm.gwt.carissimo.client.gui;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Merkzettel extends Composite {
	
	private VerticalPanel vPanel = new VerticalPanel ();
	
	ProfilAnsehenVomMerkzettel showProfil = new ProfilAnsehenVomMerkzettel();

	
	public Merkzettel (){
		
		initWidget(this.vPanel);
		
				
			FlexTable merkzettelTabelle = new FlexTable();
		
		
		Label vorname = new Label ("Vorname"); //Vorläufig, im später sollen die Daten per getter geholt werden
		Label nachname = new Label ("Nachname");
		Label eigenschaften = new Label ("Eigenschaften:");
		Label raucher = new Label ("Eigenschaften:");
		Label hobbys = new Label ("Hobbys:");
		Label koerpergroesse = new Label ("Körpergröße:");
		Label antwort = new Label ("Antwort");
		
		Button ProfilAnsehenVomMerkzettel = new Button("Profil ansehen");
		Button ProfilEntfernen = new Button("Profil entfernen");
		
		
		merkzettelTabelle.setWidget(1, 0, vorname);
		merkzettelTabelle.setWidget(2, 0, nachname);
		merkzettelTabelle.setWidget(3, 0, eigenschaften);
		merkzettelTabelle.setWidget(4, 0, raucher);
		merkzettelTabelle.setWidget(5, 0, hobbys);
		merkzettelTabelle.setWidget(6, 0, koerpergroesse);
		
		merkzettelTabelle.setWidget(7, 0, ProfilAnsehenVomMerkzettel);
		merkzettelTabelle.setWidget(7, 1, ProfilEntfernen);
	
		this.vPanel.add(merkzettelTabelle);
		
//--------------------------------------------------------------		

		vPanel.add(ProfilAnsehenVomMerkzettel);
		
		vPanel.add(ProfilEntfernen);		
		
//-------------------------------------------------------------		
		
		ProfilAnsehenVomMerkzettel.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				ladeProfilAnsehenVomMerkzettel();
				
			}
		});
		
		ProfilEntfernen.addClickHandler(new ClickHandler() {
	         @Override
	         public void onClick(ClickEvent event) {

	        	 
	        	MerkzettelDialog merkzettelDialog = new MerkzettelDialog();

	            int left = Window.getClientWidth()/ 2;
	            int top = Window.getClientHeight()/ 2;
	            merkzettelDialog.setPopupPosition(left, top);
	            merkzettelDialog.show();				
	         }
	      });
		

		      
		   }

	 private static class MerkzettelDialog extends DialogBox {

	      public MerkzettelDialog() {

	    	 setText("Möchtest du dieses Profil vom Merkzettel entfernen?");

	    	 setAnimationEnabled(true);

	         setGlassEnabled(true);

	         Button ja = new Button("Ja");
	         ja.addClickHandler(new ClickHandler() {
	            public void onClick(ClickEvent event) {
	            MerkzettelDialog.this.hide();
	            }   
	         });
	         
	         Button nein = new Button ("Nein");
	         nein.addClickHandler(new ClickHandler() {
	            public void onClick(ClickEvent event) {
	            MerkzettelDialog.this.hide();
	            }   
	         });
	         
	         

	         VerticalPanel panel = new VerticalPanel();
	         panel.setHeight("100");
	         panel.setWidth("300");
	         panel.setSpacing(10);
	         panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	         panel.add(ja);
	         panel.add(nein);
	         setWidget(panel);

	}
	      
	 }
	 
		public void ladeProfilAnsehenVomMerkzettel(){
			this.vPanel.clear();
			this.vPanel.add(showProfil);
				
		}
	 
			

}
