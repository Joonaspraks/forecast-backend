package com.yotproov.xmlConversion;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import generated.Forecasts;

public class XmlConverter {

    public Forecasts unmarshall() {
        JAXBContext jaxbContext;
        Forecasts forecast = null;
        try {
            jaxbContext = JAXBContext.newInstance(Forecasts.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            InputStream inStream = getClass().getClassLoader().getResourceAsStream("forecast.php");

            forecast = (Forecasts) jaxbUnmarshaller.unmarshal(inStream);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return forecast;
    }
}
