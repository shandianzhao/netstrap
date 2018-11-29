package io.netstrap.core.server.http.wrapper;


import java.io.UnsupportedEncodingException;

/**
 * Http请求头
 * @author minghu.zhang
 * @date 2018/11/07
 */
public class HttpBody {

    /**
     * 请求体字节数组
     */
    private byte[]  body;

    /**
     * 构造函数
     */
    private HttpBody(byte[] body) {
        this.body = body;
    }

    /**
     * 获取消息体
     */
    public static HttpBody wrap(byte[] body) {
        return new HttpBody(body);
    }

    /**
     * 获取字符串
     * @return
     */
    public String getString() throws UnsupportedEncodingException {
        return new String(getBytes(),"UTF-8");
    }

    /**
     * 获取字节数组
     */
    public byte[] getBytes() {
        return body;
    }

    
}
