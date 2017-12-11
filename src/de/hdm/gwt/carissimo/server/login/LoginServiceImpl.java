package de.hdm.gwt.carissimo.server.login;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.gwt.carissimo.shared.LoginInfo;
import de.hdm.gwt.carissimo.shared.LoginService;


public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {
	
	public LoginInfo login(String requestUri) {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
			LoginInfo loginInfo = new LoginInfo();
			
				if (user != null) {
					loginInfo.setLoggedIn(true);
					loginInfo.setEmailAddress(user.getEmail());
					loginInfo.setNickname(user.getNickname());
					loginInfo.setLogoutUrl(userService.createLogoutURL(requestUri));
					} else {
						
						loginInfo.setLoggedIn(false);
						loginInfo.setLoginUrl(userService.createLoginURL(requestUri));
					}
				return loginInfo;
			}
}