package de.hdm.gwt.carissimo.client;

import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import de.hdm.gwt.carissimo.shared.CommonSettings;
import de.hdm.gwt.carissimo.shared.EditorServiceAsync;
import de.hdm.gwt.carissimo.shared.ReportGeneratorService;
import de.hdm.gwt.carissimo.shared.ReportGeneratorServiceAsync;
import de.hdm.gwt.carissimo.shared.EditorService;

/**
 * 
 * @author thies
 * @author Georg Erich
 * @version 1.0
 * @since 03.12.2017
 *
 */

public class ClientsideSettings extends CommonSettings {
	
	  private static EditorServiceAsync editorVerwaltung = null;
	  
	  private static ReportGeneratorServiceAsync reportGenerator = null;

	  private static final String LOGGER_NAME = "Carissimo Web Client";
	  
	  private static final Logger log = Logger.getLogger(LOGGER_NAME);
	  
	  public static Logger getLogger() {
		    return log;
		  }
	  
	  public static EditorServiceAsync getEditorVerwaltung() {
		    if (editorVerwaltung == null) {
		      editorVerwaltung = GWT.create(EditorService.class);
		    }

		    return editorVerwaltung;
		  }
	  
	  public static ReportGeneratorServiceAsync getReportGenerator() {
		    if (reportGenerator == null) {
		      reportGenerator = GWT.create(ReportGeneratorService.class);

		      final AsyncCallback<Void> initReportGeneratorCallback = new AsyncCallback<Void>() {
		        @Override
				public void onFailure(Throwable caught) {
		          ClientsideSettings.getLogger().severe(
		              "Der ReportGenerator konnte nicht initialisiert werden!");
		        }

		        @Override
				public void onSuccess(Void result) {
		          ClientsideSettings.getLogger().info(
		              "Der ReportGenerator wurde initialisiert.");
		        }
		      };

		      reportGenerator.init(initReportGeneratorCallback);
		    }

		    return reportGenerator;
		  }
}
