package edu.purdue.rkashuka.tangoalpha;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.microsoft.bing.speech.SpeechClientStatus;
import com.microsoft.cognitiveservices.speechrecognition.DataRecognitionClient;
import com.microsoft.cognitiveservices.speechrecognition.ISpeechRecognitionServerEvents;
import com.microsoft.cognitiveservices.speechrecognition.MicrophoneRecognitionClient;
import com.microsoft.cognitiveservices.speechrecognition.RecognitionResult;
import com.microsoft.cognitiveservices.speechrecognition.RecognitionStatus;
import com.microsoft.cognitiveservices.speechrecognition.SpeechRecognitionMode;
import com.microsoft.cognitiveservices.speechrecognition.SpeechRecognitionServiceFactory;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
/**
 * Created by lisacampbell on 11/13/16.
 */
/*
     * Speech recognition with data (for example from a file or audio source).
     * The data is broken up into buffers and each buffer is sent to the Speech Recognition Service.
     * No modification is done to the buffers, so the user can apply their
     * own VAD (Voice Activation Detection) or Silence Detection
     *
     * @param dataClient
     * @param recoMode
     * @param filename
     */
public class RecognitionTask extends AsyncTask<Void, Void, Void> {
    DataRecognitionClient dataClient;
    SpeechRecognitionMode recoMode;
    String filename;

    RecognitionTask(DataRecognitionClient dataClient, SpeechRecognitionMode recoMode, String filename) {
        this.dataClient = dataClient;
        this.recoMode = recoMode;
        this.filename = filename;
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            // Note for wave files, we can just send data from the file right to the server.
            // In the case you are not an audio file in wave format, and instead you have just
            // raw data (for example audio coming over bluetooth), then before sending up any
            // audio data, you must first send up an SpeechAudioFormat descriptor to describe
            // the layout and format of your raw audio data via DataRecognitionClient's sendAudioFormat() method.
            // String filename = recoMode == SpeechRecognitionMode.ShortPhrase ? "whatstheweatherlike.wav" : "batman.wav";
            //InputStream fileStream = getAssets().open(filename);
            InputStream fileStream = null;
            int bytesRead = 0;
            byte[] buffer = new byte[1024];

            do {
                // Get  Audio data to send into byte buffer.
                bytesRead = fileStream.read(buffer);

                if (bytesRead > -1) {
                    // Send of audio data to service.
                    dataClient.sendAudio(buffer, bytesRead);
                }
            } while (bytesRead > 0);

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        finally {
            dataClient.endAudio();
        }

        return null;
    }
}