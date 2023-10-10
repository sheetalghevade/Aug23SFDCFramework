package constants;

import utils.CommonUtils;

public class FileConstants {
		
		public static final String LOGIN_TESTDATA_FILE_PATH =  System.getProperty("user.dir") + "/src/main/resources/testdata/LoginTestData.xlsx";
		public static final String LOGIN_TESTDATA_FILE_PATH2 =  System.getProperty("user.dir") + "/src/main/resources/testdata/loginTestData.properties";
		
		public static final String USER_MENU_TESTDATA_FILE_PATH =  System.getProperty("user.dir") + "/src/main/resources/testdata/userMenuTestData.properties";
		public static final String PROFILE_PHOTO_FILE_PATH =  System.getProperty("user.dir") + "/src/main/resources/testdata/images.jpeg";
//		public static final String REPORT_PATH =  System.getProperty("user.dir") + "/src/main/resources/reports/demoreport.html";
		public static final String REPORT_PATH =  System.getProperty("user.dir") + "/src/main/resources/reports/"+CommonUtils.getDateAndTimeStamp()+"_SFDC.html";
//	File name will look like as 20230905090000_SFDC.html
		public static final String SCREENSHOT_PATH =  System.getProperty("user.dir") + "/src/main/resources/reports/"+CommonUtils.getDateAndTimeStamp()+"_SFDC.PNG";
		public static final String LEADS_MENU_TESTDATA_FILE_PATH =  System.getProperty("user.dir") + "/src/main/resources/testdata/LeadsmenuTestData.properties";
		public static final String OPTY_MENU_TESTDATA_FILE_PATH =  System.getProperty("user.dir") + "/src/main/resources/testdata/OpportunitiesTestData.properties";
		
	}

