package com.sqldesign.sqlsec.mapper;

import com.sqldesign.sqlsec.model.Recruitment;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface RecruitmentMapper {
    @Select("select * from sqlsec.recruitment where postion=#{postion}")
    public List<Recruitment> getRecruitByPostion(String postion);
//    select * from sqlsec.users where unix_timestamp(lastLoginTime) < unix_timestamp(now());

    @Select("select * from sqlsec.recruitment where unix_timestamp(lastLoginTime) > unix_timestamp(#{startTime})")
    public List<Recruitment> getRecruitByStartTime(Date startTime);

    @Select("select * from sqlsec.recruitment where unix_timestamp(lastLoginTime) < unix_timestamp(#{endTime})")
    public List<Recruitment> getRecruitByEndTime(Date endTime);
    @Select("select * from sqlsec.recruitment")
    public List<Recruitment> getAllRecruitments();
    @Select("select * from sqlsec.recruitment where uid = #{uid}")
    public List<Recruitment> getRecruitmentsByUid(int uid);
    @Delete("delete from sqlsec.recruitment where recruitId = #{recruitId}")
    public int deleteByRecruitId(int recruitId);
    @Delete("delete from sqlsec.recruitment where uid = {#uid}")
    public int deleteByUid(int uid);
    @Select("select uid from sqlsec.recruitment where recruitId = #{recruitId}")
    public int getUidByRecruitId(int recruitId);
    @Insert("insert into sqlsec.recruitment (uid,position,peopleNum,requirement,postTime) values(#{uid},#{position},#{peopleNum},#{requirement},#{postTime})")
    public int addRecruitment(Recruitment recruitment);
    @Update("update sqlsec.recruitment set position = #{position},peopleNum=#{peopleNum},requirement=#{requirement},postTime=#{postTime} where recruitId=#{recruitId}")
    public int updateRecruitment(Recruitment recruitment);
}
