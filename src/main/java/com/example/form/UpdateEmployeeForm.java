package com.example.form;

public class UpdateEmployeeForm {
    /** 従業員ID */
    private String id;
    /** 扶養人数 */
    private String dependentsCount;

    public String getId() {
        return id;
    }

    public Integer getIntId() {
        return Integer.parseInt(this.getId());
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDependentsCount() {
        return dependentsCount;
    }

    public Integer getIntDependentsCount() {
        return Integer.parseInt(this.getDependentsCount());
    }

    public void setDependentsCount(String dependentsCount) {
        this.dependentsCount = dependentsCount;
    }

    @Override
    public String toString() {
        return "UpdateEmployeeForm [id=" + id + ", dependentsCount=" + dependentsCount + "]";
    }

}
