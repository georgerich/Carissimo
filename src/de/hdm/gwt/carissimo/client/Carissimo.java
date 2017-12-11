	package de.hdm.gwt.carissimo.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.gwt.carissimo.client.gui.HauptAnsicht;
import de.hdm.gwt.carissimo.shared.EditorServiceAsync;
import de.hdm.gwt.carissimo.shared.LoginInfo;
import de.hdm.gwt.carissimo.shared.LoginService;
import de.hdm.gwt.carissimo.shared.LoginServiceAsync;


public class Carissimo implements EntryPoint {
	
	EditorServiceAsync Project4uVerwaltung = ClientsideSettings.getEditorVerwaltung();

	
	private LoginInfo loginInfo = null;
	private VerticalPanel loginPanel = new VerticalPanel();
	private Label loginLabel = new Label(
	"Bitte gebe deine Google Account ein");
	private Anchor signInLink = new Anchor("Einloggen");
	private Anchor signOutLink = new Anchor("Ausloggen");
	
	 private VerticalPanel mainPanel = new VerticalPanel();

		  public void onModuleLoad() {

			  LoginServiceAsync loginService = GWT.create(LoginService.class);
			
			loginService.login(GWT.getHostPageBaseURL(), new AsyncCallback<LoginInfo>() {
				
			public void onFailure(Throwable error) {
			}
			
			public void onSuccess(LoginInfo result) {
			loginInfo = result;
			
			if(loginInfo.isLoggedIn()) {
			carissimo();
			} 
			
			else {
				
			loadLogin();
						}
					}
				});
			}
		  
		  private void loadLogin() {

			  	signInLink.setHref(loginInfo.getLoginUrl());
				loginPanel.add(loginLabel);
				loginPanel.add(signInLink);
				RootPanel.get("content").add(loginPanel);
		  }
		  

			private void carissimo() {
				HauptAnsicht seite = new HauptAnsicht ();
				
				RootPanel.get().add(seite);

		}


}

