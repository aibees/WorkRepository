package com.finance.pay.vo;


import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class WorkListVo {

    private String workId;
    private String workTitle;
    private LocalDate frDate;
    private LocalDate toDate;
    private String worktype;
    private String workstatus;
    private String repeat;
    private String repeatDetail;
    private String desc;
    private String subject;
    private String cc;
}
