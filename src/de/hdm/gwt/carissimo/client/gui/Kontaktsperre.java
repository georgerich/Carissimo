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

public class Kontaktsperre extends Composite {
	
	private VerticalPanel vPanel = new VerticalPanel ();
	
	ProfilAnsehenVonKontaktsperre showProfil = new ProfilAnsehenVonKontaktsperre();
	
	public Kontaktsperre (){
		
		initWidget(this.vPanel);

		FlexTable kontaktsperreTabelle = new FlexTable();
		
		Label kontaktsperreLabel = new Label ("Hier folgen die gesperrten Profile"); 
		
		Label vorname = new Label ("Vorname"); 
		Label nachname = new Label ("Nachname");
		Label email = new Label ("Email");
		
		Button gespertesProfilAnsehen = new Button ("Profil ansehen");
		Button gespertesProfilentsperren = new Button ("Profil entsperren");
		
		kontaktsperreTabelle.setWidget(1, 0, vorname);
		kontaktsperreTabelle.setWidget(2, 0, nachname);
		kontaktsperreTabelle.setWidget(3, 0, email);
		
		kontaktsperreTabelle.setWidget(2, 1, gespertesProfilAnsehen);
		kontaktsperreTabelle.setWidget(2, 3, gespertesProfilentsperren);

		this.vPanel.add(kontaktsperreLabel);	
		this.vPanel.add(kontaktsperreTabelle);
		
		gespertesProfilAnsehen.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				ladeProfilAnsehenVonKontaktsperre();

			}
		});
		
		gespertesProfilentsperren.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
				KontaktsperreDialog kontaktsperreDialog = new KontaktsperreDialog();

	            int left = Window.getClientWidth()/ 2;
	            int top = Window.getClientHeight()/ 2;
	            kontaktsperreDialog.setPopupPosition(left, top);
	            kontaktsperreDialog.show();		
			}
		});
		
	}
	
	 private static class KontaktsperreDialog extends DialogBox {

	      public KontaktsperreDialog() {

	    	 setText("Möchtest du dieses Profil von der Kontaktsperre entfernen?");

	    	 setAnimationEnabled(true);

	         setGlassEnabled(true);

	         Button ja = new Button("Ja");
	         ja.addClickHandler(new ClickHandler() {
	            public void onClick(ClickEvent event) {
	            KontaktsperreDialog.this.hide();
	            }   
	         });
	         
	         Button nein = new Button ("Nein");
	         nein.addClickHandler(new ClickHandler() {
	            public void onClick(ClickEvent event) {
	            KontaktsperreDialog.this.hide();
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
     
	public void ladeProfilAnsehenVonKontaktsperre(){
		this.vPanel.clear();
		this.vPanel.add(showProfil);
		
			
	}

}