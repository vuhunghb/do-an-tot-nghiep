package com.irestads.marshal;

import java.io.IOException;

import org.ksoap2.serialization.Marshal;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public class MarshalLong implements Marshal {

	@Override
	public Object readInstance(XmlPullParser parser, String arg1, String arg2,
			PropertyInfo arg3) throws IOException, XmlPullParserException {
		// TODO Auto-generated method stub
		return Long.parseLong(parser.nextText());
	}

	@Override
	public void register(SoapSerializationEnvelope cm) {
		// TODO Auto-generated method stub
		 cm.addMapping(cm.xsd, "long", Long.class, this);
	}

	@Override
	public void writeInstance(XmlSerializer writer, Object obj)
			throws IOException {
		// TODO Auto-generated method stub
        writer.text(obj.toString());

	}

}
