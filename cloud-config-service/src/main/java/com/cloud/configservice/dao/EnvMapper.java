package com.cloud.configservice.dao;

import com.cloud.configservice.model.Env;
import com.cloud.configservice.model.EnvExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EnvMapper {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table env
     *
     * @mbg.generated
     */
    long countByExample(EnvExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table env
     *
     * @mbg.generated
     */
    int deleteByExample(EnvExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table env
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table env
     *
     * @mbg.generated
     */
    int insert(Env record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table env
     *
     * @mbg.generated
     */
    int insertSelective(Env record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table env
     *
     * @mbg.generated
     */
    List<Env> selectByExample(EnvExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table env
     *
     * @mbg.generated
     */
    Env selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table env
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Env record, @Param("example") EnvExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table env
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Env record, @Param("example") EnvExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table env
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Env record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table env
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Env record);


    @Results(value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "configServerName", column = "config_server_name"),
            @Result(property = "contextPath", column = "context_path"),
            @Result(property = "name", column = "name"),
            @Result(property = "registryAddress", column = "registry_address"),
    })
    @Select("select * from env where name=#{name}")
    Env selectEnvByName(@Param("name") String name);


    @Results(value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "configServerName", column = "config_server_name"),
            @Result(property = "contextPath", column = "context_path"),
            @Result(property = "name", column = "name"),
            @Result(property = "registryAddress", column = "registry_address"),
    })
    @Select("select * from env inner join project_envs on env.id=project_envs.envs_id inner join project on project_envs.projects_id=project.id where project.id=#{id}")
    List<Env> selectEnvByProjectId(@Param("id") Long id);


    List<Env> selectEnvsByName(@Param("name") String name);
}