/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Scheduled {

    private long delay;
    private String soundEffectPath;

    public Scheduled() {
        this.delay = 1;
        this.soundEffectPath = "D:\\Documents\\FPT_Education\\SP25\\PRO192\\ProjectJava\\JavaProject\\ProjectJava\\src\\projectjava\\SoundEffect1.wav";  // Đường dẫn mặc định
    }

    public Scheduled(long delay, String soundEffectPath) {
        this.delay = delay;
        this.soundEffectPath = soundEffectPath;
    }

    public String notification(LocalDateTime deadline) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime notifyTime = deadline.minus(delay, ChronoUnit.HOURS);

        if (now.isBefore(deadline)) {
            if (now.isAfter(notifyTime) && now.isBefore(deadline)) {
                soundEffect();
                return "🔔 Reminder: Your deadline is in " + delay + " hour(s)!";
            }
            return "⌛ No reminder yet.";
        } else {
            return "❌ Deadline is over!";
        }
    }
        

    public void soundEffect() {
    try {
        File soundFile = new File(soundEffectPath);
        if (!soundFile.exists()) {
            System.out.println("⚠ Sound file not found: " + soundEffectPath);
            return;
        }

        System.out.println("🔍 Trying to play: " + soundEffectPath);

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();

        System.out.println("🔊 Playing sound...");

        // Chờ đến khi âm thanh phát xong
        Thread.sleep(clip.getMicrosecondLength() / 1000);

        clip.close();
        audioStream.close();
    } catch (Exception e) {
        System.out.println("❌ Error while playing sound: " + e.getMessage());
        e.printStackTrace();
    }
}

    public void setSoundEffectPath(String soundEffectPath) {
        this.soundEffectPath = soundEffectPath;
    }

    public static void main(String[] args) {
        Scheduled reminder = new Scheduled(1, "reminder.wav"); // Đặt tệp âm thanh
        reminder.soundEffect(); // Kiểm tra phát nhạc
    }
}