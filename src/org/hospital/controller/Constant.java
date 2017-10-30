package org.hospital.controller;

/**
 * Created by pismery on 2017-10-26.
 */
public enum Constant {
    /**
     * 权限表相应权限名称
     */
    CREATE_EMPLOYEE("创建员工"),
    QUEARY_EMPLOYEE("查询员工"),
    ALTER_EMPLOYEE("修改员工"),
    CREATE_CLINIC("创建门诊"),
    QUEARY_CLINIC("查询门诊"),
    CREATE_DEPARTMENT("创建科室"),
    QUERY_DEPARTMENT("查询科室"),
    CREATE_TREATMENT_PROJECT("创建治疗项目"),
    QUERY_TREATMENT_PROJECT("查看治疗项目"),
    ALTER_TREATMENT_PROJECT("修改治疗项目"),
    CREATE_CLIENT("创建客户"),
    QUERY_CLIENT("查看客户"),
    ALTER_CLIENT("修改客户"),
    CREATE_RECORD("创建病例"),
    QUERY_RECORD("查看病例"),
    ALTER_RECORD("修改病例"),
    CREATE_POSITION("创建职位"),
    QUERY_POSITION("查看职位"),
    ALTER_POSITION("修改职位"),
    CREATE_TREATMENT_BILL("创建治疗项目单据"),
    QUERY_TREATMENT_BILL("查看治疗项目单据"),
    ALTER_TREATMENT_BILL("修改治疗项目单据"),
    CREATE_FUND_BILL("创建费用单据"),
    QUERY_FUND_BILL("查看费用单据"),
    ALTER_FUND_BILL("修改费用单据"),
    GET_REPORT("查看报表"),

    /**
     * bill表 category字段 医生开单(doctorBill),费用清单(fundBill)
     */
    DOCTOR_BILL("doctorBill"),
    FUND_BILL("fundBill"),
    
    /**
     * project表category字段 治疗项目(treatmentProject),费用项目(fundProject)
     */
    TREATMENT_PROJECT("treatmentProject"),
    FUND_PROJECT("fundProject");



    private String name;

    // 构造方法
    private Constant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
