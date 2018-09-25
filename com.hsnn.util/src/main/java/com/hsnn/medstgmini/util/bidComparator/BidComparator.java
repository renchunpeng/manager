package com.hsnn.medstgmini.util.bidComparator;

import java.util.*;

/**
 * Created by Chenglong
 *
 * @package com.hsnn.medstgmini.util.bidComparator
 * @date 2017-6-15 19:07
 */
public class BidComparator {
    /**
     * 企业页面元素排序
     * 按照规定顺序对资审要素进行排序，适用于资审要素展示页面
     * @param set
     * @return
     */
    public static Set<String> CompComparator(Set<String> set) {
        // 根据排序要求，顺序插入列名
        final List<String> sortList = new ArrayList<>();

        sortList.add("COMPANY_NAME");//企业名称
        sortList.add("COMPANY_ACCOUNT_CODE");//企业用户名
        sortList.add("COMPANY_TYPE");//企业类型
        sortList.add("GROUP_NAME");//企业所属集团名称
        sortList.add("AREA_NAME");//所属地区
        sortList.add("ORGANIZATION_CODE");//组织机构代码
        sortList.add("COMP_BASE_FILE");//企业基本情况表
        sortList.add("SUPPLY_PROMISE_FILE");//供货承诺函
        sortList.add("COMP_CREDIT_FILE");//企业诚信有关情况材料
        sortList.add("COMPANY_CONTACT_FAX");//企业传真号码
        sortList.add("ADDRESS");//企业生产地址
        sortList.add("COMP_COMMUNICATION_ADDRESS");//企业通讯地址
        sortList.add("COMPANY_CONTACT_TEL");//企业联系电话
        sortList.add("ZIP_CODE");//邮编
        sortList.add("EMAIL");//邮箱
        sortList.add("WEBSITE");//网址
        sortList.add("LEGAL_NAME");//法人代表人姓名
        sortList.add("LEGAL_PHONE");//法人代表电话
        sortList.add("LEGAL_NUMBER");//法人代表人证件号码
        sortList.add("APPLICANT_NAME");//申报代表姓名
        sortList.add("APPLICANT_PHONE");//申报代表联系电话
        sortList.add("APPLICANT_ID_CARD");//申报代表身份证号
        sortList.add("APPLICANT_URGENT");//申报代表紧急联系人及电话
        sortList.add("LEGAL_CERTIFICATE_FILE");//法人代表授权书
        sortList.add("BUSINESS_LICENSE");//营业执照注册号
        sortList.add("REGISTERED_CAPITAL");//营业执照注册资金(万元)
        sortList.add("BUSINESS_LICENSE_ADDR");//营业执照注册地址
        sortList.add("BUSINESS_LICENSE_END_DATE");//营业执照有效期至
        sortList.add("BUSINESS_LICENSE_SCOPE");//营业执照经营范围
        sortList.add("BUSINESS_LICENSE_FILE");//营业执照上传文件
        sortList.add("PRODUCTION_PERMISSION_CODE");//生产许可证号
        sortList.add("PRODUCTION_PERMISSION_END_DATE");//生产许可证有效期至
        sortList.add("PRODUCT_PERMISSION_PRO_ADDR");//生产许可证生产地址
        sortList.add("PRODUCT_PERMISSION_PRO_RANGE");//生产许可证生产范围
        sortList.add("PRODUCTION_OLD_NAME");//生产企业名称有无变更
        sortList.add("PRODUCTION_COMP_GMP");//生产企业GMP信息
        sortList.add("PRODUCTION_PERMISSION_FILE");//药品生产许可证上传文件
        sortList.add("PRODUCT_PERMISSION_REG_ADDR");//生产许可证注册地址
        sortList.add("PRODUCTION_PERMISSION_LAWER");//生产许可证法人
        sortList.add("PRODUCT_PERMISSION_SORT_CODE");//生产许可证分类码
        sortList.add("BUSINESS_PERMISSION_CODE");//药品经营许可证编号
        sortList.add("BUSINESS_PERMISSION_END_DATE");//药品经营许可证有效期至
        sortList.add("BUSINESS_PERMISSION_WARE_ADDR");//药品经营许可证注册地址
        sortList.add("BUSINESS_PERMISSION_REG_ADDR");//药品经营许可证仓库地址
        sortList.add("BUSINESS_PERMISSION_RANGE");//药品经营许可证经营范围
        sortList.add("MANAGEMENT_OLD_NAME");//经营企业名称有无变更
        sortList.add("GSP_CODE");//GSP证书编号
        sortList.add("PRODUCTION_GSP_RANGE");//GSP认证范围
        sortList.add("PRODUCTION_GSP_START_TIME");//GSP认证日期
        sortList.add("PRODUCTION_GSP_END_TIME");//GSP有效期至
        sortList.add("PRODUCATION_GSP_FILE");//查看GSP证书
        sortList.add("TAXPAYER_NAME");//纳税人名称
        sortList.add("LAST_YEAR_INCOME");//上一年度单一企业营业额或销售额（万元）
        sortList.add("TAX_REGISTRATION_FILE");//上传税务报表文件
        sortList.add("COMP_FOURORMORE_RECORDS");//2015年以来申报企业有无4个及以上品种药品质量不合格记录
        sortList.add("COMP_IS_WEIGUI_RECORDS");//2015年以来，在生产或经营活动中有无生产假药等严重违法违规记录
        sortList.add("COMP_IS_HEIMINGD_RECORDS");//2015年以来，申报企业在国家和陕西省药品集中采购中，有无被列入“黑名单”
        sortList.add("SHANXI_BAD_RECORD");//申报企业有无两年内一次列入陕西省医药购销领域商业贿赂不良记录
        sortList.add("PROVINCE_BAD_RECORD");//申报企业有无五年内两次及以上列入其他省级区域医药购销领域商业贿赂不良记录
        sortList.add("QUALITY_CERTIFICATE");//申报企业2015年以来有无获得全国质量标杆企业证书
        sortList.add("INNOVATE_CERTIFICATE");//申报企业2015年以来有无获得创新企业证书
        sortList.add("PUBLIC_WELFARE");//2015年以来有无对陕西省公益捐赠、本省企业对外省公益捐赠
        sortList.add("STRATEGY_DRUG");//承担或参与陕西省重大疫情、战略药品储备证明材料

        List<String> setList = sort(set, sortList);
        return new LinkedHashSet<>(setList);
    }

    /**
     * 药品页面元素排序
     * 按照规定顺序对资审要素进行排序，适用于资审要素展示页面
     * @param set
     * @return
     */
    public static Set<String> GoodsComparator(Set<String> set) {
        // 根据排序要求，顺序插入列名
        final List<String> sortList = new ArrayList<>();

        sortList.add("DRUG_PRODUCT_ID");//目录编号
        sortList.add("DRUG_PRODUCT_NAME");//目录通用名
        sortList.add("DRUG_MEDICINEMODEL");//目录剂型
        sortList.add("DRUG_OUTLOOK");//目录规格
        sortList.add("CATEGORY");//药品类别
        sortList.add("ATTRIBUTE");//目录属性
        sortList.add("CLASS_ONE");//目录类别1
        sortList.add("CLASS_TWO");//目录类别2
        sortList.add("PHAR");//药理分类
        sortList.add("MEDICAL_INSURANCE_NUMBER");//医保序号
        sortList.add("BASE_DRUG_NUMBER");//基药序号
        sortList.add("NONBASE_DRUG_NUMBER");//非基药序号
        sortList.add("PRODUCT_ID");//药品流水号
        sortList.add("PRODUCT_NAME_APP");//实际通用名
        sortList.add("GOODS_NAME");//商品名
        sortList.add("MEDICINEMODEL_APP");//实际剂型
        sortList.add("OUTLOOK_APP");//实际规格
        sortList.add("FACTOR");//包装数量
        sortList.add("MIN_UNIT");//最小制剂单位
        sortList.add("UNIT");//包装单位
        sortList.add("YPID");//国家药品编码
        sortList.add("DRUG_STANDARD_CODE");//药品本位码
        sortList.add("VALID_END_TIME");//药品有效期（月）
        sortList.add("VALIDITY_LONG_THAN_OTHER");//药品有效期是否长于同组其他药品
        sortList.add("LEVEL_ID");//用法用量
        sortList.add("MAX_DOSAGE_DAY");//最大日服用量
        sortList.add("MIN_DOSAGE_DAY");//最小日服用量
        sortList.add("COMPANY_NAME_SC");//企业名称
        sortList.add("REGCODE");//企业用户名
        sortList.add("DRUG_DISP_FILE");//药品说明书
        sortList.add("UNIT_SPEC");//包装特征
        sortList.add("UNIT_SPEC_REMARK");//包装特征说明
        sortList.add("PACKAGING_CHARACTERISTICS_FILE");//包装特征相关材料
        sortList.add("ATTR_SPEC");//附加装置说明
        sortList.add("ATTR_OTHER");//其他附加装置
        sortList.add("DRUG_SPECINFO");//药品特征信息
        sortList.add("ATTACHMENT_FILE");//附加装置相关材料
        sortList.add("MAX_PACK");//大包装
        sortList.add("MIDDLE_PACK");//中包装
        sortList.add("IS_NEW_INDICATION");
        sortList.add("IS_NEW_APPROVE");
        sortList.add("SOURCE");//药品来源
        sortList.add("APPROVAL_CODE");//批准文号
        sortList.add("APPROVAL_CODE_ENDTIME");//批准文号有效期至
        sortList.add("ACCEPT_CODE");//批准文号受理单号
        sortList.add("APPROVAL_CODE_FILE");//批准文号相关签章图片
        sortList.add("MANAGEMENT_NAME");//经营企业
        sortList.add("FOR_PACKING_COMP_NAME");//进口药品分包装企业名称
        sortList.add("FOR_DRUG_REGISTER_NUMBER");//进口药品注册证号
        sortList.add("FOR_DRUG_VALIDITY_TIME");//进口药品注册证号有效期
        sortList.add("FOR_COMP_ENNAME");//进口药品生产企业全称（外文）
        sortList.add("FOR_COMP_CHNAME");//进口药品生产企业全称（中文）
        sortList.add("FOR_COMP_CHADDR");//进口药品生产地址（中文）
        sortList.add("FOR_COMP_ENADDR");//进口药品生产地址（外文）
        sortList.add("FOR_DRUG_AGENT_FILE");//进口药品总代理证明
        sortList.add("IMPORT_END_DATE");//代理有效截止日期
        sortList.add("FOR_DRUG_NOTARIZATION_FILE");//上传公证处文件
        sortList.add("FOR_DRUG_SIGNATURE_FILE");//进口药品注册证签章图片
        sortList.add("INSPECTION_REPORT_FILE");//检验报告上传文件
        sortList.add("HAS_ENT_PERMIT");//是否有口岸检验报告
        sortList.add("SUR_DATE");//药品检验报告书有效期至
        sortList.add("PORT_TEST_FILE");//上传口岸药检部门检验报告
        sortList.add("GMP_CODE");//GMP证书号
        sortList.add("GSP_GMP_CODE");//GSP/GMP证书编号
        sortList.add("GSP_GMP_GRANT_TIME");//GSP/GMP发证时间
        sortList.add("GSP_GMP_VALIDITY_TIME");//GSP/GMP证书有效期至
        sortList.add("GSP_GMP_RANKING");//GSP/GMP认证范围
        sortList.add("GSPGMP_FILE");//相关GMP/GSP证书
        sortList.add("QUAL_STANDARD_TYPE");//质量标准类别
        sortList.add("QUAL_STANDARD_CODE");//质量标准编号
        sortList.add("EXE_STD_OTHER");//其他质量标准说明
        sortList.add("IS_EXE_ACCP_CODE");//是否有质量标准受理单号
        sortList.add("EXE_ACCP_CODE");//质量标准受理单号
        sortList.add("EXE_STD_DATE");//质量标准有效期至
        sortList.add("EXE_STD_FILE");//上传质量标准及其批件
        sortList.add("PRICE_SOURCE");//定价形式
        sortList.add("IS_SIG_PRICE");//是否单独定价
        sortList.add("IS_LOW_PRICE");//是否低价药
        sortList.add("RETAIL_PRICE_LIMIT");//最低零售价
        sortList.add("MAXIMUM_RETAIL_PRICE");//最高零售价
        sortList.add("RETAIL_PRICE_SOURCE");//最高零售价来源
        sortList.add("RETAIL_PRICE_FILE");//最高零售价文件号
        sortList.add("PRICE_BASIS");//价格依据
        sortList.add("PRICE_FILE");//价格文件
        sortList.add("TRANS_CONDITION");//储藏及运输条件
        sortList.add("IS_BETTER_TC");//储运条件是否优于同等产品
        sortList.add("STORAGE_AUTHENTICATION_FILE");//上传储运条件认证材料签章图片
        sortList.add("RAW_MATERIAL_SOURCE");//主要原料来源（复方制剂指所有成分）
        sortList.add("GMP_PERMIT");//原料药GMP证书及批件、中药材GAP认证材料
        sortList.add("IS_NEW_PRODUCT");//是否为国家重点新产品
        sortList.add("IS_PATENT_PROTECTION");//是否为专利保护期内的实用新型专利、工艺专利和处方专利药品
        sortList.add("QUALITY_PROBLEM_ONE");//申报企业是否存在有1次无菌、热源（细菌内毒素）、自由微生物限度、降压物质方面质量问题记录
        sortList.add("QUALITY_PROBLEM_TWO");//申报企业是否存在有1次含量测定、有关物质、溶出度（释放度）、PH值、不溶性微粒的质量问题记录
        sortList.add("QUALITY_PROBLEM_THREE");//申报企业是否存在有1次重量（或装量）差异、水分、检查中的其他项目、可见异物的质量问题记录
        sortList.add("BD_FROM212");//2015年以来申报品种是否有2次及以上质量不合格记录
        sortList.add("QUALITY_PROBLEM_RECALL");//2015年以来是否被国家药监局召回
        sortList.add("QUALITY_LEVEL");//质量层次
        sortList.add("SUPPLEMENTARY");//产品补充说明
        sortList.add("ELECTRONIC_PACK");//电子监管包装或标签
        sortList.add("IS_IMPORT_COMPANY");//是否具有代理商
        sortList.add("IS_TRUST_COMPANY");//是否委托加工
        sortList.add("TRUST_END_DATE");//受托加工截至日期
        sortList.add("TRUST_COMPANY_NAME");//受托加工企业名称
        sortList.add("ISSUBMIT_POSITIVE_CERTIFICATE");//是否递交试行标准转正受理证明
        sortList.add("TRIAL_STANDARD_ENDTIME");//试行标准截止日期
        sortList.add("PACKAGE1");
        sortList.add("PACKAGE2");
        sortList.add("PACKAGE3");
        sortList.add("PACKAGE4");
        sortList.add("PACKAGE5");
        sortList.add("PACKAGE6");
        sortList.add("PACKAGE7");
        sortList.add("PACKAGE8");
        sortList.add("PACKAGE9");
        sortList.add("PACKAGE10");

        List<String> setList = sort(set, sortList);
        return new LinkedHashSet<>(setList);
    }


    /**
     * 企业页面元素排序
     * 按照规定顺序对资审要素进行排序，适用于资审要素展示页面
     * @param set
     * @return
     */
    public static Set<String> CompChineseComparator(Set<String> set) {
        // 根据排序要求，顺序插入列名
        final List<String> sortList = new ArrayList<>();

        sortList.add("企业名称");
        sortList.add("企业用户名");
        sortList.add("企业类型");
        sortList.add("企业所属集团名称");
        sortList.add("所属地区");
        sortList.add("组织机构代码");
        sortList.add("企业基本情况表");
        sortList.add("供货承诺函");
        sortList.add("企业诚信有关情况材料");
        sortList.add("企业传真号码");
        sortList.add("企业生产地址");
        sortList.add("企业通讯地址");
        sortList.add("企业联系电话");
        sortList.add("邮编");
        sortList.add("邮箱");
        sortList.add("网址");
        sortList.add("法人代表人姓名");
        sortList.add("法人代表电话");
        sortList.add("法人代表人证件号码");
        sortList.add("申报代表姓名");
        sortList.add("申报代表联系电话");
        sortList.add("申报代表身份证号");
        sortList.add("申报代表紧急联系人及电话");
        sortList.add("法人代表授权书");
        sortList.add("营业执照注册号");
        sortList.add("营业执照注册资金(万元)");
        sortList.add("营业执照注册地址");
        sortList.add("营业执照有效期至");
        sortList.add("营业执照经营范围");
        sortList.add("营业执照上传文件");
        sortList.add("生产许可证号");
        sortList.add("生产许可证有效期至");
        sortList.add("生产许可证生产地址");
        sortList.add("生产许可证生产范围");
        sortList.add("生产企业名称有无变更");
        sortList.add("生产企业GMP信息");
        sortList.add("药品生产许可证上传文件");
        sortList.add("生产许可证注册地址");
        sortList.add("生产许可证法人");
        sortList.add("生产许可证分类码");
        sortList.add("药品经营许可证编号");
        sortList.add("药品经营许可证有效期至");
        sortList.add("药品经营许可证注册地址");
        sortList.add("药品经营许可证仓库地址");
        sortList.add("药品经营许可证经营范围");
        sortList.add("经营企业名称有无变更");
        sortList.add("GSP证书编号");
        sortList.add("GSP认证范围");
        sortList.add("GSP认证日期");
        sortList.add("GSP有效期至");
        sortList.add("查看GSP证书");
        sortList.add("纳税人名称");
        sortList.add("上一年度单一企业营业额或销售额（万元）");
        sortList.add("上传税务报表文件");
        sortList.add("2015年以来申报企业有无4个及以上品种药品质量不合格记录");
        sortList.add("2015年以来，在生产或经营活动中有无生产假药等严重违法违规记录");
        sortList.add("2015年以来，申报企业在国家和陕西省药品集中采购中，有无被列入“黑名单”");
        sortList.add("申报企业有无两年内一次列入陕西省医药购销领域商业贿赂不良记录");
        sortList.add("申报企业有无五年内两次及以上列入其他省级区域医药购销领域商业贿赂不良记录");
        sortList.add("申报企业2015年以来有无获得全国质量标杆企业证书");
        sortList.add("申报企业2015年以来有无获得创新企业证书");
        sortList.add("2015年以来有无对陕西省公益捐赠、本省企业对外省公益捐赠");
        sortList.add("承担或参与陕西省重大疫情、战略药品储备证明材料");

        List<String> setList = sort(set, sortList);
        return new LinkedHashSet<>(setList);
    }

    /**
     * 药品页面元素排序
     * 按照规定顺序对资审要素进行排序，适用于资审要素展示页面
     * @param set
     * @return
     */
    public static Set<String> GoodsChineseComparator(Set<String> set) {
        // 根据排序要求，顺序插入列名
        final List<String> sortList = new ArrayList<>();

        sortList.add("目录编号");
        sortList.add("目录通用名");
        sortList.add("目录剂型");
        sortList.add("目录规格");
        sortList.add("药品类别");
        sortList.add("目录属性");
        sortList.add("目录类别1");
        sortList.add("目录类别2");
        sortList.add("药理分类");
        sortList.add("医保序号");
        sortList.add("基药序号");
        sortList.add("非基药序号");
        sortList.add("药品流水号");
        sortList.add("实际通用名");
        sortList.add("商品名");
        sortList.add("实际剂型");
        sortList.add("实际规格");
        sortList.add("包装数量");
        sortList.add("最小制剂单位");
        sortList.add("包装单位");
        sortList.add("国家药品编码");
        sortList.add("药品本位码");
        sortList.add("药品有效期（月）");
        sortList.add("药品有效期是否长于同组其他药品");
        sortList.add("用法用量");
        sortList.add("最大日服用量");
        sortList.add("最小日服用量");
        sortList.add("企业名称");
        sortList.add("企业用户名");
        sortList.add("药品说明书");
        sortList.add("包装特征");
        sortList.add("包装特征说明");
        sortList.add("包装特征相关材料");
        sortList.add("附加装置说明");
        sortList.add("其他附加装置");
        sortList.add("药品特征信息");
        sortList.add("附加装置相关材料");
        sortList.add("大包装");
        sortList.add("中包装");
        sortList.add("IS_NEW_INDICATION");
        sortList.add("IS_NEW_APPROVE");
        sortList.add("药品来源");
        sortList.add("批准文号");
        sortList.add("批准文号有效期至");
        sortList.add("批准文号受理单号");
        sortList.add("批准文号相关签章图片");
        sortList.add("经营企业");
        sortList.add("进口药品分包装企业名称");
        sortList.add("进口药品注册证号");
        sortList.add("进口药品注册证号有效期");
        sortList.add("进口药品生产企业全称（外文）");
        sortList.add("进口药品生产企业全称（中文）");
        sortList.add("进口药品生产地址（中文）");
        sortList.add("进口药品生产地址（外文）");
        sortList.add("进口药品总代理证明");
        sortList.add("代理有效截止日期");
        sortList.add("上传公证处文件");
        sortList.add("进口药品注册证签章图片");
        sortList.add("检验报告上传文件");
        sortList.add("是否有口岸检验报告");
        sortList.add("药品检验报告书有效期至");
        sortList.add("上传口岸药检部门检验报告");
        sortList.add("GMP证书号");
        sortList.add("GSP/GMP证书编号");
        sortList.add("GSP/GMP发证时间");
        sortList.add("GSP/GMP证书有效期至");
        sortList.add("GSP/GMP认证范围");
        sortList.add("相关GMP/GSP证书");
        sortList.add("质量标准类别");
        sortList.add("质量标准编号");
        sortList.add("其他质量标准说明");
        sortList.add("是否有质量标准受理单号");
        sortList.add("质量标准受理单号");
        sortList.add("质量标准有效期至");
        sortList.add("上传质量标准及其批件");
        sortList.add("定价形式");
        sortList.add("是否单独定价");
        sortList.add("是否低价药");
        sortList.add("最低零售价");
        sortList.add("最高零售价");
        sortList.add("最高零售价来源");
        sortList.add("最高零售价文件号");
        sortList.add("价格依据");
        sortList.add("价格文件");
        sortList.add("储藏及运输条件");
        sortList.add("储运条件是否优于同等产品");
        sortList.add("上传储运条件认证材料签章图片");
        sortList.add("主要原料来源（复方制剂指所有成分）");
        sortList.add("原料药GMP证书及批件、中药材GAP认证材料");
        sortList.add("是否为国家重点新产品");
        sortList.add("是否为专利保护期内的实用新型专利、工艺专利和处方专利药品");
        sortList.add("申报企业是否存在有1次无菌、热源（细菌内毒素）、自由微生物限度、降压物质方面质量问题记录");
        sortList.add("申报企业是否存在有1次含量测定、有关物质、溶出度（释放度）、PH值、不溶性微粒的质量问题记录");
        sortList.add("申报企业是否存在有1次重量（或装量）差异、水分、检查中的其他项目、可见异物的质量问题记录");
        sortList.add("2015年以来申报品种是否有2次及以上质量不合格记录");
        sortList.add("2015年以来是否被国家药监局召回");
        sortList.add("质量层次");
        sortList.add("产品补充说明");
        sortList.add("电子监管包装或标签");
        sortList.add("是否具有代理商");
        sortList.add("是否委托加工");
        sortList.add("受托加工截至日期");
        sortList.add("受托加工企业名称");
        sortList.add("是否递交试行标准转正受理证明");
        sortList.add("试行标准截止日期");
        sortList.add("PACKAGE1");
        sortList.add("PACKAGE2");
        sortList.add("PACKAGE3");
        sortList.add("PACKAGE4");
        sortList.add("PACKAGE5");
        sortList.add("PACKAGE6");
        sortList.add("PACKAGE7");
        sortList.add("PACKAGE8");
        sortList.add("PACKAGE9");
        sortList.add("PACKAGE10");
        List<String> setList = sort(set, sortList);
        return new LinkedHashSet<>(setList);
    }

    private static List<String> sort(Set<String> set, final List<String> sortList) {
        TreeSet<String> mapCommentsSet = new TreeSet<>(set);
        List<String> setList = new ArrayList<>(mapCommentsSet);
        Collections.sort(setList, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                int j = sortList.indexOf(o1);
                int i = sortList.indexOf(o2);

                if (o1 == o2) {
                    return 0;
                }
                if (i > j) {
                    return -1;
                }
                if (i < j) {
                    return 1;
                }
                return 0;
            }
        });
        return setList;
    }


}
