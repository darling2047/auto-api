package com.darling.auto.utils;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author dll
 * @create 2020/5/31 20:49
 * @describe Bean转换工具类
 */
public class BeanCopierUtils {

    public BeanCopierUtils() {
    }

    public static <V, P> P convert(V base, P target) {
        if (base != null) {
            BeanCopier.create(base.getClass(), target.getClass(), false).copy(base, target, (Converter)null);
            return target;
        } else {
            return null;
        }
    }

    public static <V, P> P convert(V base, Class<P> target) {
        try {
            P obj = target.newInstance();
            if (base != null) {
                BeanCopier.create(base.getClass(), obj.getClass(), false).copy(base, obj, (Converter)null);
                return obj;
            }

            return null;
        } catch (InstantiationException var3) {
            var3.printStackTrace();
        } catch (IllegalAccessException var4) {
            var4.printStackTrace();
        }

        return null;
    }

    public static <V, P> List<P> convertList(List<V> baseList, Class<P> target) {
        if (baseList == null) {
            return null;
        } else {
            ArrayList targetList = new ArrayList();
            Iterator iter = baseList.iterator();

            while(iter.hasNext()) {
                Object vo = iter.next();

                try {
                    targetList.add(convert(vo, target.newInstance()));
                } catch (InstantiationException var6) {
                    var6.printStackTrace();
                } catch (IllegalAccessException var7) {
                    var7.printStackTrace();
                }
            }

            return targetList;
        }
    }
}
