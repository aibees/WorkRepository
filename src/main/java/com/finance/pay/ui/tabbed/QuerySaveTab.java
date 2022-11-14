package com.finance.pay.ui.tabbed;

import com.finance.pay.vo.WorkListVo;
import com.finance.pay.vo.common.RepeatStatus;
import com.finance.pay.vo.common.WorkType;
import com.finance.util.Constant;
import com.finance.util.MOD;
import com.finance.util.SECTION;

import javax.swing.*;
import javax.swing.text.TextAction;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.finance.util.SECTION.*;
import static com.finance.util.SECTION.DESCRIPT;

public class QuerySaveTab extends JPanel {

    private final Map<SECTION, Object> queryPageMapper = new HashMap<>();

    public QuerySaveTab() {
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.paintCustomComponent();
    }

    private void paintCustomComponent() {
        try {
            this.paintItemList();
        } catch(Exception e) {

        }
    }

    private void paintItemList() {
        this.createLabel("Lists.", 200 , 80, 100, 20);
        this.createQueryList();

        this.createNewWorkButton();
        this.updateNewWorkButton();
        this.saveWorkButton();
        this.deleteNewWorkButton();

        this.createQueryTitle();
        this.createLabel("Queries.", 480, 80, 100, 20);
        this.createQueryPage();
        this.createLabel("Descriptions.", 480, 380, 100, 20);
        this.createQueryDesc();
        this.createQueryTag();
    }

    private void createQueryList() {
        // --test data--
        String[] test_work = {"NC202211001-업무인수인계", "NC202211002-[반복]SSL 갱신작업"};
        JList<String> queryList = new JList<>();

        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addAll(Arrays.asList(test_work));
        queryList.setModel(listModel);
        queryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        queryList.setFont(Constant.LIST_FONT);

        // -------------

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(200, 100, 270, 470);
        this.add(scrollPane);
        scrollPane.setBorder(Constant.BlackLineBorder);
        scrollPane.setViewportView(queryList);

        this.add(scrollPane);
    }

    /**
     * CREATE QUERY TITLE
     */
    private void createQueryTitle() {
        JTextField title = new JTextField();
        title.setBounds(480, 50, 410, 25);
        title.setForeground(Color.BLACK);
        title.setBackground(Color.WHITE);
        title.setBorder(Constant.BlackLineBorder);
        title.setFont(Constant.TEXTFIELD_FONT);
        this.queryPageMapper.put(QUERYTITLE, title);
        this.add(title);
    }

    /**
     * CREATE QUERY PAGE
     */
    private void createQueryPage() {
        JTextArea queryPage = new JTextArea();
        queryPage.setFont(Constant.QUERY_FONT);
//        queryPage.setLineWrap(true);
        queryPage.setBorder(BorderFactory.createCompoundBorder(
                Constant.BlackLineBorder,
                BorderFactory.createEmptyBorder(8, 5, 8, 5)
        ));

        JScrollPane pagePane = new JScrollPane(queryPage);
        pagePane.setBounds(480, 100, 410, 275);

        //undo redo (test)
        UndoManager doManager = new UndoManager();
        queryPage.getDocument().addUndoableEditListener(doManager);
        queryPage.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_MASK), "undo");
        queryPage.getActionMap().put("undo", new TextAction("undo") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(doManager.canUndo())
                    doManager.undo();
            }
        });

        queryPage.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_MASK), "redo");
        queryPage.getActionMap().put("redo", new TextAction("redo") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(doManager.canRedo())
                    doManager.redo();
            }
        });

        this.queryPageMapper.put(QUERYPAGE, queryPage);
        this.add(pagePane);
    }

    /**
     * CREATE QUERY DESC
     */
    private void createQueryDesc() {
        JTextArea queryDesc = new JTextArea();
        queryDesc.setFont(Constant.DESC_FONT);
        queryDesc.setLineWrap(true);
        queryDesc.setBorder(BorderFactory.createCompoundBorder(
                Constant.BlackLineBorder,
                BorderFactory.createEmptyBorder(8, 5, 8, 5)
        ));

        JScrollPane pagePane = new JScrollPane(queryDesc);
        pagePane.setBounds(480, 400, 410, 135);

        //undo redo (test)
        UndoManager doManager = new UndoManager();
        queryDesc.getDocument().addUndoableEditListener(doManager);
        queryDesc.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_MASK), "undo");
        queryDesc.getActionMap().put("undo", new TextAction("undo") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(doManager.canUndo())
                    doManager.undo();
            }
        });

        queryDesc.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_MASK), "redo");
        queryDesc.getActionMap().put("redo", new TextAction("redo") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(doManager.canRedo())
                    doManager.redo();
            }
        });

        this.queryPageMapper.put(QUERYDESC, queryDesc);
        this.add(pagePane);
    }

    /**
     * CREATE QUERY TAG
     */
    private void createQueryTag() {
        JTextField tag = new JTextField();
        tag.setBounds(480, 540, 410, 30);
        tag.setForeground(Color.BLACK);
        tag.setBackground(Color.WHITE);
        tag.setBorder(Constant.BlackLineBorder);
        tag.setFont(Constant.TEXTFIELD_FONT);
        this.queryPageMapper.put(QUERYTAG, tag);
        this.add(tag);
    }


    /**
     * 업무 생성버튼
     */
    private void createNewWorkButton() {
        JButton createWorkBtn = new JButton("생성");
        createWorkBtn.setBounds(620, 15, 60, 30);
        createWorkBtn.setForeground(Color.WHITE);
        createWorkBtn.setBackground(new Color(45, 180, 0));
        createWorkBtn.setBorder(Constant.BlackLineBorder);
        createWorkBtn.setFont(Constant.BUTTON_FONT);

        createWorkBtn.addActionListener(e -> {

        });
        this.add(createWorkBtn);
    }

    /**
     * 업무 수정버튼
     */
    private void updateNewWorkButton() {
        JButton updateWorkBtn = new JButton("수정");
        updateWorkBtn.setBounds(690, 15, 60, 30);
        updateWorkBtn.setForeground(Color.WHITE);
        updateWorkBtn.setBackground(Color.darkGray);
        updateWorkBtn.setBorder(Constant.BlackLineBorder);
        updateWorkBtn.setFont(Constant.BUTTON_FONT);

        updateWorkBtn.addActionListener(e -> {

        });

        this.add(updateWorkBtn);
    }

    /**
     * 업무 저장버튼
     */
    private void saveWorkButton() {
        JButton saveWorkBtn = new JButton("저장");
        saveWorkBtn.setBounds(760, 15, 60, 30);
        saveWorkBtn.setForeground(Color.WHITE);
        saveWorkBtn.setBackground(Color.darkGray);
        saveWorkBtn.setBorder(Constant.BlackLineBorder);
        saveWorkBtn.setFont(Constant.BUTTON_FONT);

        saveWorkBtn.addActionListener(e -> {

        });

        this.add(saveWorkBtn);
    }

    private WorkListVo getNewWorkData() {
        return null;
    }

    /**
     * 업무 삭제버튼
     */
    private void deleteNewWorkButton() {
        JButton deleteWorkBtn = new JButton("삭제");
        deleteWorkBtn.setBounds(830, 15, 60, 30);
        deleteWorkBtn.setForeground(Color.WHITE);
        deleteWorkBtn.setBackground(Color.darkGray);
        deleteWorkBtn.setBorder(Constant.BlackLineBorder);
        deleteWorkBtn.setFont(Constant.BUTTON_FONT);

        deleteWorkBtn.addActionListener(e -> {

        });

        this.add(deleteWorkBtn);
    }

    /**********************
     ****    공통함수    ****
     **********************/

    private void createLabel(String text, int x, int y, int w, int h) {
        JLabel label = new JLabel(text);
        label.setLocation(x, y);
        label.setSize(w, h);
        label.setForeground(Color.BLACK);
        label.setFont(Constant.TEXTFIELD_FONT);
        this.add(label);
    }
}
