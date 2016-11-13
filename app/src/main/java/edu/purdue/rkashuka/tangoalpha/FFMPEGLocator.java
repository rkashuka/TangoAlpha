package edu.purdue.rkashuka.tangoalpha;

/**
 * Created by Rohan on 11/13/16.
 */

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//



import edu.purdue.rkashuka.tangoalpha.FFMPEGExecutor;

public abstract class FFMPEGLocator {
    public FFMPEGLocator() {
    }

    protected abstract String getFFMPEGExecutablePath();

    edu.purdue.rkashuka.tangoalpha.FFMPEGExecutor createExecutor() {
        return new edu.purdue.rkashuka.tangoalpha.FFMPEGExecutor(this.getFFMPEGExecutablePath());
    }
}
