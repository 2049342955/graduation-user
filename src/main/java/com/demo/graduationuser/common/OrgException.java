/*
 *  #{copyright}#
 */

package com.demo.graduationuser.common;

import com.demo.core.exception.MultiLangException;

/**
 * @author luye
 */
public class OrgException extends MultiLangException {

    public static final String EXCEPTION_COMPANY_DUPLICATED = "com.esudian.exception.company.code.duplicated";
    public static final String EXCEPTION_STORE_DUPLICATED = "com.esudian.exception.store.code.duplicated";
    public static final String EXCEPTION_DINNER_TAB_DUPLICATED = "com.esudian.exception.dinner.table.num.duplicated";
    public static final String EXCEPTION_DEPARTMENT_DUPLICATED = "com.esudian.exception.department.name.duplicated";
    public static final String EXCEPTION_EMP_NUMBER_DUPLICATED = "com.esudian.exception.employee.number.duplicated";

    public OrgException(String code, String message) {
        super(code, message);
    }
}
