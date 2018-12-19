package com.mmall.concurrency.exmple.immutableExample;



import com.google.common.collect.Maps;
import com.mmall.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
@Slf4j
@NotThreadSafe
public class ImmutableExample1 {
    private static final int a = 1;
    private static final  String  b = "fuck";
    private static final Map<Integer,Integer> map = Maps.newHashMap();
    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
    }

    public static void main(String[] args) {
        map.put(1,3);
        log.info("{}",map.get(1));
    }

    private void test(final int a ) {
        //a=1;
    }
}
