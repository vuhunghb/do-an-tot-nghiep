package com.irestads.client;

import java.util.Vector;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.widget.TextView;

import com.irestads.MainActivity;
import com.irestads.R;
import com.irestads.marshal.MarshalLong;

public class VersionConnect {

 public String callTestService(){
	 
		SoapObject request = new SoapObject(MainActivity.NAMESPACE, MainActivity.METHOD_NAME);

		/*
		 * Create a org.ksoap2.serialization.PropertyInfo object to contain
		 * property information to be sent with the SOAP method call. Each
		 * property requires a new PropertyInfo object. The hello method takes
		 * only 1 argument for a name. Set the property name as "arg0", and
		 * specify the type of the property as STRING_CLASS. Add the
		 * PropertyInfo object to the SoapObject using the addProperty method.
		 * 
		 * PropertyInfo propInfo=new PropertyInfo(); propInfo.name="arg0";
		 * propInfo.type=PropertyInfo.STRING_CLASS;
		 * request.addProperty(propInfo, "John Smith");
		 */
		//
		// PropertyInfo propInfo = new PropertyInfo();
		// propInfo.setName("lopId");
		// propInfo.setType(PropertyInfo.LONG_CLASS);
		Long id = new Long(1);
		// propInfo.setValue(id);

		request.addProperty("lopID", new Long(1));
		// request.addProperty(propInfo);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.setOutputSoapObject(request);

		HttpTransportSE androidHttpTransport = new HttpTransportSE(MainActivity.URL);
		String resultsRequestSOAP = "";
		try {
			androidHttpTransport.call(MainActivity.NAMESPACE + "/" + MainActivity.METHOD_NAME, envelope);

			// SoapPrimitive resultsRequestSOAP = (SoapPrimitive) envelope
			// .getResponse();

			java.util.Vector<SoapObject> response = (java.util.Vector<SoapObject>) envelope
					.getResponse();
			Vector<SoapObject> rs = response;
			if (rs != null) {
				for (SoapObject cs : rs) {
					resultsRequestSOAP = resultsRequestSOAP + "0 : "
							+ cs.getProperty("diaChi").toString(); // ok
					resultsRequestSOAP = resultsRequestSOAP + "2 : "
							+ cs.getProperty("mssv").toString();
					resultsRequestSOAP = resultsRequestSOAP + "\n";
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultsRequestSOAP;
 }
}
