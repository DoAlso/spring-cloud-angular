package com.cloud.sample.javabase.annotation.sql;

/**
 * @ClassName Member
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/10/29 13:19
 */
@DBTable(name = "member")
public class Member {
    @SQLString(30)
    String firstName;
    @SQLString(50)
    String laseName;
    @SQLInteger
    Integer age;
    @SQLString(value = 30,constraints = @Constraints(primaryKey = true))
    String handle;
    static int memberCount;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLaseName() {
        return laseName;
    }

    public void setLaseName(String laseName) {
        this.laseName = laseName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    @Override
    public String toString() {
        return handle;
    }
}
