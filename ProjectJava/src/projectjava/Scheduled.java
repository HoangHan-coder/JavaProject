/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Nguyen Hoang Han - CE192048
 */
public class Scheduled extends Assignment {
    private long delay;
    private String soundEffect;
    
     public Scheduled() {
         this.delay = 1;
         this.soundEffect = "Default Sound";
     }
     
     public Scheduled(long delay, String soundEffect) {
         this.delay = delay;
         this.soundEffect = soundEffect;
     }
     
     public String notification(LocalDateTime deadline, int checkDeadline) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime notifyTime = deadline.minus(delay, ChronoUnit.HOURS);

        if (checkDeadline == 1) {
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
        System.out.println("Playing sound: " + soundEffect + " 🔔");
    }
    
    public void setSoundEffect(String soundEffect) {
        this.soundEffect = soundEffect;
    }
    }
