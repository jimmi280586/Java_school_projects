/**
 * IServerSaughterHouseMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package java_t2.service.skeleton;


/**
 *  IServerSaughterHouseMessageReceiverInOut message receiver
 */
public class IServerSaughterHouseMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver {
    public void invokeBusinessLogic(
        org.apache.axis2.context.MessageContext msgContext,
        org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault {
        try {
            // get the implementation class for the Web Service
            Object obj = getTheImplementationObject(msgContext);

            IServerSaughterHouseSkeletonInterface skel = (IServerSaughterHouseSkeletonInterface) obj;

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
                if ("recallPack".equals(methodName)) {
                    java_t2.service.RecallPackResponse recallPackResponse51 = null;
                    java_t2.service.RecallPack wrappedParam = (java_t2.service.RecallPack) fromOM(msgContext.getEnvelope()
                                                                                                            .getBody()
                                                                                                            .getFirstElement(),
                            java_t2.service.RecallPack.class);

                    recallPackResponse51 = skel.recallPack(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            recallPackResponse51, false,
                            new javax.xml.namespace.QName(
                                "http://Service.java_t2", "recallPackResponse"));
                } else
                 if ("getAnimal".equals(methodName)) {
                    java_t2.service.GetAnimalResponse getAnimalResponse53 = null;
                    java_t2.service.GetAnimal wrappedParam = (java_t2.service.GetAnimal) fromOM(msgContext.getEnvelope()
                                                                                                          .getBody()
                                                                                                          .getFirstElement(),
                            java_t2.service.GetAnimal.class);

                    getAnimalResponse53 = skel.getAnimal(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            getAnimalResponse53, false,
                            new javax.xml.namespace.QName(
                                "http://Service.java_t2", "getAnimalResponse"));
                } else
                 if ("getPart".equals(methodName)) {
                    java_t2.service.GetPartResponse getPartResponse55 = null;
                    java_t2.service.GetPart wrappedParam = (java_t2.service.GetPart) fromOM(msgContext.getEnvelope()
                                                                                                      .getBody()
                                                                                                      .getFirstElement(),
                            java_t2.service.GetPart.class);

                    getPartResponse55 = skel.getPart(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            getPartResponse55, false,
                            new javax.xml.namespace.QName(
                                "http://Service.java_t2", "getPartResponse"));
                } else
                 if ("getTray".equals(methodName)) {
                    java_t2.service.GetTrayResponse getTrayResponse57 = null;
                    java_t2.service.GetTray wrappedParam = (java_t2.service.GetTray) fromOM(msgContext.getEnvelope()
                                                                                                      .getBody()
                                                                                                      .getFirstElement(),
                            java_t2.service.GetTray.class);

                    getTrayResponse57 = skel.getTray(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            getTrayResponse57, false,
                            new javax.xml.namespace.QName(
                                "http://Service.java_t2", "getTrayResponse"));
                } else
                 if ("makeOrder".equals(methodName)) {
                    java_t2.service.MakeOrderResponse makeOrderResponse59 = null;
                    java_t2.service.MakeOrder wrappedParam = (java_t2.service.MakeOrder) fromOM(msgContext.getEnvelope()
                                                                                                          .getBody()
                                                                                                          .getFirstElement(),
                            java_t2.service.MakeOrder.class);

                    makeOrderResponse59 = skel.makeOrder(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            makeOrderResponse59, false,
                            new javax.xml.namespace.QName(
                                "http://Service.java_t2", "makeOrderResponse"));
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
        java_t2.service.RecallPack param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(java_t2.service.RecallPack.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        java_t2.service.RecallPackResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(java_t2.service.RecallPackResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        java_t2.service.AddAnimal param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(java_t2.service.AddAnimal.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        java_t2.service.AddToTray param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(java_t2.service.AddToTray.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        java_t2.service.GetAnimal param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(java_t2.service.GetAnimal.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        java_t2.service.GetAnimalResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(java_t2.service.GetAnimalResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(java_t2.service.AddTray param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(java_t2.service.AddTray.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(java_t2.service.AddPart param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(java_t2.service.AddPart.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(java_t2.service.GetPart param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(java_t2.service.GetPart.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        java_t2.service.GetPartResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(java_t2.service.GetPartResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(java_t2.service.GetTray param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(java_t2.service.GetTray.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        java_t2.service.GetTrayResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(java_t2.service.GetTrayResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(java_t2.service.AddOrder param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(java_t2.service.AddOrder.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        java_t2.service.MakeOrder param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(java_t2.service.MakeOrder.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        java_t2.service.MakeOrderResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(java_t2.service.MakeOrderResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        java_t2.service.RecallPackResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    java_t2.service.RecallPackResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private java_t2.service.RecallPackResponse wraprecallPack() {
        java_t2.service.RecallPackResponse wrappedElement = new java_t2.service.RecallPackResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        java_t2.service.GetAnimalResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    java_t2.service.GetAnimalResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private java_t2.service.GetAnimalResponse wrapgetAnimal() {
        java_t2.service.GetAnimalResponse wrappedElement = new java_t2.service.GetAnimalResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        java_t2.service.GetPartResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    java_t2.service.GetPartResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private java_t2.service.GetPartResponse wrapgetPart() {
        java_t2.service.GetPartResponse wrappedElement = new java_t2.service.GetPartResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        java_t2.service.GetTrayResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    java_t2.service.GetTrayResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private java_t2.service.GetTrayResponse wrapgetTray() {
        java_t2.service.GetTrayResponse wrappedElement = new java_t2.service.GetTrayResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        java_t2.service.MakeOrderResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    java_t2.service.MakeOrderResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private java_t2.service.MakeOrderResponse wrapmakeOrder() {
        java_t2.service.MakeOrderResponse wrappedElement = new java_t2.service.MakeOrderResponse();

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
            if (java_t2.service.AddAnimal.class.equals(type)) {
                return java_t2.service.AddAnimal.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (java_t2.service.AddOrder.class.equals(type)) {
                return java_t2.service.AddOrder.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (java_t2.service.AddPart.class.equals(type)) {
                return java_t2.service.AddPart.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (java_t2.service.AddToTray.class.equals(type)) {
                return java_t2.service.AddToTray.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (java_t2.service.AddTray.class.equals(type)) {
                return java_t2.service.AddTray.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (java_t2.service.GetAnimal.class.equals(type)) {
                return java_t2.service.GetAnimal.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (java_t2.service.GetAnimalResponse.class.equals(type)) {
                return java_t2.service.GetAnimalResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (java_t2.service.GetPart.class.equals(type)) {
                return java_t2.service.GetPart.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (java_t2.service.GetPartResponse.class.equals(type)) {
                return java_t2.service.GetPartResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (java_t2.service.GetTray.class.equals(type)) {
                return java_t2.service.GetTray.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (java_t2.service.GetTrayResponse.class.equals(type)) {
                return java_t2.service.GetTrayResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (java_t2.service.MakeOrder.class.equals(type)) {
                return java_t2.service.MakeOrder.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (java_t2.service.MakeOrderResponse.class.equals(type)) {
                return java_t2.service.MakeOrderResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (java_t2.service.RecallPack.class.equals(type)) {
                return java_t2.service.RecallPack.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (java_t2.service.RecallPackResponse.class.equals(type)) {
                return java_t2.service.RecallPackResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
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
