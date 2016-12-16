/**
 * ISlaughterHouseMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package java_t2.service.skeleton;


/**
 *  ISlaughterHouseMessageReceiverInOut message receiver
 */
public class ISlaughterHouseMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver {
    public void invokeBusinessLogic(
        org.apache.axis2.context.MessageContext msgContext,
        org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault {
        try {
            // get the implementation class for the Web Service
            Object obj = getTheImplementationObject(msgContext);

            ISlaughterHouseSkeletonInterface skel = (ISlaughterHouseSkeletonInterface) obj;

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
                if ("addAnimal".equals(methodName)) {
                    java_t2.service.AddAnimalResponse addAnimalResponse37 = null;
                    java_t2.service.AddAnimal wrappedParam = (java_t2.service.AddAnimal) fromOM(msgContext.getEnvelope()
                                                                                                          .getBody()
                                                                                                          .getFirstElement(),
                            java_t2.service.AddAnimal.class);

                    addAnimalResponse37 = skel.addAnimal(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            addAnimalResponse37, false,
                            new javax.xml.namespace.QName(
                                "http://service.java_t2", "addAnimalResponse"));
                } else
                 if ("newTray".equals(methodName)) {
                    java_t2.service.NewTrayResponse newTrayResponse39 = null;
                    java_t2.service.NewTray wrappedParam = (java_t2.service.NewTray) fromOM(msgContext.getEnvelope()
                                                                                                      .getBody()
                                                                                                      .getFirstElement(),
                            java_t2.service.NewTray.class);

                    newTrayResponse39 = skel.newTray(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            newTrayResponse39, false,
                            new javax.xml.namespace.QName(
                                "http://service.java_t2", "newTrayResponse"));
                } else
                 if ("getTray".equals(methodName)) {
                    java_t2.service.GetTrayResponse getTrayResponse41 = null;
                    java_t2.service.GetTray wrappedParam = (java_t2.service.GetTray) fromOM(msgContext.getEnvelope()
                                                                                                      .getBody()
                                                                                                      .getFirstElement(),
                            java_t2.service.GetTray.class);

                    getTrayResponse41 = skel.getTray(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            getTrayResponse41, false,
                            new javax.xml.namespace.QName(
                                "http://service.java_t2", "getTrayResponse"));
                } else
                 if ("newPart".equals(methodName)) {
                    java_t2.service.NewPartResponse newPartResponse43 = null;
                    java_t2.service.NewPart wrappedParam = (java_t2.service.NewPart) fromOM(msgContext.getEnvelope()
                                                                                                      .getBody()
                                                                                                      .getFirstElement(),
                            java_t2.service.NewPart.class);

                    newPartResponse43 = skel.newPart(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            newPartResponse43, false,
                            new javax.xml.namespace.QName(
                                "http://service.java_t2", "newPartResponse"));
                } else
                 if ("getCurrentWeight".equals(methodName)) {
                    java_t2.service.GetCurrentWeightResponse getCurrentWeightResponse45 =
                        null;
                    java_t2.service.GetCurrentWeight wrappedParam = (java_t2.service.GetCurrentWeight) fromOM(msgContext.getEnvelope()
                                                                                                                        .getBody()
                                                                                                                        .getFirstElement(),
                            java_t2.service.GetCurrentWeight.class);

                    getCurrentWeightResponse45 = skel.getCurrentWeight(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            getCurrentWeightResponse45, false,
                            new javax.xml.namespace.QName(
                                "http://service.java_t2",
                                "getCurrentWeightResponse"));
                } else
                 if ("newOrder".equals(methodName)) {
                    java_t2.service.NewOrderResponse newOrderResponse47 = null;
                    java_t2.service.NewOrder wrappedParam = (java_t2.service.NewOrder) fromOM(msgContext.getEnvelope()
                                                                                                        .getBody()
                                                                                                        .getFirstElement(),
                            java_t2.service.NewOrder.class);

                    newOrderResponse47 = skel.newOrder(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            newOrderResponse47, false,
                            new javax.xml.namespace.QName(
                                "http://service.java_t2", "newOrderResponse"));
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
        java_t2.service.AddAnimalResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(java_t2.service.AddAnimalResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(java_t2.service.NewTray param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(java_t2.service.NewTray.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        java_t2.service.NewTrayResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(java_t2.service.NewTrayResponse.MY_QNAME,
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

    private org.apache.axiom.om.OMElement toOM(java_t2.service.NewPart param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(java_t2.service.NewPart.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        java_t2.service.NewPartResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(java_t2.service.NewPartResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        java_t2.service.GetCurrentWeight param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(java_t2.service.GetCurrentWeight.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        java_t2.service.GetCurrentWeightResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(java_t2.service.GetCurrentWeightResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(java_t2.service.NewOrder param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(java_t2.service.NewOrder.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        java_t2.service.NewOrderResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(java_t2.service.NewOrderResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        java_t2.service.AddAnimalResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    java_t2.service.AddAnimalResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private java_t2.service.AddAnimalResponse wrapaddAnimal() {
        java_t2.service.AddAnimalResponse wrappedElement = new java_t2.service.AddAnimalResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        java_t2.service.NewTrayResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    java_t2.service.NewTrayResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private java_t2.service.NewTrayResponse wrapnewTray() {
        java_t2.service.NewTrayResponse wrappedElement = new java_t2.service.NewTrayResponse();

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
        java_t2.service.NewPartResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    java_t2.service.NewPartResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private java_t2.service.NewPartResponse wrapnewPart() {
        java_t2.service.NewPartResponse wrappedElement = new java_t2.service.NewPartResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        java_t2.service.GetCurrentWeightResponse param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    java_t2.service.GetCurrentWeightResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private java_t2.service.GetCurrentWeightResponse wrapgetCurrentWeight() {
        java_t2.service.GetCurrentWeightResponse wrappedElement = new java_t2.service.GetCurrentWeightResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        java_t2.service.NewOrderResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    java_t2.service.NewOrderResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private java_t2.service.NewOrderResponse wrapnewOrder() {
        java_t2.service.NewOrderResponse wrappedElement = new java_t2.service.NewOrderResponse();

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

            if (java_t2.service.AddAnimalResponse.class.equals(type)) {
                return java_t2.service.AddAnimalResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (java_t2.service.GetCurrentWeight.class.equals(type)) {
                return java_t2.service.GetCurrentWeight.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (java_t2.service.GetCurrentWeightResponse.class.equals(type)) {
                return java_t2.service.GetCurrentWeightResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (java_t2.service.GetTray.class.equals(type)) {
                return java_t2.service.GetTray.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (java_t2.service.GetTrayResponse.class.equals(type)) {
                return java_t2.service.GetTrayResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (java_t2.service.NewOrder.class.equals(type)) {
                return java_t2.service.NewOrder.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (java_t2.service.NewOrderResponse.class.equals(type)) {
                return java_t2.service.NewOrderResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (java_t2.service.NewPart.class.equals(type)) {
                return java_t2.service.NewPart.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (java_t2.service.NewPartResponse.class.equals(type)) {
                return java_t2.service.NewPartResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (java_t2.service.NewTray.class.equals(type)) {
                return java_t2.service.NewTray.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (java_t2.service.NewTrayResponse.class.equals(type)) {
                return java_t2.service.NewTrayResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
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
