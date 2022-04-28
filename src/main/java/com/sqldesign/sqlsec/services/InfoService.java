package com.sqldesign.sqlsec.services;

import com.sqldesign.sqlsec.mapper.JobHunterMapper;
import com.sqldesign.sqlsec.mapper.RecruitmentMapper;
import com.sqldesign.sqlsec.model.JobHunter;
import com.sqldesign.sqlsec.model.Recruitment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class InfoService {
    @Autowired
    RecruitmentMapper recruitmentMapper;
    @Autowired
    JobHunterMapper jobHunterMapper;
    public List<Recruitment> GetAllRecruitments(){
        return recruitmentMapper.getAllRecruitments();
    }

    public List<Recruitment> GetRecruitmentsByUid(int uid){
        return recruitmentMapper.getRecruitmentsByUid(uid);
    }

    public int DeleteRecruitment(int recruitId){
        return recruitmentMapper.deleteByRecruitId(recruitId);
    }

    public boolean ValidateUidAndRecruitId(int recruitId,int uid){
        try{
            int targetUid = recruitmentMapper.getUidByRecruitId(recruitId);
            return targetUid == uid;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public int AddRecruitment(Recruitment recruitment){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String postTime = simpleDateFormat.format(new Date());
        recruitment.setPostTime(postTime);
        return recruitmentMapper.addRecruitment(recruitment);
    }

    public List<JobHunter> GetAllResumes(){
        return jobHunterMapper.getAllResumes();
    }

    public List<JobHunter> GetAllResumesByUid(int uid){
        return jobHunterMapper.getResumesByUid(uid);
    }

    public int AddResume(JobHunter jobHunter){
        return  jobHunterMapper.addResume(jobHunter);
    }

    public boolean ValidateUidAndResumeId(int resumeId,int uid){
        int targetUid = jobHunterMapper.getUidByResumeId(resumeId);
        return targetUid == uid;
    }
    public int DeleteResume(int resumeId){
        return jobHunterMapper.deleteByResumeId(resumeId);
    }

    public int UpdateResume(JobHunter jobHunter){
        return jobHunterMapper.updateResume(jobHunter);
    }

    public int UpdateRecruitment(Recruitment recruitment){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String postTime = simpleDateFormat.format(new Date());
        recruitment.setPostTime(postTime);
        return recruitmentMapper.updateRecruitment(recruitment);
    }
}
