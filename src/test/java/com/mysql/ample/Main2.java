package com.mysql.ample;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

public class Main2 {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        String sidXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +
                "<response>\r\n" +
                "    <sid>1582685604.259640_4EE7AB80-D0AB-4839-925E-ED138B0E38DF</sid>\r\n" +
                "</response>";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(sidXml)));

        /**
         * 这里不同
         */
        NodeList sList = doc.getElementsByTagName("sid");
        /**
         *
         */
        if (sList != null) {
            for (int i = 0; i < sList.getLength(); i++) {
                Node node = sList.item(i);
                System.out.println("节点=" + node.getNodeName() + "\ttext="
                        + node.getFirstChild().getNodeValue());
            }
        }

        /**
         * 这里不同
         */
        Element message = doc.getDocumentElement();
        NodeList list = message.getChildNodes();
        /**
         *
         */
        if (list != null) {
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                System.out.println("节点=" + node.getNodeName() + "\ttext="
                        + node.getFirstChild().getNodeValue());
            }
        }
    }

}
