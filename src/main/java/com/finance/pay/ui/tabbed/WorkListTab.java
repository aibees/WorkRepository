package com.finance.pay.ui.tabbed;

import com.finance.pay.service.CommonService;
import com.finance.pay.service.WorkListService;
import com.finance.pay.vo.common.RepeatStatus;
import com.finance.pay.vo.WorkListVo;
import com.finance.pay.vo.common.WorkStatus;
import com.finance.pay.vo.common.WorkType;
import com.finance.util.Constant;
import com.finance.util.MOD;
import com.finance.util.SECTION;

import javax.swing.*;
import javax.swing.DefaultListModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.TextAction;
import javax.swing.undo.UndoManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.finance.util.SECTION.*;

public class WorkListTab extends JPanel {

    private final WorkListService workListService = new WorkListService();
    private final CommonService commonService = new CommonService();

    private final Map<SECTION, Object> WorkListMapper = new HashMap<>();

    private DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy / MM / dd");
    private String workcd = "";

    public WorkListTab() {
        this.setBackground(Constant.BACKGROUND_COLOR);
        this.createWorkList();
    }

    private void createWorkList() {
        try {
            this.setLayout(null); // absolute layout
//            this.setBackground(Color.lightGray);
            this.paintLeftSize();
            this.paintRightSize();
            this.init(MOD.INIT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init(MOD mod) {
        if(mod == MOD.INIT) {
            // title
            ((JTextField)this.WorkListMapper.get(TITLE)).setText("");
            ((JTextField)this.WorkListMapper.get(TITLE)).setEditable(false);
            ((JTextField)this.WorkListMapper.get(TITLE)).setBackground(Constant.DISABLED_COLOR);

            // date
            ((JFormattedTextField)this.WorkListMapper.get(FRDATE)).setValue(null);
            ((JFormattedTextField)this.WorkListMapper.get(FRDATE)).setEditable(false);
            ((JFormattedTextField)this.WorkListMapper.get(FRDATE)).setBackground(Constant.DISABLED_COLOR);

            ((JFormattedTextField)this.WorkListMapper.get(TODATE)).setValue(null);
            ((JFormattedTextField)this.WorkListMapper.get(TODATE)).setEditable(false);
            ((JFormattedTextField)this.WorkListMapper.get(TODATE)).setBackground(Constant.DISABLED_COLOR);

            // WORKTYPE
            ((JComboBox)this.WorkListMapper.get(WORKTYPE)).setEnabled(false);
            ((JComboBox)this.WorkListMapper.get(WORKTYPE)).setSelectedIndex(0);
            ((JComboBox)this.WorkListMapper.get(WORKTYPE)).setRenderer(new DefaultListCellRenderer() {
                @Override
                public void paint(Graphics g) {
                    setForeground(Color.BLACK);
                    setBackground(Constant.DISABLED_COLOR);
                    super.paint(g);
                }
            });

            // repeat
            ((JComboBox)this.WorkListMapper.get(REPEAT)).setEnabled(false);
            ((JComboBox)this.WorkListMapper.get(REPEAT)).setSelectedIndex(0);
            ((JComboBox)this.WorkListMapper.get(REPEAT)).setRenderer(new DefaultListCellRenderer() {
                @Override
                public void paint(Graphics g) {
                    setForeground(Color.BLACK);
                    setBackground(Constant.DISABLED_COLOR);
                    super.paint(g);
                }
            });

            // STATUS
            ((JComboBox)this.WorkListMapper.get(STATUS)).setEnabled(false);
            ((JComboBox)this.WorkListMapper.get(STATUS)).setSelectedIndex(0);
            ((JComboBox)this.WorkListMapper.get(STATUS)).setRenderer(new DefaultListCellRenderer() {
                @Override
                public void paint(Graphics g) {
                    setForeground(Color.BLACK);
                    setBackground(Constant.DISABLED_COLOR);
                    super.paint(g);
                }
            });

            // SUBJECTS
            ((JTextField)this.WorkListMapper.get(SUBJECTS)).setText("");
            ((JTextField)this.WorkListMapper.get(SUBJECTS)).setEditable(false);
            ((JTextField)this.WorkListMapper.get(SUBJECTS)).setBackground(Constant.DISABLED_COLOR);

            // REFER
            ((JTextField)this.WorkListMapper.get(REFER)).setText("");
            ((JTextField)this.WorkListMapper.get(REFER)).setEditable(false);
            ((JTextField)this.WorkListMapper.get(REFER)).setBackground(Constant.DISABLED_COLOR);

            // DESCRIPT
            ((JTextArea)this.WorkListMapper.get(DESCRIPT)).setText("");
            ((JTextArea)this.WorkListMapper.get(DESCRIPT)).setEditable(false);

        } else if(mod == MOD.NEW) {
            this.workcd = "";
            // title
            ((JTextField)this.WorkListMapper.get(TITLE)).setText("");
            ((JTextField)this.WorkListMapper.get(TITLE)).setEditable(true);
            ((JTextField)this.WorkListMapper.get(TITLE)).setBackground(Color.WHITE);

            // date
            ((JFormattedTextField)this.WorkListMapper.get(FRDATE)).setValue(null);
            ((JFormattedTextField)this.WorkListMapper.get(FRDATE)).setEditable(true);
            ((JFormattedTextField)this.WorkListMapper.get(FRDATE)).setBackground(Color.WHITE);

            ((JFormattedTextField)this.WorkListMapper.get(TODATE)).setValue(null);
            ((JFormattedTextField)this.WorkListMapper.get(TODATE)).setEditable(true);
            ((JFormattedTextField)this.WorkListMapper.get(TODATE)).setBackground(Color.WHITE);

            // worktype
            ((JComboBox)this.WorkListMapper.get(WORKTYPE)).setEnabled(true);
            ((JComboBox)this.WorkListMapper.get(WORKTYPE)).setSelectedIndex(0);
            ((JComboBox)this.WorkListMapper.get(WORKTYPE)).setRenderer(new DefaultListCellRenderer() {
                @Override
                public void paint(Graphics g) {
                    setForeground(Color.BLACK);
                    setBackground(Color.WHITE);
                    super.paint(g);
                }
            });

            // repeat
            ((JComboBox)this.WorkListMapper.get(REPEAT)).setEnabled(true);
            ((JComboBox)this.WorkListMapper.get(REPEAT)).setSelectedIndex(0);
            ((JComboBox)this.WorkListMapper.get(REPEAT)).setRenderer(new DefaultListCellRenderer() {
                @Override
                public void paint(Graphics g) {
                    setForeground(Color.BLACK);
                    setBackground(Color.WHITE);
                    super.paint(g);
                }
            });

            // STATUS
            ((JComboBox)this.WorkListMapper.get(STATUS)).setEnabled(true);
            ((JComboBox)this.WorkListMapper.get(STATUS)).setSelectedIndex(0);
            ((JComboBox)this.WorkListMapper.get(STATUS)).setRenderer(new DefaultListCellRenderer() {
                @Override
                public void paint(Graphics g) {
                    setForeground(Color.BLACK);
                    setBackground(Color.WHITE);
                    super.paint(g);
                }
            });

            // SUBJECTS
            ((JTextField)this.WorkListMapper.get(SUBJECTS)).setText("");
            ((JTextField)this.WorkListMapper.get(SUBJECTS)).setEditable(true);
            ((JTextField)this.WorkListMapper.get(SUBJECTS)).setBackground(Color.WHITE);

            // REFERS
            ((JTextField)this.WorkListMapper.get(REFER)).setText("");
            ((JTextField)this.WorkListMapper.get(REFER)).setEditable(true);
            ((JTextField)this.WorkListMapper.get(REFER)).setBackground(Color.WHITE);

            // desc
            ((JTextArea)this.WorkListMapper.get(DESCRIPT)).setText("");
            ((JTextArea)this.WorkListMapper.get(DESCRIPT)).setEditable(true);

        } else if(mod == MOD.UPDATE) {
            //title
            ((JTextField)this.WorkListMapper.get(TITLE)).setEditable(true);
            ((JTextField)this.WorkListMapper.get(TITLE)).setBackground(Color.WHITE);

            // date
            ((JFormattedTextField)this.WorkListMapper.get(FRDATE)).setEditable(true);
            ((JFormattedTextField)this.WorkListMapper.get(FRDATE)).setBackground(Color.WHITE);

            ((JFormattedTextField)this.WorkListMapper.get(TODATE)).setEditable(true);
            ((JFormattedTextField)this.WorkListMapper.get(TODATE)).setBackground(Color.WHITE);

            // worktype
            ((JComboBox)this.WorkListMapper.get(WORKTYPE)).setEnabled(true);
            ((JComboBox)this.WorkListMapper.get(WORKTYPE)).setRenderer(new DefaultListCellRenderer() {
                @Override
                public void paint(Graphics g) {
                    setForeground(Color.BLACK);
                    setBackground(Color.WHITE);
                    super.paint(g);
                }
            });

            // repeat
            ((JComboBox)this.WorkListMapper.get(REPEAT)).setEnabled(true);
            ((JComboBox)this.WorkListMapper.get(REPEAT)).setRenderer(new DefaultListCellRenderer() {
                @Override
                public void paint(Graphics g) {
                    setForeground(Color.BLACK);
                    setBackground(Color.WHITE);
                    super.paint(g);
                }
            });

            // SUBJECTS
            ((JTextField)this.WorkListMapper.get(SUBJECTS)).setEditable(true);
            ((JTextField)this.WorkListMapper.get(SUBJECTS)).setBackground(Color.WHITE);

            // REFER
            ((JTextField)this.WorkListMapper.get(REFER)).setEditable(true);
            ((JTextField)this.WorkListMapper.get(REFER)).setBackground(Color.WHITE);

            // desc
            ((JTextArea)this.WorkListMapper.get(DESCRIPT)).setEditable(true);
        } else {
            return;
        }
    }

    ////////////// left ////////////
    private void paintLeftSize() throws ParseException {
        // 업무리스트
        this.createLabel("업무리스트", 0, 30, 100, 20);
        this.createTitleListView();
        // 제목
        this.createLabel("제목", 290, 30, 50, 20);
        this.createTitleTextLine();
        // 업무기간
        this.createLabel("업무기간", 290, 100, 80, 20);
        this.createDateField();
        // 업무유형
        this.createLabel("업무유형", 290, 170, 80, 20);
        this.createWorkType();
        // 반복성
        this.createLabel("반복", 290, 240, 50, 20);
        this.createLabel("주기", 400, 240, 50, 20);
        this.createRepeatStatus();
        // 업무상태
        this.createLabel("업무상태", 290, 310, 80, 20);
        this.createWorkStatus();
        // 업무관여리스트
        this.createLabel("유관부서", 290, 380, 140, 20);
        this.createRelatedList();
        // 여백

    }

    /**
     * 업무리스트
     */
    private void createTitleListView() {
        // --test data--
        String[] test_work = {"NC202211001-업무인수인계", "NC202211002-[반복]SSL 갱신작업"};
        JList<String> workdata = new JList<>();

        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addAll(Arrays.asList(test_work));
        workdata.setModel(listModel);
        workdata.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        workdata.setFont(Constant.LIST_FONT);

        workdata.addListSelectionListener(e -> {
            if(!workcd.equals(workdata.getSelectedValue())) {
                try {
                    this.init(MOD.INIT);
                    workcd = workdata.getSelectedValue().split("-")[0];

                    WorkListVo work = workListService.getWorkDataById(workcd);

                    /**
                     * title update
                     */
                    JTextField title = (JTextField) this.WorkListMapper.get(TITLE);
                    if (title != null)
                        title.setText(work.getWorkTitle());
                    else
                        title.setText(workcd);

                    /**
                     * fr & to update
                     */
                    JFormattedTextField fr = (JFormattedTextField) this.WorkListMapper.get(FRDATE);
                    if (fr != null) {
                        fr.setValue(work.getFrDate().atStartOfDay(ZoneId.systemDefault()).format(format));
                    }
                    JFormattedTextField to = (JFormattedTextField) this.WorkListMapper.get(TODATE);
                    if (to != null) {
                        to.setValue(work.getToDate().atStartOfDay(ZoneId.systemDefault()).format(format));
                    }

                    /**
                     * worktype update
                     */
                    ((JComboBox<WorkType>)this.WorkListMapper.get(WORKTYPE)).setSelectedItem(commonService.getWorktypeById(work.getWorktype()));

                    /**
                     * repeatStatus update
                     */
                    ((JComboBox<RepeatStatus>)this.WorkListMapper.get(REPEAT)).setSelectedItem(commonService.getRepeatStatusById(work.getRepeat()));
                    ((JTextField)this.WorkListMapper.get(REPEATDETAIL)).setText(work.getRepeatDetail());

                    /**
                     * workstatus update
                     */
                    ((JComboBox<WorkStatus>)this.WorkListMapper.get(STATUS)).setSelectedItem(commonService.getWorkStatusById(work.getWorkstatus()));

                    /**
                     * subject / cc update
                     */
                    ((JTextField)this.WorkListMapper.get(SUBJECTS)).setText(work.getSubject());
                    ((JTextField)this.WorkListMapper.get(REFER)).setText(work.getCc());

                    /**
                     * description update
                     */
                    ((JTextArea) this.WorkListMapper.get(DESCRIPT)).setText(work.getDesc());

                } catch(NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(this, "부정합한 데이터가 있는 항목입니다.");
                } catch(NullPointerException npe) {
                    JOptionPane.showMessageDialog(this, "필수 데이터가 누락된 항목입니다.");
                }
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
        titleField.setBorder(Constant.BlackLineBorder);
        titleField.setFont(Constant.TEXTFIELD_FONT);
        WorkListMapper.put(TITLE, titleField);
        this.add(titleField);
    }

    /**
     * 업무기간 FROM & TO
     */
    private void createDateField() throws ParseException {
        MaskFormatter form = new MaskFormatter("#### / ## / ##");
        JFormattedTextField frDate = new JFormattedTextField(form);
        JFormattedTextField toDate = new JFormattedTextField(form);

        frDate.setBounds(290, 120, 130, 40);
        frDate.setHorizontalAlignment(SwingConstants.CENTER);
        frDate.setForeground(Color.BLACK);
        frDate.setBackground(Color.WHITE);
        frDate.setBorder(Constant.BlackLineBorder);
        frDate.setFont(Constant.TEXTFIELD_FONT);

        this.createLabel(" ~ ", 430, 125, 40, 30);

        toDate.setBounds(460, 120, 130, 40);
        toDate.setHorizontalAlignment(SwingConstants.CENTER);
        toDate.setForeground(Color.BLACK);
        toDate.setBackground(Color.WHITE);
        toDate.setBorder(Constant.BlackLineBorder);
        toDate.setFont(Constant.TEXTFIELD_FONT);

        WorkListMapper.put(FRDATE, frDate);
        this.add(frDate);
        WorkListMapper.put(TODATE, toDate);
        this.add(toDate);
    }

    /**
     * 업무유형
     */
    private void createWorkType() {
        JComboBox<WorkType> typeBox = new JComboBox<WorkType>();
        typeBox.setBounds(290, 190, 300, 40);
        typeBox.setBorder(Constant.BlackLineBorder);
        typeBox.setFont(Constant.TEXTFIELD_FONT);

        WorkType[] types = commonService.getWorktypeComboList();
        ComboBoxModel<WorkType> comboModel = new DefaultComboBoxModel<>(types);

        typeBox.setModel(comboModel);
        this.WorkListMapper.put(WORKTYPE, typeBox);
        this.add(typeBox);
    }

    /**
     * 반복여부
     */
    private void createRepeatStatus() {
        JComboBox<RepeatStatus> repeatBox = new JComboBox<>();
        repeatBox.setBounds(290, 260, 100, 40);
        repeatBox.setBorder(Constant.BlackLineBorder);
        repeatBox.setFont(Constant.TEXTFIELD_FONT);

        RepeatStatus[] statuses = commonService.getRepeatComboList();
        ComboBoxModel<RepeatStatus> comboModel = new DefaultComboBoxModel<>(statuses);

        repeatBox.setModel(comboModel);

        this.WorkListMapper.put(REPEAT, repeatBox);
        this.add(repeatBox);

        // 반복일 시 주기 입력
        JTextField repeatDetail = new JTextField();
        repeatDetail.setBounds(400, 260, 190, 40);
        repeatDetail.setForeground(Color.BLACK);
        repeatDetail.setBackground(Color.WHITE);
        repeatDetail.setBorder(Constant.BlackLineBorder);
        repeatDetail.setFont(Constant.TEXTFIELD_FONT);
        WorkListMapper.put(REPEATDETAIL, repeatDetail);
        this.add(repeatDetail);
    }

    /**
     * 업무상태
     */
    private void createWorkStatus() {
        JComboBox<WorkStatus> statusBox = new JComboBox<>();
        statusBox.setBounds(290, 330, 300, 40);
        statusBox.setBorder(Constant.BlackLineBorder);
        statusBox.setFont(Constant.TEXTFIELD_FONT);

        WorkStatus[] statuses = commonService.getWorkStatusComboList();
        ComboBoxModel<WorkStatus> comboModel = new DefaultComboBoxModel<>(statuses);

        statusBox.setModel(comboModel);

        this.WorkListMapper.put(STATUS, statusBox);
        this.add(statusBox);
    }

    /**
     * 업무 관여 리스트
     */
    private void createRelatedList() {
        this.createLabel("Sub.", 290, 415, 50, 20);
        // subject.
        JTextField subjectList = new JTextField();
        subjectList.setBounds(330, 400, 260, 40);
        subjectList.setForeground(Color.BLACK);
        subjectList.setBackground(Color.WHITE);
        subjectList.setBorder(Constant.BlackLineBorder);
        subjectList.setFont(Constant.TEXTFIELD_FONT);
        WorkListMapper.put(SUBJECTS, subjectList);
        this.add(subjectList);

        this.createLabel("Cc.", 290, 455, 30, 20);
        // reference
        JTextField refList = new JTextField();
        refList.setBounds(330, 440, 260, 40);
        refList.setForeground(Color.BLACK);
        refList.setBackground(Color.WHITE);
        refList.setBorder(Constant.BlackLineBorder);
        refList.setFont(Constant.TEXTFIELD_FONT);
        WorkListMapper.put(REFER, refList);
        this.add(refList);
    }

    //////////// right ////////////
    private void paintRightSize() {
        this.createLabel("업무세부내용", 640, 30, 100, 20);
        // buttons
        this.createNewWorkButton();
        this.updateNewWorkButton();
        this.saveWorkButton();
        this.deleteNewWorkButton();

        // text area
        this.createDescription();
    }

    /**
     * 업무내역 기록 textarea
     */
    private void createDescription() {
        JTextArea desc = new JTextArea();
        desc.setBorder(Constant.BlackLineBorder);
        desc.setFont(Constant.DESC_FONT);
        desc.setLineWrap(true);
        JScrollPane descPane = new JScrollPane(desc);
        descPane.setBounds(640, 50, 410, 520);

        //undo redo (test)
        UndoManager doManager = new UndoManager();
        desc.getDocument().addUndoableEditListener(doManager);
        desc.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_MASK), "undo");
        desc.getActionMap().put("undo", new TextAction("undo") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(doManager.canUndo())
                    doManager.undo();
            }
        });

        desc.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_MASK), "redo");
        desc.getActionMap().put("redo", new TextAction("redo") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(doManager.canRedo())
                    doManager.redo();
            }
        });

        this.WorkListMapper.put(DESCRIPT, desc);
        this.add(descPane);
    }

    /**
     * 업무 생성버튼
     */
    private void createNewWorkButton() {
        JButton createWorkBtn = new JButton("생성");
        createWorkBtn.setBounds(780, 15, 60, 30);
        createWorkBtn.setForeground(Color.WHITE);
        createWorkBtn.setBackground(new Color(45, 180, 0));
        createWorkBtn.setBorder(Constant.BlackLineBorder);
        createWorkBtn.setFont(Constant.BUTTON_FONT);

        createWorkBtn.addActionListener(e -> {
            this.init(MOD.NEW);
        });

        this.add(createWorkBtn);
    }

    /**
     * 업무 수정버튼
     */
    private void updateNewWorkButton() {
        JButton updateWorkBtn = new JButton("수정");
        updateWorkBtn.setBounds(850, 15, 60, 30);
        updateWorkBtn.setForeground(Color.WHITE);
        updateWorkBtn.setBackground(Color.darkGray);
        updateWorkBtn.setBorder(Constant.BlackLineBorder);
        updateWorkBtn.setFont(Constant.BUTTON_FONT);

        updateWorkBtn.addActionListener(e -> {
            if(!workcd.isEmpty())
                this.init(MOD.UPDATE);
        });

        this.add(updateWorkBtn);
    }

    /**
     * 업무 저장버튼
     */
    private void saveWorkButton() {
        JButton saveWorkBtn = new JButton("저장");
        saveWorkBtn.setBounds(920, 15, 60, 30);
        saveWorkBtn.setForeground(Color.WHITE);
        saveWorkBtn.setBackground(Color.darkGray);
        saveWorkBtn.setBorder(Constant.BlackLineBorder);
        saveWorkBtn.setFont(Constant.BUTTON_FONT);

        saveWorkBtn.addActionListener(e -> {
            try {
                WorkListVo saveData = getNewWorkData();
                System.out.println(saveData);

                int confirm = JOptionPane.showConfirmDialog(this, "Save Process Confirm? workcd : " + ((this.workcd.isEmpty()) ? "New" : this.workcd));
                // 0 : Yes, 1 : No, 2 : Cancel
                if (confirm == 0 && !workcd.isEmpty()) {
                    workListService.deleteWorkDataById(workcd);
                    this.update();
                }
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        this.add(saveWorkBtn);
    }

    private WorkListVo getNewWorkData() {
        JComboBox<RepeatStatus> repeat = (JComboBox<RepeatStatus>) this.WorkListMapper.get(REPEAT);
        JComboBox<WorkType> types = (JComboBox<WorkType>) this.WorkListMapper.get(WORKTYPE);

        return WorkListVo.builder()
                .workId((this.workcd.isEmpty())?(workListService.getNewWorkCode()):(this.workcd))
                .workTitle(((JTextField)this.WorkListMapper.get(TITLE)).getText())
                .frDate(LocalDate.parse(((JFormattedTextField)this.WorkListMapper.get(FRDATE)).getText(), this.format))
                .toDate(LocalDate.parse(((JFormattedTextField)this.WorkListMapper.get(TODATE)).getText(), this.format))
                .worktype(types.getItemAt(types.getSelectedIndex()).getNumber())
                .repeat(repeat.getItemAt(repeat.getSelectedIndex()).getNumber())
                .desc(((JTextArea)this.WorkListMapper.get(DESCRIPT)).getText())
                .build();
    }

    /**
     * 업무 삭제버튼
     */
    private void deleteNewWorkButton() {
        JButton deleteWorkBtn = new JButton("삭제");
        deleteWorkBtn.setBounds(990, 15, 60, 30);
        deleteWorkBtn.setForeground(Color.WHITE);
        deleteWorkBtn.setBackground(Color.darkGray);
        deleteWorkBtn.setBorder(Constant.BlackLineBorder);
        deleteWorkBtn.setFont(Constant.BUTTON_FONT);

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
        label.setFont(Constant.TEXTFIELD_FONT);
        this.add(label);
    }
}