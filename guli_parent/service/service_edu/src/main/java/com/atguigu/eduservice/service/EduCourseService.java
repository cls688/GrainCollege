package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import com.atguigu.eduservice.entity.vo.CoursePublishVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author ChengLongsheng
 * @since 2021-07-20
 */
public interface EduCourseService extends IService<EduCourse> {

    // 添加课程信息
    String saveCourseInfo(CourseInfoVo courseInfoVo);

    // 根据课程id查询课程基本信息
    CourseInfoVo getCourseInfo(String courseId);

    // 修改课程信息
    void updateCourseInfo(CourseInfoVo courseInfoVo);

    // 根据课程id查询课程确认信息
    CoursePublishVo publishCourseInfo(String id);

    // 删除课程
    void removeCourse(String courseId);

    //查询前八条热门课程
    List<EduCourse> getHotCourse();
}
