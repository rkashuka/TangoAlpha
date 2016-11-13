package edu.purdue.rkashuka.tangoalpha;

/**
 * Created by Rohan on 11/13/16.
 */

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


public class AudioInfo {
    private String decoder;
    private int samplingRate = -1;
    private int channels = -1;
    private int bitRate = -1;

    public AudioInfo() {
    }

    public String getDecoder() {
        return this.decoder;
    }

    void setDecoder(String format) {
        this.decoder = format;
    }

    public int getSamplingRate() {
        return this.samplingRate;
    }

    void setSamplingRate(int samplingRate) {
        this.samplingRate = samplingRate;
    }

    public int getChannels() {
        return this.channels;
    }

    void setChannels(int channels) {
        this.channels = channels;
    }

    public int getBitRate() {
        return this.bitRate;
    }

    void setBitRate(int bitRate) {
        this.bitRate = bitRate;
    }

    public String toString() {
        return this.getClass().getName() + " (decoder=" + this.decoder + ", samplingRate=" + this.samplingRate + ", channels=" + this.channels + ", bitRate=" + this.bitRate + ")";
    }
}
