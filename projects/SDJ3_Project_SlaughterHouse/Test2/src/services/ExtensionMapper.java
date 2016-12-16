/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.1  Built on : Feb 20, 2016 (10:02:19 GMT)
 */
package services;


/**
 *  ExtensionMapper class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ExtensionMapper {
    public static java.lang.Object getTypeObject(
        java.lang.String namespaceURI, java.lang.String typeName,
        javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
        if ("http://model.slaughterhouse.dk/xsd".equals(namespaceURI) &&
                "Market".equals(typeName)) {
            return model.xsd.Market.Factory.parse(reader);
        }

        if ("http://model.slaughterhouse.dk/xsd".equals(namespaceURI) &&
                "Product".equals(typeName)) {
            return model.xsd.Product.Factory.parse(reader);
        }

        if ("http://model.slaughterhouse.dk/xsd".equals(namespaceURI) &&
                "Part".equals(typeName)) {
            return model.xsd.Part.Factory.parse(reader);
        }

        if ("http://model.slaughterhouse.dk/xsd".equals(namespaceURI) &&
                "Animal".equals(typeName)) {
            return model.xsd.Animal.Factory.parse(reader);
        }

        throw new org.apache.axis2.databinding.ADBException("Unsupported type " +
            namespaceURI + " " + typeName);
    }
}
