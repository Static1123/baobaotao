package com.baobaotao.service;

public interface ForumService {
    void removeTopic(int topicId);

    void removeForum(int forumId);

    void updateForum() throws Exception;
}
