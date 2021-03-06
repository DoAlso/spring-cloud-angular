package com.cloud.configservice.model;

import java.io.Serializable;

public class ProjectEnvs implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_envs.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_envs.projects_id
     *
     * @mbg.generated
     */
    private Long projectsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_envs.envs_id
     *
     * @mbg.generated
     */
    private Long envsId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table project_envs
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_envs.id
     *
     * @return the value of project_envs.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_envs.id
     *
     * @param id the value for project_envs.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_envs.projects_id
     *
     * @return the value of project_envs.projects_id
     *
     * @mbg.generated
     */
    public Long getProjectsId() {
        return projectsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_envs.projects_id
     *
     * @param projectsId the value for project_envs.projects_id
     *
     * @mbg.generated
     */
    public void setProjectsId(Long projectsId) {
        this.projectsId = projectsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_envs.envs_id
     *
     * @return the value of project_envs.envs_id
     *
     * @mbg.generated
     */
    public Long getEnvsId() {
        return envsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_envs.envs_id
     *
     * @param envsId the value for project_envs.envs_id
     *
     * @mbg.generated
     */
    public void setEnvsId(Long envsId) {
        this.envsId = envsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_envs
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ProjectEnvs other = (ProjectEnvs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectsId() == null ? other.getProjectsId() == null : this.getProjectsId().equals(other.getProjectsId()))
            && (this.getEnvsId() == null ? other.getEnvsId() == null : this.getEnvsId().equals(other.getEnvsId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_envs
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjectsId() == null) ? 0 : getProjectsId().hashCode());
        result = prime * result + ((getEnvsId() == null) ? 0 : getEnvsId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_envs
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projectsId=").append(projectsId);
        sb.append(", envsId=").append(envsId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}