package com.demo;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import javax.xml.namespace.QName;

public class WsClient {

    public static void main(String[] args) throws Exception {
        //封装参数
        /*String xmlParam= "<root>\n" +
                "\t<sHead>\n" +
                "\t\t<sType>JP001</sType>\n" +
                "\t\t<sTime>1528253397850</sTime>\n" +
                "\t\t<sCooperationUnit>LQT</sCooperationUnit>\n" +
                "\t\t<sTerminalNumber>25bad3fbdf7b88a6976237fb25d22515 </sTerminalNumber>  \n" +
                "\t</sHead>\n" +
                "\t<sInfo>\n" +
                "\t\t<ID>231021</ID>\n" +
                "\t\t<OrgCode>H37068300546</OrgCode>\n" +
                "\t\t<StartDate>2023-03-01 00:00:00</StartDate>\n" +
                "\t\t<EndDate>2023-03-21 23:59:59</EndDate>\n" +
                "\t</sInfo>\n" +
                "</root>";*/
       /* String xmlParam= "<root>\n" +
                "\t<sHead>\n" +
                "\t\t<sType>JP002</sType>\n" +
                "\t\t<sTime>1528253397850</sTime>\n" +
                "\t\t<sCooperationUnit>LQT</sCooperationUnit>\n" +
                "\t\t<sTerminalNumber>17370342d9e707adddf3c65fcf48b020</sTerminalNumber>  \n" +
                "\t</sHead>\n" +
                "\t<sInfo>\n" +
                "\t\t<OrgCode>H37068300546</OrgCode>\n" +
                "\t\t<StartDate>2023-03-13 13:50:00</StartDate>\n" +
                "\t\t<EndDate>2023-03-13 14:00:00</EndDate>\n" +
                "\t</sInfo>\n" +
                "</root>";*/
      /*  String xmlParam= "<root>\n" +
                "\t<sHead>\n" +
                "\t\t<sType>JP003</sType>\n" +
                "\t\t<sTime>1528253397850</sTime>\n" +
                "\t\t<sCooperationUnit>LQT</sCooperationUnit>\n" +
                "\t\t<sTerminalNumber>fbb24ccfbcd3d38258f69e410103717d</sTerminalNumber>  \n" +
                "\t</sHead>\n" +
                "\t<sInfo>\n" +
                "\t\t<OrgCode>H37068300546</OrgCode>\n" +
                "\t\t<ID>231021</ID>\n" +
                "\t\t<StartDate>2023-03-01 01:50:00</StartDate>\n" +
                "\t\t<EndDate>2023-03-13 14:00:00</EndDate>\n" +
                "\t</sInfo>\n" +
                "</root>";*/
       /* String xmlParam= "<root>\n" +
                "\t<sHead>\n" +
                "\t\t<sType>JP006</sType>\n" +
                "\t\t<sTime>1528253397850</sTime>\n" +
                "\t\t<sCooperationUnit>LQT</sCooperationUnit>\n" +
                "\t\t<sTerminalNumber>ae7ae8aa17ad7e5d9173a3a34d900860</sTerminalNumber>  \n" +
                "\t</sHead>\n" +
                "\t<sInfo>\n" +
                "\t\t<OrgCode>H37068300546</OrgCode>\n" +
                "\t\t<DateType>1</DateType>\n" +
                "\t\t<StartDate>2023-03-09 01:50:00</StartDate>\n" +
                "\t\t<EndDate>2023-03-13 14:00:00</EndDate>\n" +
                "\t</sInfo>\n" +
                "</root>";*/
       /* String xmlParam= "<root>\n" +
                "\t<sHead>\n" +
                "\t\t<sType>JP008</sType>\n" +
                "\t\t<sTime>1528253397850</sTime>\n" +
                "\t\t<sCooperationUnit>LQT</sCooperationUnit>\n" +
                "\t\t<sTerminalNumber>f9076b44b468fcef3296702bde126d02</sTerminalNumber>  \n" +
                "\t</sHead>\n" +
                "\t<sInfo>\n" +
                "\t\t<ID>231027</ID>\n" +
                "\t\t<OrgCode>H37068300546</OrgCode>\n" +
                "\t\t<DateType>0</DateType>\n" +
                "\t\t<StartDate>2023-03-01 01:50:00</StartDate>\n" +
                "\t\t<EndDate>2023-03-14 14:00:00</EndDate>\n" +
                "\t</sInfo>\n" +
                "</root>";*/
       /* String xmlParam= "<root>\n" +
                "\t<sHead>\n" +
                "\t\t<sType>JP009</sType>\n" +
                "\t\t<sTime>1528253397850</sTime>\n" +
                "\t\t<sCooperationUnit>LQT</sCooperationUnit>\n" +
                "\t\t<sTerminalNumber>961508b3f02b2196ef9ce8ae27e59f89</sTerminalNumber>  \n" +
                "\t</sHead>\n" +
                "\t<sInfo>\n" +
                "\t\t<ID>231025</ID>\n" +
                "\t\t<OrgCode>H37068300546</OrgCode>\n" +
                "\t\t<StartDate>2023-03-01 01:50:00</StartDate>\n" +
                "\t\t<EndDate>2023-03-14 14:00:00</EndDate>\n" +
                "\t</sInfo>\n" +
                "</root>";*/
       /* String xmlParam= "<root>\n" +
                "\t<sHead>\n" +
                "\t\t<sType>JD001</sType>\n" +
                "\t\t<sTime>1528253397850</sTime>\n" +
                "\t\t<sCooperationUnit>LQT</sCooperationUnit>\n" +
                "\t\t<sTerminalNumber>c24d62e99915e1c13ca7efcf38febc01</sTerminalNumber>  \n" +
                "\t</sHead>\n" +
                "\t<sInfo>\n" +
                "\t\t<OrgCode>H37068300546</OrgCode>\n" +
                "\t</sInfo>\n" +
                "</root>";*/
        String xmlParam= "<root>\n" +
                "\t<sHead>\n" +
                "\t\t<sType>JD002</sType>\n" +
                "\t\t<sTime>1528253397850</sTime>\n" +
                "\t\t<sCooperationUnit>LQT</sCooperationUnit>\n" +
                "\t\t<sTerminalNumber>0172f5db1f03bfacdc1416bb9bd4ef3b</sTerminalNumber>  \n" +
                "\t</sHead>\n" +
                "\t<sInfo>\n" +
                "\t\t<OrgCode>H37068300546</OrgCode>\n" +
                "\t</sInfo>\n" +
                "</root>";
        Object[] requestParam = new Object[]{xmlParam};

        //String siUrl = "http://192.168.126.107:9090/acceptMessage?wsdl";
        String siUrl = "http://127.0.0.1:9090/acceptMessage?wsdl";
        String method = "acceptMessage"; //方法名
        String spaceUrl = "http://webservice.hospitalinfection.middleware.hospital.com/";  //命名空间

        RPCServiceClient serviceClient = new RPCServiceClient();
        Options options = serviceClient.getOptions();
        EndpointReference targetEPR = new EndpointReference(siUrl);  //指定调用WebService的URL
        options.setTo(targetEPR); //设置serviceClient需要访问的url
        options.setTimeOutInMilliSeconds(3600000); //设置超时时间
        Class[] responseParam = new Class[] { String.class }; //指定方法返回值的数据类型的Class对象
        QName requestMethod = new QName(spaceUrl, method); //指定要调用的getGreeting方法及WSDL文件的命名空间
        // 调用方法并输出该方法的返回值
        for(int i = 0; i < 10; i++) {
            String result = "" + serviceClient.invokeBlocking(requestMethod, requestParam, responseParam)[0];
            System.out.println(result);
        }
    }
}