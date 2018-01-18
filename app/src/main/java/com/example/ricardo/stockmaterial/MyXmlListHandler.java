package com.example.ricardo.stockmaterial;

import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

/**
 * Created by Ricardo on 16/01/2018.
 */

public class MyXmlListHandler<E> extends DefaultHandler {
    protected List<E> osElementos;
    public List<E> obterElementos() {
        return osElementos;
    }
}