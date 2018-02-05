package com.indata.openapi.samples;

import com.alibaba.fastjson.JSON;
import com.indata.openapi.model.*;
import com.indata.openapi.until.IndataHttpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author indata
 * @create 2018/2/5
 **/
public class Samples {

    private static final String APP_KEY = "*** 申请的AppKey ***";
    private static final String APP_SECRET = "*** 申请的AppSecret ***";
    private static final String baseUrl = "";

    /**
     * 流程步骤
     * 1、获取可管理的企业列表
     * 2、根据企业id获取该企业的可用的机器人
     * 3、创建任务
     * 4、向任务中导入客户
     * 5、开始任务
     * 6、获取未开始的客户列表
     * 7、获取已经完成客户列表
     * 8、获取通话详情
     * <p>
     * 其他api：
     * 1、获取任务列表
     * 2、获取任务详情
     * 3、暂停和终止任务
     * 4、获取公司的主叫号码
     */

    public static void main(String[] args) {
        //获取可管理的企业列表
        getCompanyList();
        //根据企业id获取该企业的可用的机器人
        getRobotListByCompanyId();
        //创建任务
        createTask();
        //向任务中导入客户
        importTaskCustomer();
        //获取未开始的客户通话
        getTaskPhones();
        //开始任务
        startTask();
        //获取已完成的客户通话记录
        queryDoneTaskPhones();


        //获取一个通话的详情
        getPhoneLogInfo();
        //获取公司的主叫号码
        getPhonesCompanyId();
        //任务列表
        getTaskList();
        //任务详情
        getTaskDetail();
        //暂停任务
        pauseTask();
        //停止任务
        stopTask();
    }

    /**
     * 获取可管理的企业列表
     */
    private static void getCompanyList() {
        String url = baseUrl + "/openapi/v1/company/getCompanys";
        String result = IndataHttpUtils.sendGet(url, APP_KEY, APP_SECRET);
        System.out.print(result);
    }

    /**
     * 根据企业id获取该企业的可用的机器人
     */
    private static void getRobotListByCompanyId() {
        String url = baseUrl + "/openapi/v1/company/getRobots?companyId=1";
        String result = IndataHttpUtils.sendGet(url, APP_KEY, APP_SECRET);
        System.out.println(result);
    }

    /**
     * 创建任务
     */
    private static void createTask() {
        String url = baseUrl + "/openapi/v1/task/createTask";
        CreateTaskVO createTaskVO = new CreateTaskVO();
        createTaskVO.setCompanyId(1);
        createTaskVO.setTaskName("流程测试任务04");
        createTaskVO.setTaskType(2);
        List<Integer> userPhoneIds = new ArrayList<>();
        userPhoneIds.add(13);
        createTaskVO.setUserPhoneIds(userPhoneIds);
        createTaskVO.setRobotDefId(11);
        createTaskVO.setSceneDefId(29);
        createTaskVO.setSceneRecordId(21);
        createTaskVO.setRemark("流程测试任务03");
        String json = JSON.toJSONString(createTaskVO);
        String result = IndataHttpUtils.sendPost(url, json, APP_KEY, APP_SECRET);
        System.out.println(result);
    }

    /**
     * 向任务中导入客户
     */
    private static void importTaskCustomer() {
        String url = baseUrl + "/openapi/v1/task/importTaskCustomer";
        ImportTaskCustomerVO importTaskCustomerVO = new ImportTaskCustomerVO();
        importTaskCustomerVO.setCompanyId(1);
        importTaskCustomerVO.setTaskId(71);
        List<CustomerInfoExtVO> customerInfoList = new CopyOnWriteArrayList<>();
        CustomerInfoExtVO customerInfoExtVO = new CustomerInfoExtVO();
        customerInfoExtVO.setName("繁华");
        customerInfoExtVO.setPhone("18092906096");
        customerInfoList.add(customerInfoExtVO);
        importTaskCustomerVO.setCustomerInfoList(customerInfoList);
        String json = JSON.toJSONString(importTaskCustomerVO);
        String result = IndataHttpUtils.sendPost(url, json, APP_KEY, APP_SECRET);
        System.out.println(result);
    }

    /**
     * 获取未开始的客户通话
     */
    private static void getTaskPhones() {
        String url = baseUrl + "/openapi/v1/task/notDialedCustomerList?taskId=67";
        String result = IndataHttpUtils.sendGet(url, APP_KEY, APP_SECRET);
        System.out.println(result);
    }

    /**
     * 开始任务
     */
    private static void startTask() {
        String url = baseUrl + "/openapi/v1/task/start";
        Map<String, Integer> map = new HashMap<>();
        map.put("taskId", 71);
        String json = JSON.toJSONString(map);
        String result = IndataHttpUtils.sendPost(url, json, APP_KEY, APP_SECRET);
        System.out.println(result);
    }

    /**
     * 获取已完成的客户通话记录
     */
    private static void queryDoneTaskPhones() {
        String url = baseUrl + "/openapi/v1/task/queryDoneTaskPhones";
        DialedPhoneQueryVO dialedPhoneQueryVO = new DialedPhoneQueryVO();
        dialedPhoneQueryVO.setCallJobId(66);
        dialedPhoneQueryVO.setDurationLeft(10);
        dialedPhoneQueryVO.setDurationRight(59);
        dialedPhoneQueryVO.setChatRoundLeft(0);
        dialedPhoneQueryVO.setChatRoundRight(9);
        dialedPhoneQueryVO.setFinishStatus(0);
        List<NameValueBO> resultQueryList = new ArrayList<>();
        NameValueBO nameValueBO = new NameValueBO();
        nameValueBO.setName("客户意向等级");
        nameValueBO.setValue("B级(一般)");
        resultQueryList.add(nameValueBO);
        dialedPhoneQueryVO.setResultQueryList(resultQueryList);
        String json = JSON.toJSONString(dialedPhoneQueryVO);
        String result = IndataHttpUtils.sendPost(url, json, APP_KEY, APP_SECRET);
        System.out.println(result);
    }


    /**
     * 获取一个通话的详情
     */
    private static void getPhoneLogInfo() {
        String url = baseUrl + "/openapi/v1/task/phoneLogInfo?callInstanceId=695";
        String result = IndataHttpUtils.sendGet(url, APP_KEY, APP_SECRET);
        System.out.println(result);
    }


    /**
     * 获取公司的主叫号码
     */
    private static void getPhonesCompanyId() {
        String url = baseUrl + "/openapi/v1/company/getPhones?companyId=1";
        String result = IndataHttpUtils.sendGet(url, APP_KEY, APP_SECRET);
        System.out.println(result);
    }

    /**
     * 任务列表
     */
    private static void getTaskList() {
        String url = baseUrl + "/openapi/v1/task/getTasks?companyId=1";
        String result = IndataHttpUtils.sendGet(url, APP_KEY, APP_SECRET);
        System.out.println(result);
    }

    /**
     * 任务详情
     */
    private static void getTaskDetail() {
        String url = baseUrl + "/openapi/v1/task/getTaskDetail?companyId=1&taskId=66";
        String result = IndataHttpUtils.sendGet(url, APP_KEY, APP_SECRET);
        System.out.println(result);
    }

    /**
     * 暂停任务
     */
    private static void pauseTask() {
        String url = baseUrl + "/openapi/v1/task/pause";
        Map<String, Integer> map = new HashMap<>();
        map.put("taskId", 65);
        String json = JSON.toJSONString(map);
        String result = IndataHttpUtils.sendPost(url, json, APP_KEY, APP_SECRET);
        System.out.println(result);
    }

    /**
     * 停止任务
     */
    private static void stopTask() {
        String url = baseUrl + "/openapi/v1/task/stop";
        Map<String, Integer> map = new HashMap<>();
        map.put("taskId", 65);
        String json = JSON.toJSONString(map);
        String result = IndataHttpUtils.sendPost(url, json, APP_KEY, APP_SECRET);
        System.out.println(result);
    }

}
