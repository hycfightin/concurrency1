package com.mmall.concurrency.exmple.immutableExample;




import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
public class ImmutableExample3 {
    private static final ImmutableList list = ImmutableList.of("a");//.of(1,2,3);
    private static final ImmutableSet set = ImmutableSet.copyOf(list);
    private static final ImmutableMap<Integer,Integer> map = ImmutableMap.of(1,2);
    private static final ImmutableMap<Integer,Integer> map1 = ImmutableMap.<Integer,Integer>builder().put(1,2).put(2,3).build();

    public static void main(String[] args) {
        System.out.println(set);
        System.out.println(map1);
        System.out.println();
    }


}
