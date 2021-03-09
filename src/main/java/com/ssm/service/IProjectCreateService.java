package com.ssm.service;

import com.ssm.model.ProjectCreate;

import java.util.List;
import java.util.Map;

public interface IProjectCreateService {

    public Map<String,Object> pageProjectApproval(ProjectCreate create);

    public int deleteProjectCreate(List<String> ids);
    public  int insertProjectCreate(ProjectCreate create);


    public ProjectCreate findIdProjectCreate(String id);
}
