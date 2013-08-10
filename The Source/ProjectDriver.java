/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voice.recognizer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.AudioFileFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


/**
 *
 * @author PeterTsongalis
 */
public class ProjectDriver {

    static public JFrame frame;
    static public JPanel panel;
    static public JButton record;
    static public JButton stop;
    static public File voiceFile;
    static public String text = "";

    public static void main(String[] args) throws Exception {
        //getting stuff ready
        
        frame = new JFrame();
        record = new JButton();
        stop = new JButton();
        panel = new JPanel();

        frame.setLayout(new BorderLayout());
        frame.setSize(new Dimension(400, 150));

        //set up microphone and recognizer
        final Microphone microphone = new Microphone(AudioFileFormat.Type.WAVE);
        final Recognizer recognizer = new Recognizer();

        //begin recording voice and output to file
        record.setText("Record");
        record.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    voiceFile = new File("/Users/PeterTsongalis/NetBeansProjects/Voice Recognizer/otherFiles/testVoice");
                    microphone.captureAudioToFile(voiceFile);
                } catch (Exception ex) {
                    System.out.println("error");
                }

            }
        });


        //gets response and prints to label    
        stop.setText("Stop Recording");
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                microphone.close();

                recognizer.setLanguage("en-US");
                GoogleResponse googleResponse;
                try {
                    googleResponse = recognizer.getRecognizedDataForWave(voiceFile);
                    text = googleResponse.getResponse();
                    doStuff(text);
                } catch (Exception ex) {
                    System.out.println("error");
                }

            }
        });

        panel.setLayout(new FlowLayout());
        panel.add(record);
        panel.add(stop);

        frame.add(panel);
        frame.setVisible(true);



        


        

    }
    
    
    public static void doStuff(String text) throws JavaLayerException, Exception {
        
        String returnedSpeakString;

        InputParser parse = new InputParser(text);
        System.out.println("first word = " + parse.findFirstCommandWord());
        String firstWord = parse.findFirstCommandWord();

        List<String> wordList = parse.getOtherWords();

        FindCommand finder = new FindCommand(firstWord, wordList);
        //System.out.println("wordList length = " + wordList.size());
        //System.out.println("word 0 length = " + wordList.get(0).length());

        returnedSpeakString = finder.executeCommandClass();

        Synthesiser synthesiser = new Synthesiser();
        Player player = new Player(synthesiser.getMP3Data(returnedSpeakString));
        player.play();
        
        
    }
    
    
    
}
