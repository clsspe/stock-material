package com.example.ricardo.stockmaterial;

import android.util.Log;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.StringReader;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Ricardo on 16/01/2018.
 */

public class SaxXmlParser<E, H extends MyXmlListHandler<E>> {
    H saxHandler;
    public void setHandler(H h) {
        saxHandler = h;
    }
    public List<E> parse(StringReader is) {
        List<E> listaElementos = null;
        try {
            XMLReader xmlReader =
                    SAXParserFactory.newInstance().
                            newSAXParser().getXMLReader();
            xmlReader.setContentHandler(saxHandler);
            xmlReader.parse(new InputSource(is));
            listaElementos = saxHandler.obterElementos();
        } catch (Exception e) {
            Log.d("XML", "SaxXmlParser: parse error: " + e.toString());
        }
        return listaElementos;
    }
}