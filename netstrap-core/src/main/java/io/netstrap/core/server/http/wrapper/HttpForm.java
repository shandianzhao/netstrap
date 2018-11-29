package io.netstrap.core.server.http.wrapper;


import io.netty.handler.codec.http.multipart.MixedFileUpload;

import java.util.*;

/**
 * Http请求表单
 * @author minghu.zhang
 * @date 2018/11/07
 */
public class HttpForm {

    /**
     * 表单 参数
     */
    private Map<String, List<String>> params;
    /**
     * 文件参数
     */
    private Map<String,List<MixedFileUpload>> uploads;

    /**
     * 获取参数表
     * @return List<String>
     */
    public List<String> getParams(String key) {
        return params.get(key);
    }

    /**
     * 获取参数
     * @param key 参数名
     * @return String
     */
    public String getParam(String key) {
        return params.get(key).get(0);
    }

    /**
     * 获取文件参数
     * @param key 参数名
     * @return MixedFileUpload
     */
    public MixedFileUpload getUpload(String key) {
        return uploads.get(key).get(0);
    }

    /**
     * 获取文件参数
     * @param key 参数名
     * @return List<MixedFileUpload>
     */
    public List<MixedFileUpload> getUploads(String key) {
        return uploads.get(key);
    }

    /**
     * 添加表单参数
     * @param name 参数名
     * @param value 参数值
     */
    public void param(String name,String value) {

        if(Objects.isNull(uploads)) {
            params = new HashMap(8);
        }

        if(params.containsKey(name)) {
            params.get(name).add(value);
        } else {
            List<String> values = new ArrayList<>();
            values.add(value);
            params.put(name, values);
        }
    }

    /**
     * 添加上传文件
     * @param key    参数名
     * @param upload 参数值
     */
    public void upload(String key, MixedFileUpload upload) {

        if(Objects.isNull(uploads)) {
            uploads = new HashMap<>(8);
        }

        if(uploads.containsKey(key)) {
            uploads.get(key).add(upload);
        } else {
            List<MixedFileUpload> files = new ArrayList<>();
            files.add(upload);
            uploads.put(key, files);
        }
    }
}
