/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import java.time.LocalDateTime;

/**
 *
 * @author  Lam Ngoc Diem My - CE190083
 */
public interface DateTime {
    int checkDeadline(LocalDateTime now, LocalDateTime deadline);
}
