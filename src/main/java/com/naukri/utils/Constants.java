package com.naukri.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {

    public final static String LOGIN_PAGE_TITLE = "Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com";
    public final static String HOME_PAGE_TITLE = "Home | Mynaukri";
    public final static String PROFILE_PAGE_TITLE = "Profile | Mynaukri";

    public final static int IMAC_IMAGE_COUNT = 3;
    public final static int MACBOOK_PRO_IMAGE_COUNT = 4;

    public final static String REGISTER_SUCCESS_MESSG = "Your Account Has Been Created!";

    public final static String REGISTER_SHEET_NAME = "resgister";
    public final static String PRODUCT_SHEET_NAME = "productinfo";



    public static List<String> getExpectedAccSecList() {
        return Arrays.asList("Jobs", "Companies", "Services");
    }

}