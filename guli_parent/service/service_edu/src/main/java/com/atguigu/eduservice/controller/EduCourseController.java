package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.Result;
import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import com.atguigu.eduservice.entity.vo.CoursePublishVo;
import com.atguigu.eduservice.service.EduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author ChengLongsheng
 * @since 2021-07-20
 */
@RestController
@RequestMapping("/eduservice/course")
@CrossOrigin
public class EduCourseController {

    @Autowired
    private EduCourseService courseService;

    // 课程列表
    @GetMapping
    public Result getCourseList() {
        List<EduCourse> list = courseService.list(null);
        return Result.ok().data("list", list);
    }


    // 添加课程信息
    @PostMapping("/addCourseInfo")
    public Result addCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {

        String id = courseService.saveCourseInfo(courseInfoVo);
        // 返回id为后续课程章节使用
        return Result.ok().data("courseId", id);

    }

    // 根据课程id查询课程基本信息
    @GetMapping("/getCourseInfo/{courseId}")
    public Result getCourseInfo(@PathVariable String courseId) {
        CourseInfoVo courseInfoVo = courseService.getCourseInfo(courseId);
        return Result.ok().data("courseInfoVo", courseInfoVo);
    }

    // 修改课程信息
    @PostMapping("/updateCourseInfo")
    public Result updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        courseService.updateCourseInfo(courseInfoVo);
        return Result.ok();
    }

    // 根据课程id查询课程确认信息
    @GetMapping("/getPublishCourseInfo/{id}")
    public Result getPublishCourseInfo(@PathVariable String id) {
        CoursePublishVo coursePublishVo = courseService.publishCourseInfo(id);
        return Result.ok().data("publishCourseInfo", coursePublishVo);
    }

    // 课程最终发布
    @PostMapping("/publishCourse/{id}")
    public Result publishCourse(@PathVariable String id) {
        EduCourse eduCourse = new EduCourse();
        eduCourse.setId(id);
        eduCourse.setStatus("Normal");// 课程发布状态
        courseService.updateById(eduCourse);
        return Result.ok();
    }

    // 删除课程
    @DeleteMapping("{courseId}")
    public Result deleteCourse(@PathVariable String courseId) {
        courseService.removeCourse(courseId);
        return Result.ok();
    }

}

