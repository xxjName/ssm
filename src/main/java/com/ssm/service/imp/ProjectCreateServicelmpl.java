package com.ssm.service.imp;

import com.mchange.v2.lang.StringUtils;
import com.ssm.dao.IProjectAppDao;
import com.ssm.model.ProjectCreate;
import com.ssm.service.IProjectCreateService;
import com.ssm.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("projectCreateService")
public class ProjectCreateServicelmpl implements IProjectCreateService {
    @Autowired
    private IProjectAppDao projectAppDao;

    @Override
    public Map<String, Object> pageProjectApproval(ProjectCreate create) {
        Map<String, Object> map = new HashMap<>();
        List<ProjectCreate> list = projectAppDao.allProjectCreate(create);
        int total = projectAppDao.countProjectCreate(create);
        map.put("data", list);
        map.put("total", total);
        return map;
    }

    @Override
    public int deleteProjectCreate(List<String> ids) {
        Map params = new HashMap();
        params.put("ids", ids);
        return projectAppDao.deleteProjectCreate(params);
    }

    @Override
    public int insertProjectCreate(ProjectCreate create) {
        create.setStartDate(DateUtils.timeStamp(create.getStartDate()));
        create.setEndDate(DateUtils.timeStamp(create.getEndDate()));
        int reulst=0;

        if(StringUtils.nonEmptyString(create.getId())){
            create.setUpdateDate(DateUtils.dateFormat(new Date()));
            create.setLastDate(DateUtils.dateFormat(new Date()));
            reulst= projectAppDao.updateProjectCreate(create);
        }else{
            reulst= projectAppDao.insertProjectCreate(create);
        }
        return reulst;
    }

    @Override
    public ProjectCreate findIdProjectCreate(String id) {
        return projectAppDao.findIdProjectCreate(id);
    }
}
