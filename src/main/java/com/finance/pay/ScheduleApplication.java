package com.finance.pay;

import com.finance.pay.ui.mainWindow;
import com.finance.util.database.ConnClient;
import org.apache.ibatis.session.SqlSession;

import java.awt.*;

/**
 * application start
 */
public class ScheduleApplication {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                // db test
                SqlSession db = ConnClient.getSession();
                String test = db.selectOne("test.getTest");
                if(test.equals("SUCCESS")) {
                    System.out.println("DB TEST OK");
                }

                mainWindow main = new mainWindow();
                main.start();
            } catch(Exception e) {
                e.printStackTrace();
            }
        });
    }
}
