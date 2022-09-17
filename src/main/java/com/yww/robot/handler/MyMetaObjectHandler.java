package com.yww.robot.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * <p>
 *      MybatisPlus的自动填充处理器（注意是对象属性名不是表的字段名）
 * </p>
 *
 * @ClassName MyMetaObjectHandler
 * @Author yww
 * @Date 2022/9/17 23:27
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入时更新创建和修改时间
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", LocalDateTime::now, LocalDateTime.class);
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
    }

    /**
     * 修改时更新修改时间
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
    }

}
