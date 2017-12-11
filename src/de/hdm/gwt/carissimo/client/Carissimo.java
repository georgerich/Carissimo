package de.hdm.gwt.carissimo.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.gwt.carissimo.client.gui.HauptAnsicht;
import de.hdm.gwt.carissimo.shared.EditorServiceAsync;
import de.hdm.gwt.carissimo.shared.LoginInfo;
import de.hdm.gwt.carissimo.shared.LoginService;
import de.hdm.gwt.carissimo.shared.LoginServiceAsync;

public class Carissimo implements EntryPoint {
	
	EditorServiceAsync editorVerwaltung = ClientsideSettings.getEditorVerwaltung();
	
	private VerticalPanel loginPanel = new VerticalPanel();
	private VerticalPanel mainPanel = new VerticalPanel();
	
	// Text für die Anmeldung (Log-In)
	private Label loginLabel = new Label(
	"Bitte melde dich mit einem Google Account ein");
	
	// Für die An- und Abmeldung
	private LoginInfo loginInfo = null;
	private Anchor signInLink = new Anchor("Einloggen");
	private Anchor signOutLink = new Anchor("Ausloggen");
	private Button logInButton = new Button("Log-In");
	private Button logOutButton = new Button("Log-Out");
	
	

	/**
	 * Da diese Klasse die Implementierung des Interface <code>EntryPoint</code>
	 * zusichert, benÃ¶tigen wir eine Methode
	 * <code>public void onModuleLoad()</code>. Diese ist das GWT-Pendant der
	 * <code>main()</code>-Methode normaler Java-Applikationen.
	 */
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
			  RootPanel.get().add(loginPanel);
			  }
		  
			private void carissimo() {
				
				HauptAnsicht seite = new HauptAnsicht ();
				RootPanel.get().add(seite);

		}

}








