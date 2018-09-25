package com.hsnn.medstgmini;

/**
 * @category 常量类
 * @author 单大伟
 * @date 2015-06-10
 */
public class Constants {
	public final static String strTrue = "true";               // string 类型 true
	
	public final static String strFalse = "false";             // string 类型 false
	
	public final static String USERINFO = "userinfo";
	
	public final static String USER_RESOURCE ="user_resource";

	public final static String USERNAME     = "username";		//
	
	public final static String PASSWORD     = "password";		//
	
	public final static String ANSWER     = "answer";
	
	public final static String HOMEPAGE     = "homepage";		//
	
	public final static String LOGINPAGE    = "loginpage";		//
	
	public final static String CSS_FOLDER   = "cssfolder";		//
	
	public final static String JS_FOLDER    = "jsfolder";		//
	
	public final static String PRICE_QUOTE_STARTTIME   = "1";		//按报价开始时间排序
	public final static String PROJ_STARTTIME    = "2";		//按招标开始日期排序
	
	public final static int OP_TYPE_ADD     = 0;				//
	
	public final static int OP_TYPE_EDIT    = 1;				//
	
	public final static String DEFAULT_PROJ    = "1";				//判断是否有返回按钮
	public final static int DEFAULT_PROJ_1    = 1;				//默认项目并且在规定时间段内
	public final static int DEFAULT_PROJ_2   = 2;				//默认项目但不在规定时间段内
	public final static int DEFAULT_PROJ_3   = 3;				//未分离的项目
	
	public final static short SCORETYPE_SUBJECTIVE   = 1;		//主观分
	public final static short SCORETYPE_OBJECTIVE    = 2;			//客观分
	
	
	public final static short APPLYTYPE_0 = 0; //申请类型0修改申报1新增申报
	public final static short APPLYTYPE_1 = 1; 
	public final static short AUDIT_STATUS_0 = 0;// 审核状态0提交1审核通过2审核不通过
	
	public final static short ISINSETTLESLIP_0 = 0;         // 未纳入
	public final static short ISINSETTLESLIP_1 = 1;        // 已纳入
	
	public final static short BAK_STATUS_NOT_AUDIT = 0;         // 未审核
	public final static short BAK_STATUS_AUDIT_PASS = 1;        // 通过
	public final static Integer BAK_STATUS_AUDIT_PASS_INT = 1;  // 通过
	public final static short BAK_STATUS_AUDIT_NOT_PASS = 2;    // 未通过

	public final static short  BIDPROJCOMPROFILE_SATTUS_0  = 0;//采购项目企业资质状态0停用1启用
	public final static short  BIDPROJCOMPROFILE_SATTUS_1  = 1;//采购项目企业资质状态0停用1启用
	
	public final static short COMPLAIN_STATUS_0 = 0;  //澄清状态0.提交1.澄清通过2澄清不通过
	public final static String COMPLAIN_STATUS_STRING_0 = "0";  //澄清状态0.提交1.澄清通过2澄清不通过
	public final static short COMPLAIN_STATUS_1 = 1; //澄清状态0.提交1.澄清通过2澄清不通过
	public final static short COMPLAIN_STATUS_2 = 2;//澄清状态0.提交1.澄清通过2澄清不通过
	
	public final static short  APPLY_TYPE_NEW = 1;//申请类型1新增申报
	public final static short  APPLY_TYPE_MODIFY = 0;//申请类型0修改申报
	
	public final static short STD_DRUGCATALOG_status_0 = 0;  // 药物目录状态 1.启用 0. 停用
	public final static short STD_DRUGCATALOG_status_1 = 1;  // 药物目录状态 1.启用 0. 停用
	
	public final static short STD_COMPDRUGPROFILE_STATUS_0 = 0;  // 产品资质状态 1.启用 0. 停用
	public final static short STD_COMPDRUGPROFILE_STATUS_1 = 1;  // 产品资质状态 1.启用 0. 停用
	
	public final static String POST_ORDER_TYPE_HOSP = "1";         // 缴款单类型1医疗机构缴款单
	public final static String POST_ORDER_TYPE_HS = "2";         // 缴款单类型2核算中心缴款单
	
	public final static short POST_ORDER_STATUS_0 = 0;         // 缴款状态0未审核1通过2不通过
	public final static short POST_ORDER_STATUS_1 = 1;         // 缴款状态0未审核1通过2不通过
	public final static short POST_ORDER_STATUS_2 = 2; 		   // 缴款状态0未审核1通过2不通过
	
	public final static String DRUG_ATTR    = "110";		//基本药物属性 1.国家基本药物（2012版）；2.省增补基本药物；3.其他

	public final static String PATTERN_TYPE = "111";	//专利类型。1. 发明专利；2. 实用新型专利；3. 外观设计专利；4.没有专利；9.不详。

	public final static String HOSP_CAT = "113";
	public final static String DRUG_SOURCE = "112";	          //药品来源   1.国产；2.进口；9不详。
	public final static String PRO_METHOD = "114";	          //采购方式
	public final static String DRUG_CAT = "115";	          //药品分类
	public final static String PROJ_CAT = "116";	          //项目类型
	public final static String BAK_PURCHASE_CAT = "117";      //备案类型   0.临时备案   1.长期备案
	public final static String ARCHIVE_TYPE = "118";          //订单归档类型  1.超出订单截止时间 ；2.超出订单配送截至时间 ；3.已完成订单
	public final static String ORDER_STATUS = "119"; 	      //订单状态 1已提交，2确认配送，3无法配送，4已配送，5已到货，6未到货
	public final static String QUALITYSPEC_CLASS="123";//品规分类
	public final static String HOSP_LEVEL="002";//医疗机构等级
	
	public final static String DRUG_CAT_BAK = "5";
	
	public final static String SETTLE_STATUS_NEW = "0";
	public final static String SETTLE_STATUS_SUBMIT = "1";
	public final static String SETTLE_STATUS_AUDIT_SUCCESS = "2";
	public final static String SETTLE_STATUS_AUDIT_FAILED = "3";
	public final static String SETTLE_STATUS_REAUDIT_SUCCESS = "4";
	public final static String SETTLE_STATUS_REAUDIT_FAILED = "5";
	public final static String SETTLE_STATUS_IN_SETTLE_LIST = "6";
	public final static String SETTLE_STATUS_IN_PAYBILL_LIST = "7";
	
	public final static String CONFIG_ID = "998dd1be-23d0-11e5-9cc0-40f2e9d2c708";//每个区县配送企业数ID
	public final static String PUR_AOUT_DELETE = "9991687b-23d0-11e5-9cc0-40f2e9d2c708";//每个区县配送企业数ID
	public final static String SETTLECONFIG_ID = "7299a065-2a8b-11e5-acdf-40f2e9d2c708";//结算定时任务ID 结算数据生成日期	1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31	每月哪些天可以生成待结算的数据
	public final static String HOSP_DAY_NUM_ID = "999bf44f-23d0-11e5-9cc0-40f2e9d2c708";//医疗机构到货确认截止天数,自提交订单后，多少天医疗机构未进行到货确认系统将自动进行到货确认操作，默认15天
	public final static String COMP_PS_END_DAY_NUM_ID = "999821f9-23d0-11e5-9cc0-40f2e9d2c708";//企业配送截止天数	,自提交订单后，多少天配送企业未配送完成订单，将不允许再进行配送，默认5天
	public final static String COMP_OK_END_DAY_NUM_ID = "999432a1-23d0-11e5-9cc0-40f2e9d2c708";//企业确认截止天数	,自提交订单后，多少天配送企业未确认订单，将不允许再确认，默认2天
	public final static String PUR_PLAN_AUTO_DEL_DAY_NUM_ID = "9991687b-23d0-11e5-9cc0-40f2e9d2c708";//购物计划自动删除天数,自加入购物计划后，多少天未提交系统自动删除，默认30天
//	public final static String EERY_AREA_PS_COMP_ID = "998dd1be-23d0-11e5-9cc0-40f2e9d2c708";//每区县配送企业数,每区县配送企业最大数量，0不限制，其它整数为最大数量
	public final static String EXPERT_SYS_ROLE_ID = "3ee7d19d-496f-4aed-aea8-066bf5c1747d";//专家角色Id
	public final static String AREA_DEL_NUM = "2c7c383b-8e7b-11e5-b427-00ff61ef341e";//限制地区可设置配送企业最大数
	
	
	
	public final static String PROVINCE_DEL_NUM = "0";//每县区限制最大配送企业数
	public final static String CITY_DEL_NUM = "1";//以市为单位限制最大配送企业数
	public final static String COUNTY_DEL_NUM = "2";//以县区为单位限制最大配送企业数
	
	public final static int ZX = 1; //用户类型：中心
	public final static int SC = 2; //生产企业
	public final static int PS = 3; //配送企业
	public final static int YY = 4; //医疗机构
	public final static int ZJ = 5; //专家
	public final static int HSZX = 6; //卫生局
	
	
	public final static int ISNOT_MAIN = 0;//不是主角色
	public final static int IS_MAIN = 1;//是主角色
	
	public final static int UNENABLED = 0;//停用
	public final static int ENABLED = 1;//启用
	
	public final static int LEVEL_GRADE_ONE =1;//角色表中level等级
	public final static int LEVEL_GRADE_TWE =2;
	public final static int LEVEL_GRADE_THREE =3;
	
	public final static int WENJIAN_SHANGCHUAN_YAOPING_DAORU = 0;//药品导入
	public final static int WENJIAN_SHANGCHUAN_SHANGPING_DAORU = 1;//商品导入
	public final static int WENJIAN_SHANGCHUAN_SHANGPING_TIAOJIA = 2;//商品调价导入
	
	public final static int COUNTY_HOSP =1;//县级及县以上医疗机构
	public final static int BASE_HOSP =2;//基层医疗机构
	
	public final static String BASE_DRUG = "1";//使用范围1.基层用药
	public final static String COUNTY_DRUG = "2";//2.县及县以上用药
	
	
	public final static int WENJIAN_STATUS_WEIJIAOYAN = 0;//未校验
	public final static int WENJIAN_STATUS_JIAOYANZHONG = 1;//校验中
	public final static int WENJIAN_STATUS_JIAOYANYICHANG = 2;//校验异常
	public final static int WENJIAN_STATUS_JIAOYANTONGGUO = 3;//校验通过
	public final static int WENJIAN_STATUS_JIAOYANBUTONGGUO = 4;//校验不通过
	public final static int WENJIAN_STATUS_DAORUZHONG = 5;//导入中
	public final static int WENJIAN_STATUS_DAORUCHENGGONG = 6;//导入成功
	public final static int WENJIAN_STATUS_DAORUSHIBAI = 7;//导入失败
	public final static int WENJIAN_STATUS_FANGQIDAORU = 8;//放弃导入
	
	
	public  final static int XIANGMU_YAOPIN_STATUS_WENJIANDAORU = 2;
	
	public final static int XIANGMU_STATUS_QIYONG = 1;//项目状态启用
	public final static int XIANGMU_STATUS_TINGYONG = 0;//项目状态停用
	
	/**********************************基本常用不会变的参数名********************************************/
	public final static String FILEID = "fileId";//文件ID名
	public final static String PROJID = "projId";//项目ID名
	public final static String DRUGNAME = "drugName";//通用名
	public final static String COMPNAME = "compName";//企业名称
	/**********************************基本常用不会变的参数名********************************************/
	
	public final static int DEL_RANGE_ALL = 0;//配送范围--全部
	public final static int DEL_RANGE_COUNTY = 1;//配送范围--县及县以上
	public final static int DEL_RANGE_BASE = 2;//配送范围--基层
	
	public final static int DEL_SELECT_STATUS_QITA = 0;//遴选状态--其他
	public final static int DEL_SELECT_STATUS_WEILINXUAN = 1;//遴选状态--未遴选
	public final static int DEL_SELECT_STATUS_LINXUANTONGUO = 2;//遴选状态--遴选通过
	public final static int DEL_SELECT_STATUS_LINXUANBUTONGUO = 3;//遴选状态--遴选不通过
	
	public final static int DEL_STATUS_UNCONFIRMED = 0;//配送关系状态--未确认
	public final static int DEL_STATUS_CONFIRMED = 1;//配送关系状态--已确认
	public final static int DEL_STATUS_REFUSED = 2;//配送关系状态--拒绝
	public final static int DEL_STATUS_REMOVE = 3;//配送关系状态--解除配送关系
	
	//基础库编号序列
	public final static int STD_YILIAOJIGOU = 8;         //医疗机构
	public final static int STD_JITUAN = 9;              //集团
	public final static int STD_QIYE_PS = 10;            //配送企业
	public final static int STD_QIYE_SC = 11;            //生产企业
	public final static int STD_ZHUANJIA = 12;           //专家
	public final static int STD_PINGGUI = 13;            //品规
	public final static int STD_YAOWUMULU = 14;          //药物目录
	public final static int STD_YAOPIN = 15;             //药品
	public final static int STD_TONGYONGMING = 16;       //通用名
	
    //基础库编号前缀
	public final static String STD_YILIAOJIGOU_PREFIX = "HOS";   //医疗机构
	public final static String STD_JITUAN_PREFIX = "GJT";        //集团
	public final static String STD_QIYE_PS_PREFIX = "PS";        //配送企业
	public final static String STD_QIYE_SC_PREFIX = "SC";        //生产企业
	public final static String STD_ZHUANJIA_PREFIX = "ZJ";       //专家
	public final static String STD_PINGGUI_PREFIX = "PG";        //品规
	public final static String STD_YAOWUMULU_PREFIX = "M";       //药物目录
	public final static String STD_YAOPIN_PREFIX = "BZP";        //药品
	public final static String STD_TONGYONGMING_PREFIX = "TYM";  //通用名
	
	//基础库编号后缀长度
	public final static int STD_YILIAOJIGOU_LEN = 10;         //医疗机构
	public final static int STD_JITUAN_LEN = 6;               //集团
	public final static int STD_QIYE_PS_LEN = 7;              //配送企业
	public final static int STD_QIYE_SC_LEN = 7;              //生产企业
	public final static int STD_ZHUANJIA_LEN = 8;             //专家
	public final static int STD_PINGGUI_LEN = 8;              //品规
	public final static int STD_YAOWUMULU_LEN = 9;            //药物目录
	public final static int STD_YAOPIN_LEN = 8;               //药品
	public final static int STD_TONGYONGMING_LEN = 8;         //通用名	
	
	//企业编辑新增 企业
	public final static int STD_COMPINFO_COMPTYPE_SC_LEN = 1;         //医疗机构
	public final static int STD_COMPINFO_COMPTYPE_PS_LEN = 2;               //集团
	//商品来源
	public final static int GOODS_SOURCE_ZB = 1;               //招标采购
	public final static int GOODS_SOURCE_DDSC = 2;               //定点生产
	public final static int GOODS_SOURCE_GWZC = 3;               //挂网直采
	public final static int GOODS_SOURCE_YJCG = 4;               //议价采购
	public final static int GOODS_SOURCE_BACG = 5;               //备案采购
	public final static int GOODS_SOURCE_BJBX = 6;               //不竞不限
	
	//短缺申报
	public final static int SHORTAGE_OTHER  =0; //申报状态0其他
	public final static int SHORTAGE_SUBMIT  =1; //申报状态 1已申报 
	public final static int SHORTAGE_CANCEL  =2; //申报状态 2已撤销
	
	public final static int SHORTAGE_NO_AUDIT  =0; //短缺核实状态0未核实
	public final static int CONFIRM_SHORTAGE  =1; //核实状态 1核实缺货
	public final static int UNCONFIRM_SHORTAGE  =2; //核实状态 2核实未缺货
	
	public final static int NOT_READ=0;//阅读状态0未阅读
	public final static int HAVE_READ=1;//阅读状态1已阅读
	
	public final static String SHENNEIXIANGMU = "CONT00000000000000000001";//省内区域项目
	public final static String SHENWAIXIANGMU = "CONT00000000000000000002";//省外区域项目
	
	public final static int GZFJYDEL = 1;
	
	public final static String SYSTEM_NAME_KEY="systemname";
	
	public final static int DEPARTMENT_TYPE_SC = 1;//部门类型：生产企业
	public final static int DEPARTMENT_TYPE_PS = 2;//经营企业
	public final static int DEPARTMENT_TYPE_SCPS = 3;//生产企业和经营企业
	public final static int DEPARTMENT_TYPE_YL = 4;//医疗机构
	public final static int DEPARTMENT_TYPE_YX = 5;//药械中心
	public final static int DEPARTMENT_TYPE_JG = 6;//监管机构
	
	public final static long TIME_LIMIT = 24l * 60l * 60l * 1000l;//24小时
	public final static int MANAGEMENT_ACCOUNTS = 0;//账户类型 0 管理账户 
	public final static int BUSINESS_ACCOUNTS =	1;//账户类型  1业务账户
			
	public final static String DEFAULT_PASS="111111";   // 默认密码 

	
	/*1.生产企业、2.经营企业、3. 生产企业和经营企业，4.医疗机构，5.药械中心，6.监管机构*/
	public final static int DEFAULT_SC_ROLE= 1;   // 生产企业默认的角色
	public final static int DEFAULT_PS_ROLE= 2;   // 经营企业默认的角色
	public final static int DEFAULT_SCPS_ROLE= 3;   // 生产经营企业默认的角色
	public final static int DEFAULT_YL_ROLE= 4;   // 医疗机构默认的角色
	public final static int DEFAULT_YX_ROLE= 5;   // 药械中心默认的角色
	public final static int DEFAULT_JG_ROLE= 6;   // 监管机构默认的角色
	
	public final static int DEFAULT_SC_ORG_ROLE= 7;   // 生产企业用户默认的角色
	public final static int DEFAULT_PS_ORG_ROLE= 8;   // 经营企业用户默认的角色
	public final static int DEFAULT_SCPS_ORG_ROLE= 9;   // 生产经营企业用户默认的角色
	public final static int DEFAULT_YL_ORG_ROLE= 10;   // 医疗机构用户默认的角色
	public final static int DEFAULT_YX_ORG_ROLE= 11;   // 药械中心用户默认的角色
	public final static int DEFAULT_JG_ORG_ROLE= 12;   // 监管机构用户默认的角色
	
	public final static int DEFAULT_SC_DEPT_ROLE= 13;   // 生产部门默认的角色
	public final static int DEFAULT_PS_DEPT_ROLE= 14;   // 经营部门默认的角色
	public final static int DEFAULT_SCPS_DEPT_ROLE= 15;  // 生产经营部门默认的角色
	public final static int DEFAULT_YL_DEPT_ROLE= 16;   // 医疗部门默认的角色
	public final static int DEFAULT_YX_DEPT_ROLE= 17;   // 药械部门默认的角色
	public final static int DEFAULT_JG_DEPT_ROLE= 18;   // 监管部门默认的角色
	
	
	public final static int PENDING_SUBMIT = 0; //药品状态： 0:已保存待提交
	public final static int BEEN_SUBMIT =	1; //药品状态： 1：已提交待审核
	public final static int AUDIT_PASSED =	2; //药品状态： 2:审核通过
	public final static int AUDIT_UNPASSED =	3; //药品状态： 3：审核不通过
	
	public final static int RESOURCE_OTHER = 0;//资源类型：其他
	public final static int RESOURCE_SYSTEM = 1;//系统
	public final static int RESOURCE_MODULE = 2;//模块
	public final static int RESOURCE_MENU = 3;//菜单
	public final static int RESOURCE_BUTTON = 4;//按钮
	
	public final static String TMP_ADD = "tmp_add_";// 临时:添加
	public final static String TMP_ERROR = "tmp_error_";// 临时:错误
	public final static String TMP_IMPORT = "tmp_import_";// 临时:导入
}
