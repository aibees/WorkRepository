package com.finance.pay;

import com.finance.pay.ui.mainWindow;

import java.awt.*;

/**
 * application start
 */
public class ScheduleApplication {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                mainWindow main = new mainWindow();
                main.start();
            } catch(Exception e) {
                e.printStackTrace();
            }
        });
    }
}
