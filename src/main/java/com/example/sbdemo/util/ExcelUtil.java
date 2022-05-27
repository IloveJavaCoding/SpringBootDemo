package com.example.sbdemo.util;

import com.example.sbdemo.bean.ExcelOutBean;
import com.example.sbdemo.bean.Schedule;
import com.example.sbdemo.bean.Sheets;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Virgo
 * @version 1.0
 * @data 2022/5/26 15:07
 * @usage
 */
public class ExcelUtil {
    public static String MakeData(){
        ExcelOutBean outBean = new ExcelOutBean();
        outBean.setName("测试数据.xlsx");
        outBean.setNum(2);

        List<Sheets> sheetsList = new ArrayList<>();
        //信息sheet
        Sheets sheet1 = new Sheets();
        sheet1.setName("节目信息");
        sheet1.setType("array");
        sheet1.setWidth(new int[]{10, 20, 20, 20, 25, 20, 20});
        Object[][] data1 = new Object[2][7];
        data1[0] = new Object[]{"ID", "节目名称", "模板名称", "播放类型", "发布策略", "开始日期", "结束日期"};
        data1[1] = new Object[]{"1", "导入预约全视频", "导入预约", "定时播放", "仅覆盖类型", new Date(), "2022-08-30"};
        sheet1.setData(data1);
        sheetsList.add(sheet1);

        //list sheet
        Sheets sheet2 = new Sheets();
        sheet2.setName("播放排期");
        sheet2.setType("json");
        sheet2.setWidth(new int[]{10, 20, 20, 20, 35, 20});
        sheet2.setHeader(new String[]{"序号", "开始时间", "时长", "结束时间", "素材名称", "总时长"});

        List<Schedule> schedules = new ArrayList<>();
        Schedule schedule;
        long startTime = DateUtil.String2Long("07:00:00", DateUtil.FORMAT_HMS);
        long base = DateUtil.String2Long("00:00:00", DateUtil.FORMAT_HMS);
        for(int i=1; i<1000; i++){
            schedule = new Schedule();
            schedule.setId(i);

            schedule.setStart(DateUtil.long2String(startTime, DateUtil.FORMAT_HMS));
            int duration = getRandom(20, 500) * 1000;
            schedule.setDuration(DateUtil.long2String(duration + base, DateUtil.FORMAT_HMS));
            startTime += duration;
            schedule.setEnd(DateUtil.long2String(startTime, DateUtil.FORMAT_HMS));
            schedule.setName("Video_" + i);
            schedules.add(schedule);
        }
        sheet2.setData(schedules);
        sheetsList.add(sheet2);
        outBean.setSheets(sheetsList);

        return outBean.toJson();
    }

    public static int getRandom(int a, int b){
        return (int) (Math.random()*(b-a) + a);
    }
    //  const json = {
    //                name: 'test.xlsx',
    //                num: 3,
    //                sheets: [{
    //                    name: '节目信息',
    //                    type: 'array',
    //                    width: [10, 20, 20, 20, 25, 20, 20],
    //                    data: [
    //                        ['ID', '节目名称', '模板名称', '播放类型', '发布策略', '开始日期', '结束日期'],
    //                        ['1', '导入预约全视频', '导入预约', '定时播放', '仅覆盖类型', new Date(), '2022-08-30']
    //                    ]
    //                },
    //                    {
    //                        name: '定时信息',
    //                        type: 'json',
    //                        // header: {
    //                        //     order: '序号',
    //                        //     start: '开始时间',
    //                        //     end: '结束时间'
    //                        // },
    //                        // fields: ['order', 'start', 'end'],
    //                        width: [10, 20, 20],
    //                        header: ['序号', '开始时间', '结束时间'],
    //                        data: [
    //                            {
    //                                order: 1,
    //                                start: '07:00:00',
    //                                end: '12:00:00'
    //                            },
    //                            {
    //                                order: 2,
    //                                start: '14:00:00',
    //                                end: '22:00:00'
    //                            }
    //                        ]
    //                    },
    //                    {
    //                        name: '视频排期',
    //                        type: 'json',
    //                        // header: {
    //                        //     order: '序号',
    //                        //     start: '开始时间',
    //                        //     duration: '时长',
    //                        //     end: '结束时间',
    //                        //     name: '素材名称',
    //                        //     all: '总时长'
    //                        // },
    //                        // fields: ['order', 'start', 'duration', 'end', 'name', 'all'],
    //                        width: [10, 20, 20, 20, 35, 20],
    //                        header: ['序号', '开始时间', '时长', '结束时间', '素材名称', '总时长'],
    //                        data: [
    //                            {
    //                                order: 1,
    //                                start: '07:00:00',
    //                                duration: '00:01:00',
    //                                end: '07:01:00',
    //                                name: 'video1',
    //                                all: '01:00:00'
    //                            },
    //                            {
    //                                order: 2,
    //                                start: '07:01:00',
    //                                duration: '00:02:00',
    //                                end: '07:03:00',
    //                                name: 'video2',
    //                            },
    //                            {
    //                                order: 3,
    //                                start: '07:03:00',
    //                                duration: '00:05:00',
    //                                end: '07:08:00',
    //                                name: 'video3',
    //                            }
    //                        ]
    //                    }
    //                ]
    //            };
}
