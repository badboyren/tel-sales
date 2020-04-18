package com.cx.tel.sales.commons.utils.serializable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang.SerializationException;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import static com.alibaba.fastjson.util.IOUtils.close;

/**
 * Json序列化工具
 * Created by badboy
 */

public class SerializableUtil<T> {

    public byte[] serialize(T t) throws SerializationException {
        return JSON.toJSONBytes(t, new SerializerFeature[]{SerializerFeature.WriteNullListAsEmpty});
    }

    public T deserialize(byte[] bytes,Class<T> type) throws SerializationException {
        if (bytes==null)
            return null;
        return JSON.parseObject(bytes,type);
    }

    public <T> List<T> deserializeList(byte[] bytes, Class<T> type) throws SerializationException {
        if (bytes==null)
            return null;
        return JSON.parseArray(new String(bytes),type);
    }
    /**
     * 列表序列化（用于Redis整存整取）
     * @param value
     * @return
     */
    public static <T> byte[] serialize(List<T> value) {
        if (value == null) {
            throw new NullPointerException("Can't serialize null");
        }
        byte[] rv=null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        try {
            bos = new ByteArrayOutputStream();
            try {
                os = new ObjectOutputStream(bos);
            } catch (IOException e) {
                e.printStackTrace();
            }
            for(T obj : value){
                os.writeObject(obj);
            }
            os.writeObject(null);
            os.close();
            bos.close();
            rv = bos.toByteArray();
        } catch (IOException e) {
            throw new IllegalArgumentException("Non-serializable object", e);
        } finally {
            close(os);
            close(bos);
        }
        return rv;
    }
}
