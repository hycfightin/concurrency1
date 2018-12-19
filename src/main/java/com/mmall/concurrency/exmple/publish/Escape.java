package com.mmall.concurrency.exmple.publish;

import com.mmall.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
public class Escape {
    private int ThisCanBeEscape = 0;
    public  Escape() {
        new InnerClass();
    }
    private class  InnerClass {
        public InnerClass() {
            log.info("{}",Escape.this.ThisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
