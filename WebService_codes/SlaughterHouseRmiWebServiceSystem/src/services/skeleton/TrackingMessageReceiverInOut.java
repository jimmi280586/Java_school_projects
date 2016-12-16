/**
 * TrackingMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package services.skeleton;


/**
 *  TrackingMessageReceiverInOut message receiver
 */
public class TrackingMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver {
    public void invokeBusinessLogic(
        org.apache.axis2.context.MessageContext msgContext,
        org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault {
        try {
            // get the implementation class for the Web Service
            Object obj = getTheImplementationObject(msgContext);

            TrackingSkeletonInterface skel = (TrackingSkeletonInterface) obj;

            //Out Envelop
            org.apache.axiom.soap.SOAPEnvelope envelope = null;

            //Find the axisOperation that has been set by the Dispatch phase.
            org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext()
                                                                      .getAxisOperation();

            if (op == null) {
                throw new org.apache.axis2.AxisFault(
                    "Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
            }

            java.lang.String methodName;

            if ((op.getName() != null) &&
                    ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(
                            op.getName().getLocalPart())) != null)) {
                if ("trackAnimal".equals(methodName)) {
                    services.TrackAnimalResponse trackAnimalResponse19 = null;
                    services.TrackAnimal wrappedParam = (services.TrackAnimal) fromOM(msgContext.getEnvelope()
                                                                                                .getBody()
                                                                                                .getFirstElement(),
                            services.TrackAnimal.class);

                    trackAnimalResponse19 = skel.trackAnimal(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            trackAnimalResponse19, false,
                            new javax.xml.namespace.QName("http://services",
                                "trackAnimalResponse"));
                } else
                 if ("getAnimals".equals(methodName)) {
                    services.GetAnimalsResponse getAnimalsResponse21 = null;
                    services.GetAnimals wrappedParam = (services.GetAnimals) fromOM(msgContext.getEnvelope()
                                                                                              .getBody()
                                                                                              .getFirstElement(),
                            services.GetAnimals.class);

                    getAnimalsResponse21 = skel.getAnimals(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            getAnimalsResponse21, false,
                            new javax.xml.namespace.QName("http://services",
                                "getAnimalsResponse"));
                } else
                 if ("trackProduct".equals(methodName)) {
                    services.TrackProductResponse trackProductResponse23 = null;
                    services.TrackProduct wrappedParam = (services.TrackProduct) fromOM(msgContext.getEnvelope()
                                                                                                  .getBody()
                                                                                                  .getFirstElement(),
                            services.TrackProduct.class);

                    trackProductResponse23 = skel.trackProduct(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            trackProductResponse23, false,
                            new javax.xml.namespace.QName("http://services",
                                "trackProductResponse"));
                } else {
                    throw new java.lang.RuntimeException("method not found");
                }

                newMsgContext.setEnvelope(envelope);
            }
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    //
    private org.apache.axiom.om.OMElement toOM(services.TrackAnimal param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(services.TrackAnimal.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        services.TrackAnimalResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(services.TrackAnimalResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(services.GetAnimals param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(services.GetAnimals.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        services.GetAnimalsResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(services.GetAnimalsResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(services.TrackProduct param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(services.TrackProduct.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        services.TrackProductResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(services.TrackProductResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        services.TrackAnimalResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    services.TrackAnimalResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private services.TrackAnimalResponse wraptrackAnimal() {
        services.TrackAnimalResponse wrappedElement = new services.TrackAnimalResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        services.GetAnimalsResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    services.GetAnimalsResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private services.GetAnimalsResponse wrapgetAnimals() {
        services.GetAnimalsResponse wrappedElement = new services.GetAnimalsResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        services.TrackProductResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    services.TrackProductResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private services.TrackProductResponse wraptrackProduct() {
        services.TrackProductResponse wrappedElement = new services.TrackProductResponse();

        return wrappedElement;
    }

    /**
     *  get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    private java.lang.Object fromOM(org.apache.axiom.om.OMElement param,
        java.lang.Class type) throws org.apache.axis2.AxisFault {
        try {
            if (services.GetAnimals.class.equals(type)) {
                return services.GetAnimals.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (services.GetAnimalsResponse.class.equals(type)) {
                return services.GetAnimalsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (services.TrackAnimal.class.equals(type)) {
                return services.TrackAnimal.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (services.TrackAnimalResponse.class.equals(type)) {
                return services.TrackAnimalResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (services.TrackProduct.class.equals(type)) {
                return services.TrackProduct.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (services.TrackProductResponse.class.equals(type)) {
                return services.TrackProductResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

        return null;
    }

    private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();

        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }
} //end of class
