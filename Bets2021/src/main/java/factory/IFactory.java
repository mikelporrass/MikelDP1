package factory;

import java.net.URL;

import javax.swing.UIManager;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import configuration.ConfigXML;
import dataAccess.DataAccess;
import gui.MainGUI;

public class IFactory implements Factory {
	BLFacade appFacadeInterface;
	public BLFacade inplementazioaAukeratu(boolean b) {
	
	ConfigXML c = ConfigXML.getInstance();
	

		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			if (b) {
				DataAccess da = new DataAccess(c.getDataBaseOpenMode().equals("initialize"));
				appFacadeInterface = new BLFacadeImplementation(da);
			} else { // If remote
				String serviceName = "http://" + c.getBusinessLogicNode() + ":" + c.getBusinessLogicPort() + "/ws/"
						+ c.getBusinessLogicName() + "?wsdl";
				URL url = new URL(serviceName);
				QName qname = new QName("http://businessLogic/", "BLFacadeImplementationService");
				Service service = Service.create(url, qname);
				appFacadeInterface = service.getPort(BLFacade.class);
			}
			MainGUI.setBussinessLogic(appFacadeInterface);
		} catch (Exception e) {
			//a.jLabelSelectOption.setText("Error: " + e.toString());
			//a.jLabelSelectOption.setForeground(Color.RED);
			System.out.println("Error in ApplicationLauncher: " + e.toString());
		}
		return appFacadeInterface;

	}
}
