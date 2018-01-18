package com.example.ricardo.stockmaterial;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;

/**
 * Created by Ricardo on 16/01/2018.
 */

public class SaxXmlMaterialHandler extends MyXmlListHandler<Material> {
    private String tempValue;
    private Material tempMateriais;

    public SaxXmlMaterialHandler() {
        osElementos = new ArrayList<Material>();
    }

    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) throws SAXException {
        tempValue = "";
        if (qName.equalsIgnoreCase("Material"))
            tempMateriais = new Material();


    }
    @Override
    public void characters(char[] ch, int start, int end) {
        tempValue = new String(ch, start, end);
    }
    @Override
    public void endElement(String uri, String localName,
                           String qName) throws SAXException {
        if (qName.equalsIgnoreCase("Material")) {
            tempMateriais.setMaterial(tempValue);
            osElementos.add(tempMateriais);
        }
    }
}
