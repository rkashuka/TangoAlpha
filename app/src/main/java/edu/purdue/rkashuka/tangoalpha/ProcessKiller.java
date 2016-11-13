package edu.purdue.rkashuka.tangoalpha;

/**
 * Created by Rohan on 11/13/16.
 */

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


class ProcessKiller extends Thread {
    private Process process;

    public ProcessKiller(Process process) {
        this.process = process;
    }

    public void run() {
        this.process.destroy();
    }
}
