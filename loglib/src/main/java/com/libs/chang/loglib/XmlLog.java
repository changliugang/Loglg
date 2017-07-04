package com.libs.chang.loglib;

import android.util.Log;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * xml Log
 * Created by chang on 2016/4/12.
 */
public class XmlLog {

    public static void printXml(String tag, String headString, String xml) {

        if (xml != null)
            xml = headString + Loglg.LINE_SEPARATOR + formatXML(xml);
        else
            xml = headString + Loglg.NULL_TIPS;

        Util.printLine(tag, true);
        String[] lines = xml.split(Loglg.LINE_SEPARATOR);
        for (String line : lines) {
            if (!Util.isEmpty(line)) {
                Log.d(tag, "|| " + line);
            }
        }
        Util.printLine(tag, false);
    }

    public static String formatXML(String inputXml) {
        Source xmlInput = new StreamSource(new StringReader(inputXml));
        StreamResult xmlOutput = new StreamResult(new StringWriter());
        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform(xmlInput, xmlOutput);
            return xmlOutput.getWriter().toString().replaceFirst(">", ">\n");
        } catch (Exception e) {
            e.printStackTrace();
            return inputXml;
        }
    }

}
