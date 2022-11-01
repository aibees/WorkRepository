package com.finance.pay.ui.tabbed;

import com.finance.pay.service.WorkMilestoneService;
import com.finance.pay.ui.custom.ColumnGroup;
import com.finance.pay.ui.custom.GroupableTableHeader;
import com.finance.vo.WorkMilestoneVo;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

public class MilestoneTab extends JPanel {

    private WorkMilestoneService milestoneService = new WorkMilestoneService();

    private final int CALENDAR_NUM = 35;
    private final String COLUMNGROUP = "columngroup";
    private final String GROUPMAPPING = "groupmapping";
    private JTable table;
    private DateTimeFormatter NO_SLASH_DATE = DateTimeFormatter.ofPattern("yyyyMMdd");
    private DateTimeFormatter SLASH_DATE = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public MilestoneTab() {
        this.setBackground(Color.WHITE);
        this.createMilestone();
    }

    private void createMilestone() {
        this.setLayout(null);
        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(0, 0, 1080, 600);
        this.add(scroll);
        this.table = this.createGrid();
        scroll.setViewportView(table);

        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setOrientation(JScrollBar.HORIZONTAL);
        scrollBar.setOrientation(JScrollBar.VERTICAL);
        scroll.setColumnHeaderView(scrollBar);
    }

    /**
     * 테이블 생성
     * @return milestone(jtable 객체)
     */
    private JTable createGrid() {
        // get columnTypes
        Class[] columnTypes = new Class[this.CALENDAR_NUM];
        Arrays.fill(columnTypes, String.class);

        // 년월까지 표기되어있는 header list
        String[] milestone_header = getDateHeader(true);
        // header 처리를 위한 데이터들 가져옴
        Map<String, Map> data_group = this.getColumnGroupMap(milestone_header);
        // header에서 월 데이터만 뽑아 상위헤더그룹 리스트 가져옴
        Map<String, ColumnGroup> columnGroupMap = data_group.get(COLUMNGROUP);
        // header idx 별로 어느 그룹에 들어갈지 매핑해놨음
        Map<Integer, String> groupMapper = data_group.get(GROUPMAPPING);

        // table datamodel
        DefaultTableModel dailyGrid = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // No Editable
                return false;
            }
        };
        dailyGrid.setDataVector(
                null,
                getDateHeader(false)
        );

        List<WorkMilestoneVo> workList = milestoneService.getMilestoneList();
        this.addWork(dailyGrid, workList, milestone_header);

        // 테이블 생성
        JTable milestone = new JTable( dailyGrid ) {
            public Component prepareRenderer(TableCellRenderer renderer, int row, int col, Color color) {
                Component component = super.prepareRenderer(renderer, row, col);
                component.setBackground(color);
                return component;
            }

            protected JTableHeader createDefaultTableHeader() {
                return new GroupableTableHeader(columnModel);
            }
        };

        milestone.setBackground(Color.WHITE);
        milestone.setCellSelectionEnabled(true);
        milestone.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        milestone.setRowHeight(30);

        TableColumnModel cm = milestone.getColumnModel();

        cm.getColumn(0).setMinWidth(160);
        cm.getColumn(0).setMaxWidth(160);
        cm.getColumn(0).setPreferredWidth(160);

        for(int i = 1; i <= this.CALENDAR_NUM; i++) {
            // column 별 렌더링객체 생성
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            // align Center는 기본값
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);

            String grp = groupMapper.get(i);
            ColumnGroup cg = columnGroupMap.get(grp);

            LocalDate calendar = LocalDate.parse(grp + "/" + cm.getColumn(i).getHeaderValue(), this.SLASH_DATE);
            DayOfWeek week = calendar.getDayOfWeek();

            if(week.getValue() == 6 || week.getValue() == 7) {
                centerRenderer.setBackground(new Color(255, 160, 160));
            }

            if(calendar.isEqual(LocalDate.now())) {
                centerRenderer.setBackground(new Color(255, 235, 159));
            }

            cm.getColumn(i).setMaxWidth(28);
            cm.getColumn(i).setMinWidth(28);
            cm.getColumn(i).setPreferredWidth(28);
            cm.getColumn(i).setCellRenderer(centerRenderer);
            cg.add(cm.getColumn(i));
            columnGroupMap.put(grp, cg);
        }

        GroupableTableHeader header = (GroupableTableHeader) milestone.getTableHeader();
        ColumnGroup work_name_group = new ColumnGroup("구분");
        work_name_group.add(cm.getColumn(0));
        header.addColumnGroup(work_name_group);

        for(String c : columnGroupMap.keySet()) {
//            System.out.println(c);
            header.addColumnGroup(columnGroupMap.get(c));
//            System.out.println(header.getX() + " / " + header.getY());
        }

        return milestone;
    }

    private Map<String, Map> getColumnGroupMap(String[] columns) {
        Map<String, ColumnGroup> groupMap = new HashMap<>();
        Map<Integer, String> mapping = new HashMap<>();

        int idx = 1;
        for(String col : columns) {
            String[] M_D_ymd = col.split("/"); // 0 : year, 1 : month, 2 : date
            String[] M_D = new String[2];
            M_D[0] = M_D_ymd[0] + "/" + M_D_ymd[1];
            M_D[1] = M_D_ymd[2];
            mapping.put(idx++, M_D[0]);

            if(!groupMap.containsKey(M_D[0])) {
                ColumnGroup group = new ColumnGroup(M_D[0]);
                groupMap.put(M_D[0], group);
            }
        }
        Map<String, Map> data = new HashMap<>();
        data.put(COLUMNGROUP, groupMap);
        data.put(GROUPMAPPING, mapping);
        return data;
    }

    private String[] getDateHeader(boolean flag) {
        List<String> dateHeader = new ArrayList<String>();

        // get today
        Calendar cal = Calendar.getInstance(Locale.KOREA);
        cal.add(Calendar.DATE, -7);

        for(int i = 0; i < this.CALENDAR_NUM; i++) {
            String date = Integer.toString(cal.get(Calendar.DATE));
            if(date.length() == 1) { date = "0" + date; }
            String d_Str = ((flag)?(cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.MONTH)+1) + "/"):"") + date;

            dateHeader.add(d_Str);
            cal.add(Calendar.DATE, 1);
        }
        if(flag) {
            return dateHeader.toArray(new String[dateHeader.size()]);
        }
        else {
            dateHeader.add(0, "업무 리스트");
            return dateHeader.toArray(new String[dateHeader.size()]);
        }
    }

    private void addWork(DefaultTableModel dailygrid, List<WorkMilestoneVo> list, String[] daily) {

        for(WorkMilestoneVo work : list) {
            String[] line = new String[this.CALENDAR_NUM+1];
            line[0] = work.getWorkname();
            LocalDate start = LocalDate.parse(work.getStarttime(), this.NO_SLASH_DATE);
            LocalDate end = LocalDate.parse(work.getEndtime(), this.NO_SLASH_DATE);

            int idx = 1;
            for(String d : daily) {
                LocalDate day = LocalDate.parse(d, this.SLASH_DATE);
//                System.out.print(day + "  ");
                if(day.isAfter(start) && day.isBefore(end) && !(day.getDayOfWeek().getValue() == 6 || day.getDayOfWeek().getValue() == 7)) {
                    line[idx] = "●";
                }
                idx++;
            }

            dailygrid.addRow(line);
        }

    }
}
