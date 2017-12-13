package de.hdm.gwt.carissimo.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;


public class Eigenschaft extends Composite {
	
	private VerticalPanel vPanel = new VerticalPanel ();
	
	public Eigenschaft (){
		initWidget(this.vPanel);
		
		Button newEigenschaft = new Button("Eigenschaft hinzufügen");
		Button updateEigenschaft = new Button("Eigenschaft bearbeiten");
		Button deleteEigenschaft = new Button("Eigenschaft löschen");

		this.vPanel.add(newEigenschaft);	
		newEigenschaft.addClickHandler(new ClickHandler() {
	         @Override
	         public void onClick(ClickEvent event) {

	        	EigenschaftDialog eigenschaftDialog = new EigenschaftDialog();

	            int left = Window.getClientWidth()/ 2;
	            int top = Window.getClientHeight()/ 2;
	            eigenschaftDialog.setPopupPosition(left, top);
	            eigenschaftDialog.show();				
	         }
	      });
		this.vPanel.add(updateEigenschaft);	
		this.vPanel.add(deleteEigenschaft);	

	}
	
	   private static class EigenschaftDialog extends DialogBox {

		      public EigenschaftDialog() {

		    	  setText("Neue Eigenschaften");

		    	  setAnimationEnabled(true);

		         setGlassEnabled(true);

		         Button ok = new Button("OK");
		         ok.addClickHandler(new ClickHandler() {
		            public void onClick(ClickEvent event) {
		            EigenschaftDialog.this.hide();
		            }
		         });

		         Label label = new Label("Füge neue Eigenschaften hinzu");
		          TextBox newEigenschaftBox = new TextBox();

		         VerticalPanel panel = new VerticalPanel();
		         panel.setHeight("100");
		         panel.setWidth("300");
		         panel.setSpacing(10);
		         panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		         panel.add(label);
		         panel.add(newEigenschaftBox);
		         panel.add(ok);

		         setWidget(panel);
		      }
		   }
  }



