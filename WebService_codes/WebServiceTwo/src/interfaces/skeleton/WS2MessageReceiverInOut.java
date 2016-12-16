/**
 * WS2MessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package interfaces.skeleton;


/**
 *  WS2MessageReceiverInOut message receiver
 */
public class WS2MessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver {
    public void invokeBusinessLogic(
        org.apache.axis2.context.MessageContext msgContext,
        org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault {
        try {
            // get the implementation class for the Web Service
            Object obj = getTheImplementationObject(msgContext);

            WS2SkeletonInterface skel = (WS2SkeletonInterface) obj;

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
                if ("reverse".equals(methodName)) {
                    interfaces.ReverseResponse reverseResponse31 = null;
                    interfaces.Reverse wrappedParam = (interfaces.Reverse) fromOM(msgContext.getEnvelope()
                                                                                            .getBody()
                                                                                            .getFirstElement(),
                            interfaces.Reverse.class);

                    reverseResponse31 = skel.reverse(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            reverseResponse31, false,
                            new javax.xml.namespace.QName("http://interfaces",
                                "reverseResponse"));
                } else
                 if ("vat".equals(methodName)) {
                    interfaces.VatResponse vatResponse33 = null;
                    interfaces.Vat wrappedParam = (interfaces.Vat) fromOM(msgContext.getEnvelope()
                                                                                    .getBody()
                                                                                    .getFirstElement(),
                            interfaces.Vat.class);

                    vatResponse33 = skel.vat(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            vatResponse33, false,
                            new javax.xml.namespace.QName("http://interfaces",
                                "vatResponse"));
                } else
                 if ("max".equals(methodName)) {
                    interfaces.MaxResponse maxResponse35 = null;
                    interfaces.Max wrappedParam = (interfaces.Max) fromOM(msgContext.getEnvelope()
                                                                                    .getBody()
                                                                                    .getFirstElement(),
                            interfaces.Max.class);

                    maxResponse35 = skel.max(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            maxResponse35, false,
                            new javax.xml.namespace.QName("http://interfaces",
                                "maxResponse"));
                } else
                 if ("isLeap".equals(methodName)) {
                    interfaces.IsLeapResponse isLeapResponse37 = null;
                    interfaces.IsLeap wrappedParam = (interfaces.IsLeap) fromOM(msgContext.getEnvelope()
                                                                                          .getBody()
                                                                                          .getFirstElement(),
                            interfaces.IsLeap.class);

                    isLeapResponse37 = skel.isLeap(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            isLeapResponse37, false,
                            new javax.xml.namespace.QName("http://interfaces",
                                "isLeapResponse"));
                } else
                 if ("avg".equals(methodName)) {
                    interfaces.AvgResponse avgResponse39 = null;
                    interfaces.Avg wrappedParam = (interfaces.Avg) fromOM(msgContext.getEnvelope()
                                                                                    .getBody()
                                                                                    .getFirstElement(),
                            interfaces.Avg.class);

                    avgResponse39 = skel.avg(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            avgResponse39, false,
                            new javax.xml.namespace.QName("http://interfaces",
                                "avgResponse"));
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
    private org.apache.axiom.om.OMElement toOM(interfaces.Reverse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(interfaces.Reverse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        interfaces.ReverseResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(interfaces.ReverseResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(interfaces.Vat param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(interfaces.Vat.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(interfaces.VatResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(interfaces.VatResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(interfaces.Max param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(interfaces.Max.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(interfaces.MaxResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(interfaces.MaxResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(interfaces.IsLeap param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(interfaces.IsLeap.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        interfaces.IsLeapResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(interfaces.IsLeapResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(interfaces.Avg param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(interfaces.Avg.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(interfaces.AvgResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(interfaces.AvgResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        interfaces.ReverseResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    interfaces.ReverseResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private interfaces.ReverseResponse wrapreverse() {
        interfaces.ReverseResponse wrappedElement = new interfaces.ReverseResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        interfaces.VatResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    interfaces.VatResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private interfaces.VatResponse wrapvat() {
        interfaces.VatResponse wrappedElement = new interfaces.VatResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        interfaces.MaxResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    interfaces.MaxResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private interfaces.MaxResponse wrapmax() {
        interfaces.MaxResponse wrappedElement = new interfaces.MaxResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        interfaces.IsLeapResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    interfaces.IsLeapResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private interfaces.IsLeapResponse wrapisLeap() {
        interfaces.IsLeapResponse wrappedElement = new interfaces.IsLeapResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        interfaces.AvgResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    interfaces.AvgResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private interfaces.AvgResponse wrapavg() {
        interfaces.AvgResponse wrappedElement = new interfaces.AvgResponse();

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
            if (interfaces.Avg.class.equals(type)) {
                return interfaces.Avg.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (interfaces.AvgResponse.class.equals(type)) {
                return interfaces.AvgResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (interfaces.IsLeap.class.equals(type)) {
                return interfaces.IsLeap.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (interfaces.IsLeapResponse.class.equals(type)) {
                return interfaces.IsLeapResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (interfaces.Max.class.equals(type)) {
                return interfaces.Max.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (interfaces.MaxResponse.class.equals(type)) {
                return interfaces.MaxResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (interfaces.Reverse.class.equals(type)) {
                return interfaces.Reverse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (interfaces.ReverseResponse.class.equals(type)) {
                return interfaces.ReverseResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (interfaces.Vat.class.equals(type)) {
                return interfaces.Vat.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (interfaces.VatResponse.class.equals(type)) {
                return interfaces.VatResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
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
