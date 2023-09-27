package com.demo;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import javax.xml.namespace.QName;

public class MRWsClient {

    public static void main(String[] args) throws Exception {

        String siUrl = "http://127.0.0.1:9506/mrAcceptMessage?wsdl";
        String spaceUrl = "http://webservice.medicalrecord.middleware.hospital.com/";  //命名空间
        RPCServiceClient serviceClient = new RPCServiceClient();
        Options options = serviceClient.getOptions();
        EndpointReference targetEPR = new EndpointReference(siUrl);  //指定调用WebService的URL
        options.setTo(targetEPR); //设置serviceClient需要访问的url
        options.setTimeOutInMilliSeconds(3600000); //设置超时时间

        /*
        String startdt = "2023-05-01";
        String enddt = "2023-05-05";
        Object[] requestParam1 = new Object[]{startdt, enddt};
        String method1 = "QryMedCardListByOutDate"; //方法名
        Class[] responseParam1 = new Class[] { String.class }; //指定方法返回值的数据类型的Class对象
        QName requestMethod1 = new QName(spaceUrl, method1); //指定要调用的getGreeting方法及WSDL文件的命名空间
        String result1 = "" + serviceClient.invokeBlocking(requestMethod1, requestParam1, responseParam1)[0];
        System.out.println("打印结果:" + result1);
        */

        /*
        String patNo = "231019";
        Object[] requestParam2 = new Object[]{patNo};
        String method2 = "QryMedCardListByPatNo"; //方法名
        Class[] responseParam2 = new Class[] { String.class }; //指定方法返回值的数据类型的Class对象
        QName requestMethod2 = new QName(spaceUrl, method2); //指定要调用的getGreeting方法及WSDL文件的命名空间
        String result2 = "" + serviceClient.invokeBlocking(requestMethod2, requestParam2, responseParam2)[0];
        System.out.println("打印结果:" + result2);
        */


        String relprimary = "231627";
        Object[] requestParam3 = new Object[]{relprimary};
        String method3 = "GetMedCardXml"; //方法名
        Class[] responseParam3 = new Class[] { String.class }; //指定方法返回值的数据类型的Class对象
        QName requestMethod3 = new QName(spaceUrl, method3); //指定要调用的getGreeting方法及WSDL文件的命名空间
        String result3 = "" + serviceClient.invokeBlocking(requestMethod3, requestParam3, responseParam3)[0];
        System.out.println("打印结果:" + result3);

    }

}