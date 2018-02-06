package com.baobaotao.service.impl;

import com.baobaotao.service.ForumService;

import java.sql.SQLException;

/**
 * @author Administrator
 */
public class ForumServiceImpl implements ForumService {
    public void removeTopic(int topicId) {
//        PerformanceMonitor.begin("com.baobaotao.service.ForumServiceImpl.removeTopic");
        System.out.println("模拟删除Topic记录:" + topicId);
        try {
            Thread.sleep(20);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
//        PerformanceMonitor.end();
    }

    public void removeForum(int forumId) {
//        PerformanceMonitor.begin("com.baobaotao.service.ForumServiceImpl.removeForum");
        System.out.println("模拟删除Forum记录:" + forumId);
        try {
            Thread.sleep(20);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
//        PerformanceMonitor.end();

        throw new RuntimeException("运行异常.");
    }

    public void updateForum() throws Exception {
        throw new SQLException("数据更新操作异常.");
    }
}