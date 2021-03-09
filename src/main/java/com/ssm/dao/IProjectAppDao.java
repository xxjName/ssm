package com.ssm.dao;

import com.ssm.model.ProjectCreate;

import java.util.List;
import java.util.Map;

/**
 * 项目立项
 */
public interface IProjectAppDao {

    public ProjectCreate findIdProjectCreate(String id);

    /***
     *  查询所有项目立项的数据
     * @return
     */
    public List<ProjectCreate>  allProjectCreate(ProjectCreate create);

    /***
     * 统计所有条数
     * @return
     */
    public int countProjectCreate(ProjectCreate create);

    public  int insertProjectCreate(ProjectCreate create);

    public int updateProjectCreate(ProjectCreate create);

    public int deleteProjectCreate(Map ids);


}
