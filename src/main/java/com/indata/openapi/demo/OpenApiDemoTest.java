package com.indata.openapi.demo;

import com.alibaba.fastjson.JSON;
import com.indata.openapi.model.*;
import com.indata.openapi.utils.IndataHttpUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * api接口的例子
 * 流程步骤
 * 1、获取公司列表
 * 2、获取公司的机器人话术列表
 * 3、创建任务
 * 4、向任务中导入客户
 * 5、开始任务
 * 6、获取未开始的电话列表
 * 7、获取已经完成电话列表
 * 8、获取通话详情
 * <p>
 * 其他api：
 * 1、获取一个公司的所有任务列表
 * 2、获取任务详情
 * 3、暂停任务
 * 3、终止任务
 * 4、获取公司的主叫号码
 *
 * @author indata
 * @create 2018/2/5
 */

public class OpenApiDemoTest {
    //TODO app key  需要修改
    private static final String APP_KEY = "****appKey*******";
    //TODO app SECRET  需要修改
    private static final String APP_SECRET = "*****appSecret*******";
    //线上环境
    private static final String BASE_URL = "http://api.byrobot.cn";

    /**
     * 1、获取公司列表
     */
    @Test
    public void getCompanyListTest() {
        String url = BASE_URL + "/openapi/v1/company/getCompanys";
        String result = IndataHttpUtils.sendGet(url, APP_KEY, APP_SECRET);
        System.out.print("获取公司列表的结果:" + result);
    }

    /**
     * 2、获取公司的机器人话术列表
     */
    @Test
    public void getRobotListByCompanyIdTest() {
        //公司id
        Integer companyId = 1;
        String url = BASE_URL + "/openapi/v1/company/getRobots?companyId=" + companyId;
        String result = IndataHttpUtils.sendGet(url, APP_KEY, APP_SECRET);
        System.out.println("获取公司的机器人话术列表的结果:" + result);
    }

    /**
     * 3、创建任务
     */
    @Test
    public void createTaskTest() {
        String url = BASE_URL + "/openapi/v1/task/createTask";
        //创建任务信息实体
        CreateTaskParamVO createTaskParamVO = new CreateTaskParamVO();
        createTaskParamVO.setCompanyId(67);
        createTaskParamVO.setTaskName("测试");
        createTaskParamVO.setTaskType(1);
        List<Integer> userPhoneIds = new ArrayList<>();
        userPhoneIds.add(12);
        userPhoneIds.add(13);
        userPhoneIds.add(146);
        createTaskParamVO.setCallType(2);
        createTaskParamVO.setConcurrencyQuota(2);
        createTaskParamVO.setStartDate("2018-06-07");
        createTaskParamVO.setWorkingStartTime("08:50");
        createTaskParamVO.setWorkingEndTime("23:59");
        createTaskParamVO.setUserPhoneIds(userPhoneIds);
        createTaskParamVO.setRobotDefId(14);
        createTaskParamVO.setSceneDefId(34);
        createTaskParamVO.setSceneRecordId(34);
        createTaskParamVO.setRemark("测试");
        CreateTaskParamVO.RuleDetail ruleDetail = new CreateTaskParamVO.RuleDetail();
        ruleDetail.setPhoneStatus(10);
        ruleDetail.setInterval(5);
        ruleDetail.setTimes(2);
        createTaskParamVO.setRepeatCallRule(Arrays.asList(ruleDetail));
        String json = JSON.toJSONString(createTaskParamVO);
        System.out.println(json);
        String result = IndataHttpUtils.sendPost(url, json, APP_KEY, APP_SECRET);
        System.out.println("创建任务的结果:" + result);
    }

    /**
     * 4、向任务中导入客户
     */
    @Test
    public void importTaskCustomerTest() {
        String url = BASE_URL + "/openapi/v1/task/importTaskCustomer";
        ImportTaskCustomerVO importTaskCustomerVO = new ImportTaskCustomerVO();
        importTaskCustomerVO.setCompanyId(1);
        importTaskCustomerVO.setTaskId(12);
        importTaskCustomerVO.setForceTransferCustomer(1);
        List<CustomerInfoExtVO> customerInfoList = new CopyOnWriteArrayList<>();
        //客户信息
        for(int i=0;i<=50;i++){
            CustomerInfoExtVO customerInfoExtVO1 = new CustomerInfoExtVO();
            customerInfoExtVO1.setName("测试"+i);
            customerInfoExtVO1.setPhone("1830581165"+i);
            customerInfoList.add(customerInfoExtVO1);
        }
        importTaskCustomerVO.setCustomerInfoList(customerInfoList);
        String json = JSON.toJSONString(importTaskCustomerVO);
        String result = IndataHttpUtils.sendPost(url, json, APP_KEY, APP_SECRET);
        System.out.println("向任务中导入客户的结果:" + result);
    }

    /**
     * 5、开始任务
     */
    @Test
    public  void startTaskTest() {
        String url = BASE_URL + "/openapi/v1/task/start";
        //任务的id
        TaskParamVO taskParamVO = new TaskParamVO(71);
        String json = JSON.toJSONString(taskParamVO);
        String result = IndataHttpUtils.sendPost(url, json, APP_KEY, APP_SECRET);
        System.out.println("开始任务的结果:" + result);
    }
    /**
     * 6、获取未开始的电话列表
     */
    @Test
    public void getTaskPhonesTest() {
        //任务的id
        Integer taskId = 67;
        String url = BASE_URL + "/openapi/v1/task/notDialedCustomerList?taskId=" + taskId;
        String result = IndataHttpUtils.sendGet(url, APP_KEY, APP_SECRET);
        System.out.println("获取未开始的电话列表的结果：" + result);
    }



    /**
     * 7、获取已经完成任务电话号码列表
     */
    @Test
    public  void queryDoneTaskPhonesTest() {
        String url = BASE_URL + "/openapi/v1/task/queryDoneTaskPhones";
        DialedPhoneQueryVO dialedPhoneQueryVO = new DialedPhoneQueryVO();
        dialedPhoneQueryVO.setCallJobId(11406);
       /* dialedPhoneQueryVO.setDurationLeft(10);
        dialedPhoneQueryVO.setDurationRight(59);
        dialedPhoneQueryVO.setChatRoundLeft(0);
        dialedPhoneQueryVO.setChatRoundRight(9);*/
        //dialedPhoneQueryVO.setFinishStatus(0);
        //按分析结果作查询条件
        List<NameValueBO> resultQueryList = new ArrayList<>();
        NameValueBO nameValueBO = new NameValueBO();
        nameValueBO.setName("客户意向等级");
        nameValueBO.setValue("B级(一般)");
        //resultQueryList.add(nameValueBO);
        dialedPhoneQueryVO.setResultQueryList(resultQueryList);
        String json = JSON.toJSONString(dialedPhoneQueryVO);
        String result = IndataHttpUtils.sendPost(url, json, APP_KEY, APP_SECRET);
        System.out.println("获取已完成的客户通话记录的结果:" + result);
    }


    /**
     * 8、获取一个通话的详情
     */
    @Test
    public  void getPhoneLogInfoTest() {
        //通话记录id
        Long callInstanceId = 695L;
        String url = BASE_URL + "/openapi/v1/task/phoneLogInfo?callInstanceId=" + callInstanceId;
        String result = IndataHttpUtils.sendGet(url, APP_KEY, APP_SECRET);
        System.out.println("通话的详情的结果:" + result);
    }


    /**
     * 获取一个公司的所有任务列表
     */
    @Test
    public void getTaskListTest() {
        //公司id
        Integer companyId = 1;
        String url = BASE_URL + "/openapi/v1/task/getTasks?companyId=" + companyId;
        String result = IndataHttpUtils.sendGet(url, APP_KEY, APP_SECRET);
        System.out.println("获取一个公司的所有任务列表的结果:" + result);
    }

    /**
     * 获取任务详情
     */
    @Test
    public void getTaskDetailTest() {
        //公司id
        Integer companyId = 1;
        //任务id
        Integer taskId = 66;
        String url = BASE_URL + "/openapi/v1/task/getTaskDetail?companyId=" + companyId + "&taskId=" + taskId;
        String result = IndataHttpUtils.sendGet(url, APP_KEY, APP_SECRET);
        System.out.println("任务详情的结果:" + result);
    }

    /**
     * 暂停任务
     */
    @Test
    public void pauseTaskTest() {
        String url = BASE_URL + "/openapi/v1/task/pause";
        //任务的id
        TaskParamVO taskParamVO = new TaskParamVO(65);
        String json = JSON.toJSONString(taskParamVO);
        String result = IndataHttpUtils.sendPost(url, json, APP_KEY, APP_SECRET);
        System.out.println("暂停任务返回结果:" + result);
    }

    /**
     * 停止任务
     */
    @Test
    public void stopTaskTest() {
        String url = BASE_URL + "/openapi/v1/task/stop";
        //任务的id
        TaskParamVO taskParamVO = new TaskParamVO(65);
        String json = JSON.toJSONString(taskParamVO);
        String result = IndataHttpUtils.sendPost(url, json, APP_KEY, APP_SECRET);
        System.out.println("停止任务返回结果:" + result);
    }

    /**
     * 删除任务
     */
    @Test
    public void deleteTaskTest() {
        String url = BASE_URL + "/openapi/v1/task/delete";
        //任务的id
        TaskParamVO taskParamVO = new TaskParamVO(18489);
        String json = JSON.toJSONString(taskParamVO);
        String result = IndataHttpUtils.sendPost(url, json, APP_KEY, APP_SECRET);
        System.out.println("删除任务返回结果:" + result);
    }

    /**
     * 获取公司的主叫电话列表
     */
    @Test
    public void getPhonesCompanyIdTest() {
        //公司id
        Integer companyId = 1;
        String url = BASE_URL + "/openapi/v1/company/getPhones?companyId=" + companyId;
        String result = IndataHttpUtils.sendGet(url, APP_KEY, APP_SECRET);
        System.out.println("获取公司的主叫电话列表的结果:" + result);
    }

    /**
     * 单次电话外呼
     */
    @Test
    public void singlePhoneCallTest() {
        CallCustomerInfoVO callCustomerInfoVO = new CallCustomerInfoVO();

        callCustomerInfoVO.setCompanyId(127);
        callCustomerInfoVO.setRobotDefId(1295);
        callCustomerInfoVO.setSceneId(1307);
        callCustomerInfoVO.setSceneRecordId(1307);
        callCustomerInfoVO.setCustomerId(18670654);

        String url = BASE_URL + "/openapi/v1/task/call";

        String json = JSON.toJSONString(callCustomerInfoVO);
        String result = IndataHttpUtils.sendPost(url, json, APP_KEY, APP_SECRET);
        System.out.println(result);
    }


    /**
     * 修改任务的AI坐席数
     */
    @Test
    public void updateTaskTest() {
        UpdateTaskParamVO updateTaskParamVO = new UpdateTaskParamVO();
        updateTaskParamVO.setTaskId(1);
        updateTaskParamVO.setTaskName("ss");
        updateTaskParamVO.setUserPhoneIds("255");
        updateTaskParamVO.setConcurrencyQuota(1);
        updateTaskParamVO.setCallType(2);
        updateTaskParamVO.setCompanyId(23);

        String url = BASE_URL + "/openapi/v1/task/update";

        String json = JSON.toJSONString(updateTaskParamVO);
        String result = IndataHttpUtils.sendPost(url, json, APP_KEY, APP_SECRET);
        System.out.println(result);
    }


    @Test
    public void testCallByPhoneNum() {

        SingleCallVO singleCallVO = new SingleCallVO();
        singleCallVO.setMobile("15957182700");
        singleCallVO.setRobotDefId(1);
        singleCallVO.setSceneDefId(1);
        singleCallVO.setSceneRecordId(1);
        singleCallVO.setUserName("仲谋007");
        singleCallVO.setCompanyId(67);
        singleCallVO.setVariables(new HashMap<>());

        String url = BASE_URL + "/openapi/v1/task/singleCallByMobile";

        String json = JSON.toJSONString(singleCallVO);
        String result = IndataHttpUtils.sendPost(url, json, APP_KEY, APP_SECRET);
        System.out.println(result);


    }



}
