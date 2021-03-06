package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author ChengLongsheng
 * @since 2021-06-28
 */
public interface EduTeacherService extends IService<EduTeacher> {

    //查询前四条热门名师
    List<EduTeacher> getHotTeacher();

    // 1分页查询讲师
    Map<String, Object> getTeacherFrontList(Page<EduTeacher> teacherPage);
}
