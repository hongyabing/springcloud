package com.demo.serviceprovider.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Jason
 * @description: TODO
 * @date 2019/5/21 15:27
 */
public class ObjSerializeUtil {
    public ObjSerializeUtil() {
    }

    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;

        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception var4) {
            throw new RuntimeException("序列化时出错", var4);
        }
    }

    public static Object unserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;

        try {
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception var3) {
            throw new RuntimeException("反序列化时出错", var3);
        }
    }

    /*public static <T> T clone(T inObject) {
        Object outer = null;

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(inObject);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            outer = ois.readObject();
            return outer;
        } catch (Exception var6) {
            throw new RuntimeException("序列化克隆时出错", var6);
        }
    }*/
}
