package com.finance.pay.ui.tabbed;

import com.finance.pay.service.WorkListService;
import com.finance.vo.WorkListVo;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class WorkListTab extends JPanel {

    private final WorkListService workListService = new WorkListService();

    private final Map<String, Object> WorkListMapper = new HashMap<>();
    private final Border BlackLineBorder = new LineBorder(Color.BLACK, 2);
    private String workcd = "";

    public WorkListTab() {
        this.setBackground(Color.WHITE);
        this.createWorkList();
    }

    private void createWorkList() {
        this.setLayout(null); // absolute layout
        this.setBackground(Color.lightGray);
        this.paintLeftSize();
        this.paintRightSize();
    }

    ////////////// left ////////////
    private void paintLeftSize() {
        // 업무리스트
        this.createLabel("업무리스트", 0, 30, 100, 20);
        this.createTitleListView();
        // 제목
        this.createLabel("제목", 290, 30, 50, 20);
        this.createTitleTextLine();
        this.createLabel("업무기간", 290, 100, 80, 20);
        this.createDateField();
        this.createLabel("반복", 290, 170, 50, 20);
        this.createRepeatStatus();
    }

    /**
     * 업무리스트
     */
    private void createTitleListView() {
        // --test data--
        String[] test_work = {"NC202211001-업무인수인계", "NC202211002-[반복]SSL 갱신작업", "NC202211003-[개발]채권양수로직 리팩토링"};
        JList<String> workdata = new JList<>();

        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addAll(Arrays.asList(test_work));
        workdata.setModel(listModel);
        workdata.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        workdata.addListSelectionListener(e -> {
            if(!workcd.equals(workdata.getSelectedValue())) {
                workcd = workdata.getSelectedValue().split("-")[0];
                System.out.println("selected work : " + workcd);

                WorkListVo work = workListService.getWorkDataById(workcd);

                // title update
                JTextField title = (JTextField) this.WorkListMapper.get("title");
                if(title != null)
                    title.setText(work.getWorkTitle());
                else
                    title.setText(workcd);

                // fr & to update
                JFormattedTextField fr = (JFormattedTextField) this.WorkListMapper.get("frdate");
                if(fr != null)
                    fr.setValue(Date.from(work.getFrDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));

                JFormattedTextField to = (JFormattedTextField) this.WorkListMapper.get("todate");
                if(to != null)
                    to.setValue(Date.from(work.getToDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            }
        });
        // -------------

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 50, 250, 520);
        this.add(scrollPane);
        scrollPane.setViewportView(workdata);

        this.add(scrollPane);
    }

    /**
     * 타이틀
     */
    private void createTitleTextLine() {
        JTextField titleField = new JTextField();
        titleField.setBounds(290, 50, 300, 40);
        titleField.setForeground(Color.BLACK);
        titleField.setBackground(Color.WHITE);
        titleField.setBorder(BlackLineBorder);
        titleField.setFont(new Font("Helvetica", Font.PLAIN, 16));
        WorkListMapper.put("title", titleField);
        this.add(titleField);
    }

    /**
     * 업무기간 FROM & TO
     */
    private void createDateField() {
        SimpleDateFormat form = new SimpleDateFormat("yyyy / MM / dd");
        JFormattedTextField frDate = new JFormattedTextField(form);
        JFormattedTextField toDate = new JFormattedTextField(form);

        frDate.setBounds(290, 120, 130, 40);
        frDate.setHorizontalAlignment(SwingConstants.CENTER);
        frDate.setForeground(Color.BLACK);
        frDate.setBackground(Color.WHITE);
        frDate.setBorder(BlackLineBorder);
        frDate.setFont(new Font("Helvetica", Font.PLAIN, 15));

        this.createLabel(" ~ ", 430, 125, 40, 30);

        toDate.setBounds(460, 120, 130, 40);
        toDate.setHorizontalAlignment(SwingConstants.CENTER);
        toDate.setForeground(Color.BLACK);
        toDate.setBackground(Color.WHITE);
        toDate.setBorder(BlackLineBorder);
        toDate.setFont(new Font("Helvetica", Font.PLAIN, 15));

        WorkListMapper.put("frdate", frDate);
        this.add(frDate);
        WorkListMapper.put("todate", toDate);
        this.add(toDate);
    }

    /**
     * 반복여부
     */
    private void createRepeatStatus() {
        String[] radio_name = {"0.반복 없음", "1.주", "2.월", "3.년", "4.비규칙적"};

    }

    //////////// right ////////////
    private void paintRightSize() {
        this.createLabel("업무세부내용", 650, 30, 100, 20);
        // buttons
        this.createNewWorkButton();
        this.updateNewWorkButton();
        this.deleteNewWorkButton();

        // text area
        this.createDescription();
    }

    /**
     * 업무내역 기록 textarea
     */
    private void createDescription() {
        JTextArea desc = new JTextArea();
        desc.setBounds(650, 50, 400, 520);
        desc.setBorder(BlackLineBorder);
        desc.setFont(new Font("Helvetica", Font.BOLD, 16));
        this.add(desc);
    }

    /**
     * 업무 생성버튼
     */
    private void createNewWorkButton() {
        JButton createWorkBtn = new JButton("생성");
        createWorkBtn.setBounds(850, 15, 60, 30);
        createWorkBtn.setForeground(Color.WHITE);
        createWorkBtn.setBackground(new Color(45, 180, 0));
        createWorkBtn.setBorder(BlackLineBorder);
        createWorkBtn.setFont(new Font("Helvetica", Font.BOLD, 13));

        createWorkBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "test!");
        });

        this.add(createWorkBtn);
    }

    /**
     * 업무 수정버튼
     */
    private void updateNewWorkButton() {
        JButton updateWorkBtn = new JButton("수정");
        updateWorkBtn.setBounds(920, 15, 60, 30);
        updateWorkBtn.setForeground(Color.WHITE);
        updateWorkBtn.setBackground(Color.darkGray);
        updateWorkBtn.setBorder(BlackLineBorder);
        updateWorkBtn.setFont(new Font("Helvetica", Font.BOLD, 13));

        updateWorkBtn.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "변경사항 저장 ㄱ?");
            // 0 : Yes, 1 : No, 2 : Cancel
            if(confirm == 0 && !workcd.isEmpty()) {
                System.out.println("confirm : " + confirm + ", workId : " + workcd);
                workListService.deleteWorkDataById(workcd);
                this.update();
            }
        });

        this.add(updateWorkBtn);
    }

    /**
     * 업무 삭제버튼
     */
    private void deleteNewWorkButton() {
        JButton deleteWorkBtn = new JButton("삭제");
        deleteWorkBtn.setBounds(990, 15, 60, 30);
        deleteWorkBtn.setForeground(Color.WHITE);
        deleteWorkBtn.setBackground(Color.darkGray);
        deleteWorkBtn.setBorder(BlackLineBorder);
        deleteWorkBtn.setFont(new Font("Helvetica", Font.BOLD, 13));

        deleteWorkBtn.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "정말 삭제 ㄱ?");
            // 0 : Yes, 1 : No, 2 : Cancel
            if(confirm == 0 && !workcd.isEmpty()) {
                System.out.println("confirm : " + confirm + ", workId : " + workcd);
                workListService.deleteWorkDataById(workcd);
                this.update();
            }
        });

        this.add(deleteWorkBtn);
    }

    /**********************
     ****    공통함수    ****
     **********************/

    private void update() {
        this.workcd = "";
    }

    private void createLabel(String text, int x, int y, int w, int h) {
        JLabel label = new JLabel(text);
        label.setLocation(x, y);
        label.setSize(w, h);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        this.add(label);
    }
}
