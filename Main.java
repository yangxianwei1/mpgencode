package edu.sxu;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;
 
@Slf4j
public class Main {
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }





    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();


        // 1.配置数据源：指定数据库类型、连接URL、用户名和密码等。
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/sxu2?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 2. 配置策略：选择需要生成代码的表，设置表名和字段名的命名策略等。

        //2.1全局策略配置（globalConfig）
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");//user.dir 返回项目的根目录即包含 pom.xml 或 .idea 的目录
        System.out.println("===============================");
        log.info("projectPath:" + projectPath);
        gc.setOutputDir(projectPath + "/src/main/java");//2.1.1设置代码生成路径，默认值：D盘根目录
        System.out.println("================================");

        gc.setFileOverride(true);//2.1.2是否覆盖以前文件,默认值false
        gc.setOpen(false);//2.1.3是否在生成后自动打开输出目录，默认false
        gc.setAuthor("y");//2.1.4设置作者
        gc.setDateType(DateType.ONLY_DATE);//2.1.5设置时间类型
        gc.setServiceName("%sService");//2.1.6设置service接口命名规则，%s为占位符
        gc.setServiceImplName("%sServiceImpl");//2.1.7设置service实现类命名规则，%s为占位符
        gc.setControllerName("%sController");//2.1.8设置controller命名规则，%s为占位符
        gc.setXmlName("%sMapper");//2.1.9设置xml命名规则，%s为占位符
        gc.setMapperName("%sMapper");//2.1.10设置mapper命名规则，%s为占位符
        gc.setEntityName("%s");//2.1.11设置entity命名规则，%s为占位符
        gc.setIdType(IdType.AUTO);//2.1.12设置id生成策略，默认值：ASSIGN_ID


        mpg.setGlobalConfig(gc);

        //2.2包配置（packageConfig）
        PackageConfig pc = new PackageConfig();
        pc.setParent("edu.sxu"); //2.2.1设置父包名
        pc.setMapper("mapper"); //2.2.2设置mapper接口所在的子包名
        pc.setEntity("pojo"); //2.2.3设置entity类所在的子包名
        pc.setService("service"); //2.2.4设置service接口所在的子包名
        pc.setServiceImpl("service.impl"); //2.2.5设置service实现类所在的子包名
        pc.setController("controller"); //2.2.6设置controller所在的子包名
        pc.setXml("mapper.xml"); //2.2.7设置xml文件所在的子包名
        mpg.setPackageInfo(pc);

        //2.3数据库表配置（strategyConfig）
        StrategyConfig sc = new StrategyConfig();
        sc.setNaming(NamingStrategy.underline_to_camel); //2.3.1设置表名和字段名的命名策略，默认值：下划线转驼峰
        sc.setColumnNaming(NamingStrategy.underline_to_camel); //2.3.2设置字段名的命名策略，默认值：下划线转驼峰
        sc.setEntityLombokModel(true);//自动lombok
        sc.setRestControllerStyle(true); //2.3.3设置restful风格，即返回json格式
        sc.setControllerMappingHyphenStyle(true); //2.3.4设置controller中url路径是否使用驼峰命名，默认false
        sc.setLogicDeleteFieldName("deleted");//2.3.5设置逻辑删除
        sc.setVersionFieldName("version"); //2.3.6设置乐观锁属性名称
        sc.setInclude(scanner("表名，多个英文逗号分割").split(",")); //2.3.7设置需要生成的表名
        mpg.setStrategy(sc);

        // 执行生成：运行代码生成器，根据配置生成相应的Java代码。
        mpg.execute();
    }
}
