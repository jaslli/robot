package com.yww.robot.handler;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *      MyBatisPlus的代码生成器
 * </p>
 *
 * @ClassName CodeGenerator
 * @Author yww
 * @Date 2022/9/17 23:28
 */
public class CodeGenerator {

    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://localhost:3306/robot?userUnicode=true&characterEncoding=utf-8&serverTimezone=UTC",
            "root",
            "password");


    /**
     * 执行 run
     */
    public static void main(String[] args) {
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                // 全局配置
                .globalConfig(builder -> builder
                        // 作者
                        .author("yww")
                        // 指定输出目录
                        .outputDir("C:/Users/lliyoo/Desktop/robot/src/main/java")
                        // 	覆盖已生成文件
                        .fileOverride()
                        // 开启swagger模式
                        .enableSwagger()
                        // 禁止打开输出目录
                        .disableOpenDir()
                        // 时间策略
                        .dateType(DateType.TIME_PACK)
                        // 注释日期
                        .commentDate("yyyy-MM-dd")
                        .build()
                )
                // 包配置
                .packageConfig(builder -> builder
                        // 父包名
                        .parent("com.yww.robot")
                        .build()
                )
                // 策略配置
                .strategyConfig((scanner, builder) -> builder
                        // 增加表匹配
                        .addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                        .addTablePrefix("sys_")
                        // controller策略
                        .controllerBuilder().enableRestStyle().enableHyphenStyle()
                        // entity策略配置
                        .entityBuilder().enableLombok()
                        .idType(IdType.ASSIGN_ID)
                        .enableTableFieldAnnotation()
                        .addTableFills(new Column("create_time", FieldFill.INSERT))
                        .addTableFills(new Column("update_time", FieldFill.INSERT_UPDATE))
                        .build()
                )
                .execute();
    }

    /**
     * 处理输入all的情况
     */
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }

}