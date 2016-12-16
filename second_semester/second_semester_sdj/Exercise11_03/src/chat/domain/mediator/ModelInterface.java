package chat.domain.mediator;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import chat.domain.model.AbstractMessage;

public interface ModelInterface
{
	public void add(AbstractMessage message) throws TransformerException, ParserConfigurationException;
}
