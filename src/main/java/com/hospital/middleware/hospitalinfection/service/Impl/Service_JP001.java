package com.hospital.middleware.hospitalinfection.service.Impl;

import com.hospital.middleware.hospitalinfection.dao.his.JP001DAO;
import com.hospital.middleware.hospitalinfection.service.BaseService;
import com.hospital.middleware.hospitalinfection.service.IService;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

@Service
public class Service_JP001 extends BaseService implements IService {

    @Autowired
    private JP001DAO jp001;

    @Override
    public List<Map> queryData(Map paramMap) {
        List<Map> list = jp001.queryData(paramMap);
        for (int i = 0; i < list.size(); i++) {
            Clob clob1 = null;
            Clob clob2 = null;
            Clob clob3 = null;
            String text1 = "";
            String text2 = "";
            String text3 = "";
            String result1 = "";
            String result2 = "";
            String result3 = "";
            try {
                if (list.get(i).containsKey("text1")) {
                    clob1 = (Clob) list.get(i).get("text1");
                    text1 = clob1.getSubString(1, (int) clob1.length());
                    result1 = decodeBase64AndGZip(text1);
                    list.get(i).remove("text1");
                }
                if (list.get(i).containsKey("text2")) {
                    clob2 = (Clob) list.get(i).get("text2");
                    text2 = clob2.getSubString(1, (int) clob2.length());
                    result2 = decodeBase64AndGZip(text2);
                    list.get(i).remove("text2");
                }
                if (list.get(i).containsKey("text3")) {
                    clob3 = (Clob) list.get(i).get("text3");
                    text3 = clob3.getSubString(1, (int) clob3.length());
                    result3 = decodeBase64AndGZip(text3);
                    list.get(i).remove("text3");
                }
                list.get(i).put("CourseContent", result1+result2+result3);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static String decodeBase64AndGZip(String input) {
        byte[] bytes;
        String out = input;

        try (ByteArrayInputStream bis = new ByteArrayInputStream(Base64.getDecoder().decode(input));
             GZIPInputStream gzip = new GZIPInputStream(bis);
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            byte[] buf = new byte[1024];
            int num;
            while ((num = gzip.read(buf, 0, buf.length)) != -1) {
                bos.write(buf, 0, num);
            }
            bytes = bos.toByteArray();
            out = new String(bytes, StandardCharsets.UTF_8);
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }

    @Override
    public String assembleXml(List<String> paramList) {
        String result = "<Response>";
        for (int i = 0; i < paramList.size(); i++) {
            result = result + "<List>" + paramList.get(i) + "</List>";
        }
        result = result + "</Response>";
        return result;
    }

    @Override
    public String process(Map paramMap) {
        List<Map> t_result = queryData(paramMap);
        List<String> rowList = assembleXmlRowArray(t_result);
        String xmlString = assembleXml(rowList);
        return xmlString;
    }
}
