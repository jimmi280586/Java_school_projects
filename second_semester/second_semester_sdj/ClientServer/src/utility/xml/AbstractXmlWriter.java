package utility.xml;


import java.io.StringWriter;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public abstract class AbstractXmlWriter<Model> implements IXmlWriter<Model>
{
	private Document doc;

	   public AbstractXmlWriter() throws ParserConfigurationException,
	         TransformerException
	   {
	      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	      doc = docBuilder.newDocument();
	   }

	   @Override
	   public void toXml(Model model, String filename) throws TransformerException,
	         ParserConfigurationException
	   {
	      Element rootElement = createXmlFromModel(model);

	      while (doc.hasChildNodes())
	         doc.removeChild(doc.getFirstChild());

	      doc.appendChild(rootElement);

	      TransformerFactory transformerFactory = TransformerFactory.newInstance();
	      Transformer transformer = transformerFactory.newTransformer();
	      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	      DOMSource source = new DOMSource(doc);

	      if (!filename.toLowerCase().endsWith(".xml"))
	         filename += ".xml";
	      File file = new File(filename);
	      StreamResult resultForFile = new StreamResult(file);
	      transformer.transform(source, resultForFile);
	      System.out.println("File created:" + file.getAbsolutePath());
	   }

	   @Override
	   public String toXml(Model model, boolean includeHeader)
	         throws TransformerException, ParserConfigurationException
	   {
	      Element rootElement = createXmlFromModel(model);

	      while (doc.hasChildNodes())
	         doc.removeChild(doc.getFirstChild());

	      doc.appendChild(rootElement);

	      TransformerFactory transformerFactory = TransformerFactory.newInstance();
	      Transformer transformer = transformerFactory.newTransformer();
	      if (!includeHeader)
	         transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
	      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	      DOMSource source = new DOMSource(doc);

	      StringWriter sw = new StringWriter();
	      StreamResult resultForStrings = new StreamResult(sw);
	      transformer.transform(source, resultForStrings);
	      String xmlString = sw.toString();

	      return xmlString;
	   }

	   public Element createElement(String tagName)
	   {
	      Element element = doc.createElement(tagName);
	      return element;
	   }

	   public Element createElement(String tagName, Object value)
	   {
	      Element element = doc.createElement(tagName);
	      element.appendChild(doc.createTextNode("" + value));
	      return element;
	   }

	   public Element createElement(String tagName, String[] subTagNames,
	         Object[] values)
	   {
	      Element element = doc.createElement(tagName);

	      for (int i = 0; i < subTagNames.length; i++)
	      {
	         if (values[i] != null)
	         {
	            Element subElement;
	            if (values[i] instanceof Element)
	            {
	               subElement = (Element) values[i];
	            }
	            else
	            {
	               subElement = createElement(subTagNames[i], values[i]);
	            }
	            element.appendChild(subElement);
	         }
	      }
	      return element;
	   }

	
}
