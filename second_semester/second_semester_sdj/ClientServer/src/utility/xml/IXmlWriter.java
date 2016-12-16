package utility.xml;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Element;

public interface IXmlWriter<Model>
{
	public Element createXmlFromModel(Model model);

	   public void toXml(Model model, String filename) throws TransformerException,
	         ParserConfigurationException;

	   public String toXml(Model model, boolean includeHeader)
	         throws TransformerException, ParserConfigurationException;

}
