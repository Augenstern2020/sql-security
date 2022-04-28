package com.sqldesign.sqlsec.mapper;

import com.sqldesign.sqlsec.model.JobHunter;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface JobHunterMapper {
    @Select("select * from sqlsec.jobHunter where uid = #{uid}")
    public List<JobHunter> getResumesByUid(int uid);
    @Select("select * from sqlsec.jobHunter")
    public List<JobHunter> getAllResumes();
    @Insert("insert into sqlsec.jobHunter (uid,resume) values(#{uid},#{resume})")
    public int addResume(JobHunter jobHunter);
    @Select("select uid from sqlsec.jobHunter where resumeId = #{resumeId}")
    public int getUidByResumeId(int resumeId);
    @Delete("delete from sqlsec.jobHunter where resumeId = #{resumeId}")
    public int deleteByResumeId(int resumeId);
    @Update("update sqlsec.jobHunter set resume = #{resume} where resumeId = #{resumeId}")
    public int updateResume(JobHunter jobHunter);
}
