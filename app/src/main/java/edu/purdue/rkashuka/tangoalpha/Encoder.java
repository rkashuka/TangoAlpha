package edu.purdue.rkashuka.tangoalpha;

/**
 * Created by Rohan on 11/13/16.
 */

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;






import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Encoder {
    private static final Pattern FORMAT_PATTERN = Pattern.compile("^\\s*([D ])([E ])\\s+([\\w,]+)\\s+.+$");
    private static final Pattern ENCODER_DECODER_PATTERN = Pattern.compile("^\\s*([D ])([E ])([AVS]).{3}\\s+(.+)$", 2);
    private static final Pattern PROGRESS_INFO_PATTERN = Pattern.compile("\\s*(\\w+)\\s*=\\s*(\\S+)\\s*", 2);
    private static final Pattern SIZE_PATTERN = Pattern.compile("(\\d+)x(\\d+)", 2);
    private static final Pattern FRAME_RATE_PATTERN = Pattern.compile("([\\d.]+)\\s+(?:fps|tb\\(r\\))", 2);
    private static final Pattern BIT_RATE_PATTERN = Pattern.compile("(\\d+)\\s+kb/s", 2);
    private static final Pattern SAMPLING_RATE_PATTERN = Pattern.compile("(\\d+)\\s+Hz", 2);
    private static final Pattern CHANNELS_PATTERN = Pattern.compile("(mono|stereo)", 2);
    private static final Pattern SUCCESS_PATTERN = Pattern.compile("^\\s*video\\:\\S+\\s+audio\\:\\S+\\s+global headers\\:\\S+.*$", 2);
    public edu.purdue.rkashuka.tangoalpha.FFMPEGLocator locator;

    public Encoder() {
        this.locator = new DefaultFFMPEGLocator();
    }

    public Encoder(FFMPEGLocator locator) {
        this.locator = locator;
    }

    public String[] getAudioDecoders() throws EncoderException {
        ArrayList res = new ArrayList();
        edu.purdue.rkashuka.tangoalpha.FFMPEGExecutor ffmpeg = this.locator.createExecutor();
        ffmpeg.addArgument("-formats");

        try {
            ffmpeg.execute();
            RBufferedReader size = null;
            size = new RBufferedReader(new InputStreamReader(ffmpeg.getInputStream()));
            boolean i = false;

            String ret;
            while((ret = size.readLine()) != null) {
                if(ret.trim().length() != 0) {
                    if(i) {
                        Matcher matcher = ENCODER_DECODER_PATTERN.matcher(ret);
                        if(!matcher.matches()) {
                            break;
                        }

                        String decoderFlag = matcher.group(1);
                        String audioVideoFlag = matcher.group(3);
                        if("D".equals(decoderFlag) && "A".equals(audioVideoFlag)) {
                            String name = matcher.group(4);
                            res.add(name);
                        }
                    } else if(ret.trim().equals("Codecs:")) {
                        i = true;
                    }
                }
            }
        } catch (IOException var14) {
            throw new EncoderException(var14);
        } finally {
            ffmpeg.destroy();
        }

        int var16 = res.size();
        String[] var17 = new String[var16];

        for(int var18 = 0; var18 < var16; ++var18) {
            var17[var18] = (String)res.get(var18);
        }

        return var17;
    }

    public String[] getAudioEncoders() throws EncoderException {
        ArrayList res = new ArrayList();
        FFMPEGExecutor ffmpeg = this.locator.createExecutor();
        ffmpeg.addArgument("-formats");

        try {
            ffmpeg.execute();
            RBufferedReader size = null;
            size = new RBufferedReader(new InputStreamReader(ffmpeg.getInputStream()));
            boolean i = false;

            String ret;
            while((ret = size.readLine()) != null) {
                if(ret.trim().length() != 0) {
                    if(i) {
                        Matcher matcher = ENCODER_DECODER_PATTERN.matcher(ret);
                        if(!matcher.matches()) {
                            break;
                        }

                        String encoderFlag = matcher.group(2);
                        String audioVideoFlag = matcher.group(3);
                        if("E".equals(encoderFlag) && "A".equals(audioVideoFlag)) {
                            String name = matcher.group(4);
                            res.add(name);
                        }
                    } else if(ret.trim().equals("Codecs:")) {
                        i = true;
                    }
                }
            }
        } catch (IOException var14) {
            throw new EncoderException(var14);
        } finally {
            ffmpeg.destroy();
        }

        int var16 = res.size();
        String[] var17 = new String[var16];

        for(int var18 = 0; var18 < var16; ++var18) {
            var17[var18] = (String)res.get(var18);
        }

        return var17;
    }

    public String[] getVideoDecoders() throws EncoderException {
        ArrayList res = new ArrayList();
        FFMPEGExecutor ffmpeg = this.locator.createExecutor();
        ffmpeg.addArgument("-formats");

        try {
            ffmpeg.execute();
            RBufferedReader size = null;
            size = new RBufferedReader(new InputStreamReader(ffmpeg.getInputStream()));
            boolean i = false;

            String ret;
            while((ret = size.readLine()) != null) {
                if(ret.trim().length() != 0) {
                    if(i) {
                        Matcher matcher = ENCODER_DECODER_PATTERN.matcher(ret);
                        if(!matcher.matches()) {
                            break;
                        }

                        String decoderFlag = matcher.group(1);
                        String audioVideoFlag = matcher.group(3);
                        if("D".equals(decoderFlag) && "V".equals(audioVideoFlag)) {
                            String name = matcher.group(4);
                            res.add(name);
                        }
                    } else if(ret.trim().equals("Codecs:")) {
                        i = true;
                    }
                }
            }
        } catch (IOException var14) {
            throw new EncoderException(var14);
        } finally {
            ffmpeg.destroy();
        }

        int var16 = res.size();
        String[] var17 = new String[var16];

        for(int var18 = 0; var18 < var16; ++var18) {
            var17[var18] = (String)res.get(var18);
        }

        return var17;
    }

    public String[] getVideoEncoders() throws EncoderException {
        ArrayList res = new ArrayList();
        FFMPEGExecutor ffmpeg = this.locator.createExecutor();
        ffmpeg.addArgument("-formats");

        try {
            ffmpeg.execute();
            RBufferedReader size = null;
            size = new RBufferedReader(new InputStreamReader(ffmpeg.getInputStream()));
            boolean i = false;

            String ret;
            while((ret = size.readLine()) != null) {
                if(ret.trim().length() != 0) {
                    if(i) {
                        Matcher matcher = ENCODER_DECODER_PATTERN.matcher(ret);
                        if(!matcher.matches()) {
                            break;
                        }

                        String encoderFlag = matcher.group(2);
                        String audioVideoFlag = matcher.group(3);
                        if("E".equals(encoderFlag) && "V".equals(audioVideoFlag)) {
                            String name = matcher.group(4);
                            res.add(name);
                        }
                    } else if(ret.trim().equals("Codecs:")) {
                        i = true;
                    }
                }
            }
        } catch (IOException var14) {
            throw new EncoderException(var14);
        } finally {
            ffmpeg.destroy();
        }

        int var16 = res.size();
        String[] var17 = new String[var16];

        for(int var18 = 0; var18 < var16; ++var18) {
            var17[var18] = (String)res.get(var18);
        }

        return var17;
    }

    public String[] getSupportedEncodingFormats() throws EncoderException {
        ArrayList res = new ArrayList();
        FFMPEGExecutor ffmpeg = this.locator.createExecutor();
        ffmpeg.addArgument("-formats");

        try {
            ffmpeg.execute();
            RBufferedReader size = null;
            size = new RBufferedReader(new InputStreamReader(ffmpeg.getInputStream()));
            boolean i = false;

            String ret;
            while((ret = size.readLine()) != null) {
                if(ret.trim().length() != 0) {
                    if(i) {
                        Matcher matcher = FORMAT_PATTERN.matcher(ret);
                        if(!matcher.matches()) {
                            break;
                        }

                        String encoderFlag = matcher.group(2);
                        if("E".equals(encoderFlag)) {
                            String aux = matcher.group(3);
                            StringTokenizer st = new StringTokenizer(aux, ",");

                            while(st.hasMoreTokens()) {
                                String token = st.nextToken().trim();
                                if(!res.contains(token)) {
                                    res.add(token);
                                }
                            }
                        }
                    } else if(ret.trim().equals("File formats:")) {
                        i = true;
                    }
                }
            }
        } catch (IOException var15) {
            throw new EncoderException(var15);
        } finally {
            ffmpeg.destroy();
        }

        int var17 = res.size();
        String[] var18 = new String[var17];

        for(int var19 = 0; var19 < var17; ++var19) {
            var18[var19] = (String)res.get(var19);
        }

        return var18;
    }

    public String[] getSupportedDecodingFormats() throws EncoderException {
        ArrayList res = new ArrayList();
        FFMPEGExecutor ffmpeg = this.locator.createExecutor();
        ffmpeg.addArgument("-formats");

        try {
            ffmpeg.execute();
            RBufferedReader size = null;
            size = new RBufferedReader(new InputStreamReader(ffmpeg.getInputStream()));
            boolean i = false;

            String ret;
            while((ret = size.readLine()) != null) {
                if(ret.trim().length() != 0) {
                    if(i) {
                        Matcher matcher = FORMAT_PATTERN.matcher(ret);
                        if(!matcher.matches()) {
                            break;
                        }

                        String decoderFlag = matcher.group(1);
                        if("D".equals(decoderFlag)) {
                            String aux = matcher.group(3);
                            StringTokenizer st = new StringTokenizer(aux, ",");

                            while(st.hasMoreTokens()) {
                                String token = st.nextToken().trim();
                                if(!res.contains(token)) {
                                    res.add(token);
                                }
                            }
                        }
                    } else if(ret.trim().equals("File formats:")) {
                        i = true;
                    }
                }
            }
        } catch (IOException var15) {
            throw new EncoderException(var15);
        } finally {
            ffmpeg.destroy();
        }

        int var17 = res.size();
        String[] var18 = new String[var17];

        for(int var19 = 0; var19 < var17; ++var19) {
            var18[var19] = (String)res.get(var19);
        }

        return var18;
    }

    public MultimediaInfo getInfo(File source) throws InputFormatException, EncoderException {
        FFMPEGExecutor ffmpeg = this.locator.createExecutor();
        ffmpeg.addArgument("-i");
        ffmpeg.addArgument(source.getAbsolutePath());

        try {
            ffmpeg.execute();
        } catch (IOException var10) {
            throw new EncoderException(var10);
        }

        MultimediaInfo var6;
        try {
            RBufferedReader reader = null;
            reader = new RBufferedReader(new InputStreamReader(ffmpeg.getErrorStream()));
            var6 = this.parseMultimediaInfo(source, reader);
        } finally {
            ffmpeg.destroy();
        }

        return var6;
    }

    private MultimediaInfo parseMultimediaInfo(File source, RBufferedReader reader) throws InputFormatException, EncoderException {
        Pattern p1 = Pattern.compile("^\\s*Input #0, (\\w+).+$\\s*");
        Pattern p2 = Pattern.compile("^\\s*Duration: (\\d\\d):(\\d\\d):(\\d\\d)\\.(\\d).*$");
        Pattern p3 = Pattern.compile("^\\s*Stream #\\S+: ((?:Audio)|(?:Video)|(?:Data)): (.*)\\s*$");
        MultimediaInfo info = null;

        try {
            int e = 0;

            while(true) {
                String line = reader.readLine();
                if(line == null) {
                    break;
                }

                String specs;
                String var23;
                if(e == 0) {
                    String m = source.getAbsolutePath() + ": ";
                    if(line.startsWith(m)) {
                        var23 = line.substring(m.length());
                        throw new InputFormatException(var23);
                    }

                    Matcher type = p1.matcher(line);
                    if(type.matches()) {
                        specs = type.group(1);
                        info = new MultimediaInfo();
                        info.setFormat(specs);
                        ++e;
                    }
                } else {
                    Matcher var22;
                    if(e == 1) {
                        var22 = p2.matcher(line);
                        if(var22.matches()) {
                            long var24 = (long)Integer.parseInt(var22.group(1));
                            long audio = (long)Integer.parseInt(var22.group(2));
                            long i = (long)Integer.parseInt(var22.group(3));
                            long parsed = (long)Integer.parseInt(var22.group(4));
                            long bitRate = parsed * 100L + i * 1000L + audio * 60L * 1000L + var24 * 60L * 60L * 1000L;
                            info.setDuration(bitRate);
                            ++e;
                        } else {
                            e = 3;
                        }
                    } else if(e == 2) {
                        var22 = p3.matcher(line);
                        if(var22.matches()) {
                            var23 = var22.group(1);
                            specs = var22.group(2);
                            StringTokenizer st;
                            String token;
                            Matcher m2;
                            int var27;
                            boolean var28;
                            int var29;
                            if("Video".equalsIgnoreCase(var23)) {
                                VideoInfo var25 = new VideoInfo();
                                st = new StringTokenizer(specs, ",");

                                for(var27 = 0; st.hasMoreTokens(); ++var27) {
                                    token = st.nextToken().trim();
                                    if(var27 == 0) {
                                        var25.setDecoder(token);
                                    } else {
                                        var28 = false;
                                        m2 = SIZE_PATTERN.matcher(token);
                                        if(!var28 && m2.find()) {
                                            var29 = Integer.parseInt(m2.group(1));
                                            int height = Integer.parseInt(m2.group(2));
                                            var25.setSize(new VideoSize(var29, height));
                                            var28 = true;
                                        }

                                        m2 = FRAME_RATE_PATTERN.matcher(token);
                                        if(!var28 && m2.find()) {
                                            try {
                                                float var30 = Float.parseFloat(m2.group(1));
                                                var25.setFrameRate(var30);
                                            } catch (NumberFormatException var20) {
                                                ;
                                            }

                                            var28 = true;
                                        }

                                        m2 = BIT_RATE_PATTERN.matcher(token);
                                        if(!var28 && m2.find()) {
                                            var29 = Integer.parseInt(m2.group(1));
                                            var25.setBitRate(var29);
                                            var28 = true;
                                        }
                                    }
                                }

                                info.setVideo(var25);
                            } else if("Audio".equalsIgnoreCase(var23)) {
                                AudioInfo var26 = new AudioInfo();
                                st = new StringTokenizer(specs, ",");

                                for(var27 = 0; st.hasMoreTokens(); ++var27) {
                                    token = st.nextToken().trim();
                                    if(var27 == 0) {
                                        var26.setDecoder(token);
                                    } else {
                                        var28 = false;
                                        m2 = SAMPLING_RATE_PATTERN.matcher(token);
                                        if(!var28 && m2.find()) {
                                            var29 = Integer.parseInt(m2.group(1));
                                            var26.setSamplingRate(var29);
                                            var28 = true;
                                        }

                                        m2 = CHANNELS_PATTERN.matcher(token);
                                        if(!var28 && m2.find()) {
                                            String var31 = m2.group(1);
                                            if("mono".equalsIgnoreCase(var31)) {
                                                var26.setChannels(1);
                                            } else if("stereo".equalsIgnoreCase(var31)) {
                                                var26.setChannels(2);
                                            }

                                            var28 = true;
                                        }

                                        m2 = BIT_RATE_PATTERN.matcher(token);
                                        if(!var28 && m2.find()) {
                                            var29 = Integer.parseInt(m2.group(1));
                                            var26.setBitRate(var29);
                                            var28 = true;
                                        }
                                    }
                                }

                                info.setAudio(var26);
                            }
                        } else {
                            e = 3;
                        }
                    }
                }

                if(e == 3) {
                    reader.reinsertLine(line);
                    break;
                }
            }
        } catch (IOException var21) {
            throw new EncoderException(var21);
        }

        if(info == null) {
            throw new InputFormatException();
        } else {
            return info;
        }
    }

    private Hashtable parseProgressInfoLine(String line) {
        Hashtable table = null;
        Matcher m = PROGRESS_INFO_PATTERN.matcher(line);

        while(m.find()) {
            if(table == null) {
                table = new Hashtable();
            }

            String key = m.group(1);
            String value = m.group(2);
            table.put(key, value);
        }

        return table;
    }

    public void encode(File source, File target, edu.purdue.rkashuka.tangoalpha.EncodingAttributes attributes) throws IllegalArgumentException, InputFormatException, EncoderException {
        this.encode(source, target, attributes, (EncoderProgressListener)null);
    }

    public void encode(File source, File target, edu.purdue.rkashuka.tangoalpha.EncodingAttributes attributes, EncoderProgressListener listener) throws IllegalArgumentException, InputFormatException, EncoderException {
        String formatAttribute = attributes.getFormat();
        Float offsetAttribute = attributes.getOffset();
        Float durationAttribute = attributes.getDuration();
        AudioAttributes audioAttributes = attributes.getAudioAttributes();
        VideoAttributes videoAttributes = attributes.getVideoAttributes();
        if(audioAttributes == null && videoAttributes == null) {
            throw new IllegalArgumentException("Both audio and video attributes are null");
        } else {
            target = target.getAbsoluteFile();
            target.getParentFile().mkdirs();
            FFMPEGExecutor ffmpeg = this.locator.createExecutor();
            if(offsetAttribute != null) {
                ffmpeg.addArgument("-ss");
                ffmpeg.addArgument(String.valueOf(offsetAttribute.floatValue()));
            }

            ffmpeg.addArgument("-i");
            ffmpeg.addArgument(source.getAbsolutePath());
            if(durationAttribute != null) {
                ffmpeg.addArgument("-t");
                ffmpeg.addArgument(String.valueOf(durationAttribute.floatValue()));
            }

            String e;
            Integer channels;
            Integer progress;
            if(videoAttributes == null) {
                ffmpeg.addArgument("-vn");
            } else {
                e = videoAttributes.getCodec();
                if(e != null) {
                    ffmpeg.addArgument("-vcodec");
                    ffmpeg.addArgument(e);
                }

                String duration = videoAttributes.getTag();
                if(duration != null) {
                    ffmpeg.addArgument("-vtag");
                    ffmpeg.addArgument(duration);
                }

                channels = videoAttributes.getBitRate();
                if(channels != null) {
                    ffmpeg.addArgument("-b");
                    ffmpeg.addArgument(String.valueOf(channels.intValue()));
                }

                progress = videoAttributes.getFrameRate();
                if(progress != null) {
                    ffmpeg.addArgument("-r");
                    ffmpeg.addArgument(String.valueOf(progress.intValue()));
                }

                VideoSize volume = videoAttributes.getSize();
                if(volume != null) {
                    ffmpeg.addArgument("-s");
                    ffmpeg.addArgument(String.valueOf(volume.getWidth()) + "x" + volume.getHeight());
                }
            }

            if(audioAttributes == null) {
                ffmpeg.addArgument("-an");
            } else {
                e = audioAttributes.getCodec();
                if(e != null) {
                    ffmpeg.addArgument("-acodec");
                    ffmpeg.addArgument(e);
                }

                Integer var40 = audioAttributes.getBitRate();
                if(var40 != null) {
                    ffmpeg.addArgument("-ab");
                    ffmpeg.addArgument(String.valueOf(var40.intValue()));
                }

                channels = audioAttributes.getChannels();
                if(channels != null) {
                    ffmpeg.addArgument("-ac");
                    ffmpeg.addArgument(String.valueOf(channels.intValue()));
                }

                progress = audioAttributes.getSamplingRate();
                if(progress != null) {
                    ffmpeg.addArgument("-ar");
                    ffmpeg.addArgument(String.valueOf(progress.intValue()));
                }

                Integer var43 = audioAttributes.getVolume();
                if(var43 != null) {
                    ffmpeg.addArgument("-vol");
                    ffmpeg.addArgument(String.valueOf(var43.intValue()));
                }
            }

            ffmpeg.addArgument("-f");
            ffmpeg.addArgument(formatAttribute);
            ffmpeg.addArgument("-y");
            ffmpeg.addArgument(target.getAbsolutePath());

            try {
                ffmpeg.execute();
            } catch (IOException var37) {
                throw new EncoderException(var37);
            }

            try {
                e = null;
                long var42 = 0L;
                RBufferedReader reader = null;
                reader = new RBufferedReader(new InputStreamReader(ffmpeg.getErrorStream()));
                MultimediaInfo info = this.parseMultimediaInfo(source, reader);
                long var41;
                if(durationAttribute != null) {
                    var41 = (long)Math.round(durationAttribute.floatValue() * 1000.0F);
                } else {
                    var41 = info.getDuration();
                    if(offsetAttribute != null) {
                        var41 -= (long)Math.round(offsetAttribute.floatValue() * 1000.0F);
                    }
                }

                if(listener != null) {
                    listener.sourceInfo(info);
                }

                int step = 0;

                String line;
                while((line = reader.readLine()) != null) {
                    if(step == 0) {
                        if(line.startsWith("WARNING: ")) {
                            if(listener != null) {
                                listener.message(line);
                            }
                        } else {
                            if(!line.startsWith("Output #0")) {
                                throw new EncoderException(line);
                            }

                            ++step;
                        }
                    } else if(step == 1 && !line.startsWith("  ")) {
                        ++step;
                    }

                    if(step == 2) {
                        if(!line.startsWith("Stream mapping:")) {
                            throw new EncoderException(line);
                        }

                        ++step;
                    } else if(step == 3 && !line.startsWith("  ")) {
                        ++step;
                    }

                    if(step == 4) {
                        line = line.trim();
                        if(line.length() > 0) {
                            Hashtable table = this.parseProgressInfoLine(line);
                            if(table == null) {
                                if(listener != null) {
                                    listener.message(line);
                                }

                                e = line;
                            } else {
                                if(listener != null) {
                                    String time = (String)table.get("time");
                                    if(time != null) {
                                        int dot = time.indexOf(46);
                                        if(dot > 0 && dot == time.length() - 2 && var41 > 0L) {
                                            String p1 = time.substring(0, dot);
                                            String p2 = time.substring(dot + 1);

                                            try {
                                                long i1 = Long.parseLong(p1);
                                                long i2 = Long.parseLong(p2);
                                                var42 = i1 * 1000L + i2 * 100L;
                                                int perm = (int)Math.round((double)(var42 * 1000L) / (double)var41);
                                                if(perm > 1000) {
                                                    perm = 1000;
                                                }

                                                listener.progress(perm);
                                            } catch (NumberFormatException var36) {
                                                ;
                                            }
                                        }
                                    }
                                }

                                e = null;
                            }
                        }
                    }
                }

                if(e != null && !SUCCESS_PATTERN.matcher(e).matches()) {
                    throw new EncoderException(e);
                }
            } catch (IOException var38) {
                throw new EncoderException(var38);
            } finally {
                ffmpeg.destroy();
            }
        }
    }
}
