package com.ssm.model;

import com.ssm.utils.DateUtils;
import com.ssm.vo.Page;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/***
 *  项目立项
 */
@Data
public class ProjectCreate  extends Page {
    private String id;
    private String proName;
    private String startDate;
    private String endDate;
    private String createDate;
    private String updateDate;
    private String lastDate;
    private String remark;
}
