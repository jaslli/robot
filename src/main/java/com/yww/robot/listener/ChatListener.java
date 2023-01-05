package com.yww.robot.listener;

import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import love.forte.simboot.annotation.Listener;
import love.forte.simbot.definition.Friend;
import love.forte.simbot.event.EventResult;
import love.forte.simbot.event.FriendMessageEvent;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.yww.robot.utils.HttpUtil.httpPost;

/**
 * <p>
 *      测试
 * </p>
 *
 * @ClassName ChatListener
 * @Author yww
 * @Date 2022/8/29 10:20
 */
@Service
public class ChatListener {

    /**
     * 参数中使用 {@link FriendMessageEvent}, 代表监听好友消息事件。
     * 注意观察包路径，是 {@code love.forte.simbot.event.FriendMessageEvent }.
     *
     * @param friendMessageEvent 好友消息事件
     * @return 事件结果，用于控制事件流程。
     * 如果你不打算控制整个监听流程，返回值也可以直接使用 void .
     */
    @Listener
    public EventResult reply(FriendMessageEvent friendMessageEvent) {
        String plainText = friendMessageEvent.getMessageContent().getPlainText().trim();

        Map<String, Object> body = new HashMap<>(7);
        body.put("model", "text-davinci-003");
        body.put("prompt",plainText);
        body.put("temperature",0.9);
        body.put("max_tokens",1000);
        body.put("top_p",1);
        body.put("frequency_penalty",0);
        body.put("presence_penalty",0.6);
        String reply;
        try(HttpResponse response = httpPost("https://api.openai.com/v1/completions", body)) {
            JSONArray array = (JSONArray) JSONUtil.parseObj(response.body()).getByPath("choices");
            reply = (String) JSONUtil.getByPath(JSONUtil.parse(array.get(0)), "text");
        }
        reply = reply.replaceAll("\n", "");
        // 发送消息
        Friend currentFriend = friendMessageEvent.getFriend();
        currentFriend.sendBlocking(reply);

        // 返回 EventResult.truncate 代表阻止后续其他监听函数的执行。
        return EventResult.truncate();
    }

}
