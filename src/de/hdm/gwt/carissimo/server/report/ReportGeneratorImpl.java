package de.hdm.gwt.carissimo.server.report;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.gwt.carissimo.shared.EditorService;
import de.hdm.gwt.carissimo.shared.ReportGeneratorService;

public class ReportGeneratorImpl extends RemoteServiceServlet implements ReportGeneratorService{

	
	  private EditorService verwaltung = null;
	  
	  public ReportGeneratorImpl() throws IllegalArgumentException {
	  }

	  public void init() throws IllegalArgumentException {
	  }
}
