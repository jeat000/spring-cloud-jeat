package com.jeat.learn.bandingCPU;

import net.openhft.affinity.AffinityLock;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Banding
 * @Author chenjian
 * @Date 2021-06-21 10:49
 */
public class Banding {
    public static void main(String[] args) {
        try (AffinityLock affinityLock = AffinityLock.acquireLock(5)) {
            // do some work while locked to a CPU.
            while(true) {}
        }
    }
}
