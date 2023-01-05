package com.yww.robot.utils;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *      请求工具类
 * </p>
 *
 * @author yww
 * @since 2023/1/5 15:23
 */
public class HttpUtil {

    private static final String TOKEN = "";
    private static final String CONTENT_TYPE = "application/json";

    public static HttpResponse httpPost(String url, Map<String, Object> body) {
        HttpRequest request = HttpRequest.post(url);
        request.contentType(CONTENT_TYPE);
        request.auth(TOKEN);
        request.body(JSONUtil.toJsonStr(body));
        return request.execute();
    }

    public static void main(String[] args) {
        Map<String, Object> body = new HashMap<>(8);
        body.put("model", "text-davinci-003");
        body.put("prompt","Human: 你是谁？\\n\\nRobot: 我是一个机器人。我可以回答你关于科技、数学或其他问题的问题。\\n\\Human: 你会画画吗？");
        body.put("temperature",0.9);
        body.put("max_tokens",150);
        body.put("top_p",1);
        body.put("frequency_penalty",0);
        body.put("presence_penalty",0.6);
        try(HttpResponse response = httpPost("https://api.openai.com/v1/completions", body)) {
            JSONArray array = (JSONArray) JSONUtil.parseObj(response.body()).getByPath("choices");
            JSONUtil.getByPath(JSONUtil.parse(array.get(0)), "text");
        }
    }


}
