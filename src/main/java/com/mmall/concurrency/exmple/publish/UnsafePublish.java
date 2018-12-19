package com.mmall.concurrency.exmple.publish;

import com.mmall.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@NotThreadSafe
public class UnsafePublish {
    private String [] states = {"a","b","c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish UnsafePublish = new UnsafePublish();
        log.info("array{}", Arrays.toString(UnsafePublish.getStates()));
        UnsafePublish.getStates()[0] = "d";
        log.info("array{}", Arrays.toString(UnsafePublish.getStates()));
    }
}
