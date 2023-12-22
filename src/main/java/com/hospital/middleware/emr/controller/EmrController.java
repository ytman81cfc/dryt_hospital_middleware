package com.hospital.middleware.emr.controller;

import com.hospital.middleware.emr.dao.his.EmrDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import java.util.*;

@RestController
@RequestMapping("/emr")
public class EmrController {
    private Logger log = LoggerFactory.getLogger(EmrController.class);

    @Autowired
    private EmrDAO emrDAO;

    @RequestMapping("/queryData")
    public List<Map> queryData(@RequestParam Map<String, String> map) {
        String orgCode = "H37068300546";
        String dataType = map.get("dataType");
        String startDate = map.get("startDate") + " 00:00:00";
        String endDate = map.get("endDate") + " 23:59:59";
        Map<String, String> paraMap = new HashMap<String, String>();
        paraMap.put("orgCode", orgCode);
        paraMap.put("startDate", startDate);
        paraMap.put("endDate", endDate);

        List<Map> result = new ArrayList<Map>();
        if ("baza".equals(dataType)) {
            result = emrDAO.queryBaza(paraMap);
            return convertResult(result);
        }
        if ("baf1".equals(dataType)) {
            result = emrDAO.queryBaf1(paraMap);
            return convertResult(result);
        }
        if ("baf4".equals(dataType)) {
            result = emrDAO.queryBaf4(paraMap);
            return convertResult(result);
        }
        if ("baf6".equals(dataType)) {
            String param = "parameter";
            if ("parameter".equals(param)) {
                result = emrDAO.queryBaf6(paraMap);
                for (int i = 0; i < result.size(); i++) {
                    BigDecimal sum = new BigDecimal("0");
                    BigDecimal BAF601 = new BigDecimal(result.get(i).get("BAF601").toString());

                    BigDecimal BAF603 = new BigDecimal(result.get(i).get("BAF603").toString());
                    sum = sum.add(BAF603);

                    BigDecimal BAF604 = new BigDecimal(result.get(i).get("BAF604").toString());
                    sum = sum.add(BAF604);

                    BigDecimal BAF605 = new BigDecimal(result.get(i).get("BAF605").toString());
                    sum = sum.add(BAF605);

                    BigDecimal BAF606 = new BigDecimal(result.get(i).get("BAF606").toString());
                    sum = sum.add(BAF606);

                    BigDecimal BAF607 = new BigDecimal(result.get(i).get("BAF607").toString());
                    sum = sum.add(BAF607);

                    BigDecimal BAF608 = new BigDecimal(result.get(i).get("BAF608").toString());
                    sum = sum.add(BAF608);

                    BigDecimal BAF609 = new BigDecimal(result.get(i).get("BAF609").toString());
                    sum = sum.add(BAF609);

                    BigDecimal BAF610 = new BigDecimal(result.get(i).get("BAF610").toString());
                    sum = sum.add(BAF610);

                    BigDecimal BAF611 = new BigDecimal(result.get(i).get("BAF611").toString());
                    sum = sum.add(BAF611);

                    BigDecimal BAF612 = new BigDecimal(result.get(i).get("BAF612").toString());
                    sum = sum.add(BAF612);

                    BigDecimal BAF613 = new BigDecimal(result.get(i).get("BAF613").toString());
                    sum = sum.add(BAF613);

                    BigDecimal BAF616 = new BigDecimal(result.get(i).get("BAF616").toString());
                    sum = sum.add(BAF616);

                    BigDecimal BAF617 = new BigDecimal(result.get(i).get("BAF617").toString());
                    sum = sum.add(BAF617);

                    BigDecimal BAF618 = new BigDecimal(result.get(i).get("BAF618").toString());
                    sum = sum.add(BAF618);

                    BigDecimal BAF620 = new BigDecimal(result.get(i).get("BAF620").toString());
                    sum = sum.add(BAF620);

                    BigDecimal BAF621 = new BigDecimal(result.get(i).get("BAF621").toString());
                    sum = sum.add(BAF621);

                    BigDecimal BAF622 = new BigDecimal(result.get(i).get("BAF622").toString());
                    sum = sum.add(BAF622);

                    BigDecimal BAF623 = new BigDecimal(result.get(i).get("BAF623").toString());
                    sum = sum.add(BAF623);

                    BigDecimal BAF624 = new BigDecimal(result.get(i).get("BAF624").toString());
                    sum = sum.add(BAF624);

                    BigDecimal BAF625 = new BigDecimal(result.get(i).get("BAF625").toString());
                    sum = sum.add(BAF625);

                    BigDecimal BAF626 = new BigDecimal(result.get(i).get("BAF626").toString());
                    sum = sum.add(BAF626);

                    BigDecimal BAF627 = new BigDecimal(result.get(i).get("BAF627").toString());
                    sum = sum.add(BAF627);

                    BigDecimal BAF628 = new BigDecimal(result.get(i).get("BAF628").toString());
                    sum = sum.add(BAF628);

                    BigDecimal BAF629 = new BigDecimal(result.get(i).get("BAF629").toString());
                    sum = sum.add(BAF629);

                    BigDecimal BAF630 = new BigDecimal(result.get(i).get("BAF630").toString());
                    sum = sum.add(BAF630);

                    BigDecimal BAF633 = new BigDecimal(result.get(i).get("BAF633").toString());
                    sum = sum.add(BAF633);

                    BigDecimal BAF640 = new BigDecimal(result.get(i).get("BAF640").toString());
                    sum = sum.add(BAF640);

                    if (sum.compareTo(BAF601) > 0) {
                        sum = sum.subtract(BAF601);
                        BigDecimal num = new BigDecimal("0.05");
                        if (sum.compareTo(num) <= 0) {
                            BAF618 = BAF618.subtract(sum);
                            result.get(i).put("BAF618", BAF618.toString());
                        }
                    } else if (sum.compareTo(BAF601) < 0) {
                        BAF601 = BAF601.subtract(sum);
                        BigDecimal num = new BigDecimal("0.05");
                        if (BAF601.compareTo(num) <= 0) {
                            BAF618 = BAF618.add(BAF601);
                            result.get(i).put("BAF618", BAF618.toString());
                        }
                    }
                }
            } else {
                result = emrDAO.queryBaf6(paraMap);
            }
            return convertResult(result);
        }
        if ("tjz1".equals(dataType)) {
            result = emrDAO.queryTjz1(paraMap);
            return convertResult(result);
        }
        return result;
    }

    public List<Map> convertResult(List<Map> data) {
        List<Map> result = new ArrayList<Map>();
        for (int i = 0; i < data.size(); i++) {
            Map element = new HashMap();
            Map row = data.get(i);
            Iterator ki = row.keySet().iterator();
            while (ki.hasNext()) {
                String key = ki.next().toString();
                if (!(key.toUpperCase().equals("ORGCODE") || key.toUpperCase().equals("INID") || key.toUpperCase().equals("CREATE_TIME"))) {
                    Object object = row.get(key);
                    element.put(key.toLowerCase(), object);
                }
            }
            result.add(element);
        }
        return result;
    }
}
