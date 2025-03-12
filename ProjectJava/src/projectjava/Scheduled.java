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
     
     public String notification(LocalDateTime deadline) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime notifyTime = deadline.minus(delay, ChronoUnit.HOURS);
    
        if (now.isBefore(deadline)) {
            if (now.isAfter(notifyTime)) {
                soundEffect();
                return "Reminder: Your deadline is in 1 hour!";
            }
            return "No reminder yet.";
        } else {
            return "Deadline is over!";
        }
    }
    
    public void soundEffect() {
        System.out.println("Playing sound: " + soundEffect + " 🔔");
    }

    }
