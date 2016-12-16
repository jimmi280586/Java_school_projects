/**
 * TrackingMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.1  Built on : Feb 20, 2016 (10:01:29 GMT)
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
                if ("getAnimals".equals(methodName)) {
                    services.GetAnimalsResponse getAnimalsResponse19 =
                        null;
        services.GetAnimals wrappedParam = (services.GetAnimals) fromOM(msgContext.getEnvelope()
                                                                                                                                  .getBody()
                                                                                                                                  .getFirstElement(),
                            services.GetAnimals.class);

                    getAnimalsResponse19 = skel.getAnimals(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            getAnimalsResponse19, false,
                            new javax.xml.namespace.QName(
                                "http://services.slaughterhouse.dk",
                                "getAnimalsResponse"));
                } else
                 if ("trackAnimal".equals(methodName)) {
                    services.TrackAnimalResponse trackAnimalResponse21 =
                        null;
                    services.TrackAnimal wrappedParam = (services.TrackAnimal) fromOM(msgContext.getEnvelope()
                                                                                                                                    .getBody()
                                                                                                                                    .getFirstElement(),
                            services.TrackAnimal.class);

                    trackAnimalResponse21 = skel.trackAnimal(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            trackAnimalResponse21, false,
                            new javax.xml.namespace.QName(
                                "http://services.slaughterhouse.dk",
                                "trackAnimalResponse"));
                } else
                 if ("trackProduct".equals(methodName)) {
                    services.TrackProductResponse trackProductResponse23 =
                        null;
                    services.TrackProduct wrappedParam = (services.TrackProduct) fromOM(msgContext.getEnvelope()
                                                                                                                                      .getBody()
                                                                                                                                      .getFirstElement(),
                            services.TrackProduct.class);

                    trackProductResponse23 = skel.trackProduct(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            trackProductResponse23, false,
                            new javax.xml.namespace.QName(
                                "http://services.slaughterhouse.dk",
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
    private org.apache.axiom.om.OMElement toOM(
        dk.slaughterhouse.services.GetAnimals param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(services.GetAnimals.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        dk.slaughterhouse.services.GetAnimalsResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(services.GetAnimalsResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        dk.slaughterhouse.services.TrackAnimal param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(dk.slaughterhouse.services.TrackAnimal.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        dk.slaughterhouse.services.TrackAnimalResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(dk.slaughterhouse.services.TrackAnimalResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        dk.slaughterhouse.services.TrackProduct param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(dk.slaughterhouse.services.TrackProduct.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        dk.slaughterhouse.services.TrackProductResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(dk.slaughterhouse.services.TrackProductResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        dk.slaughterhouse.services.GetAnimalsResponse param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    dk.slaughterhouse.services.GetAnimalsResponse.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private dk.slaughterhouse.services.GetAnimalsResponse wrapgetAnimals() {
        dk.slaughterhouse.services.GetAnimalsResponse wrappedElement = new dk.slaughterhouse.services.GetAnimalsResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        dk.slaughterhouse.services.TrackAnimalResponse param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    dk.slaughterhouse.services.TrackAnimalResponse.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private dk.slaughterhouse.services.TrackAnimalResponse wraptrackAnimal() {
        dk.slaughterhouse.services.TrackAnimalResponse wrappedElement = new dk.slaughterhouse.services.TrackAnimalResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        dk.slaughterhouse.services.TrackProductResponse param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    dk.slaughterhouse.services.TrackProductResponse.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private dk.slaughterhouse.services.TrackProductResponse wraptrackProduct() {
        dk.slaughterhouse.services.TrackProductResponse wrappedElement = new dk.slaughterhouse.services.TrackProductResponse();

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
            if (dk.slaughterhouse.services.GetAnimals.class.equals(type)) {
                return dk.slaughterhouse.services.GetAnimals.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (dk.slaughterhouse.services.GetAnimalsResponse.class.equals(type)) {
                return dk.slaughterhouse.services.GetAnimalsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (dk.slaughterhouse.services.TrackAnimal.class.equals(type)) {
                return dk.slaughterhouse.services.TrackAnimal.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (dk.slaughterhouse.services.TrackAnimalResponse.class.equals(
                        type)) {
                return dk.slaughterhouse.services.TrackAnimalResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (dk.slaughterhouse.services.TrackProduct.class.equals(type)) {
                return dk.slaughterhouse.services.TrackProduct.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (dk.slaughterhouse.services.TrackProductResponse.class.equals(
                        type)) {
                return dk.slaughterhouse.services.TrackProductResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
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
