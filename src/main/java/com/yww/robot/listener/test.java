package com.yww.robot.listener;

import love.forte.simboot.annotation.Filter;
import love.forte.simboot.annotation.Listener;
import love.forte.simboot.filter.MatchType;
import love.forte.simbot.definition.Friend;
import love.forte.simbot.event.EventResult;
import love.forte.simbot.event.FriendMessageEvent;
import org.springframework.stereotype.Service;

/**
 * <p>
 *      测试
 * </p>
 *
 * @ClassName test
 * @Author yww
 * @Date 2022/8/29 10:20
 */
@Service
public class test {

    @Listener()
    @Filter(value = "hi", matchType = MatchType.TEXT_EQUALS)
    public EventResult reply(FriendMessageEvent friendMessageEvent) {
        String reply = ("hello world!");
        // 如果有，发送消息，并阻止后续事件的执行。
        Friend currentFriend = friendMessageEvent.getFriend();
        currentFriend.sendBlocking(reply);
        // 返回 EventResult.truncate 代表阻止后续其他监听函数的执行。
        return EventResult.truncate();
    }

}
