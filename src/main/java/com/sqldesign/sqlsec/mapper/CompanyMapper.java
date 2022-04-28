package com.sqldesign.sqlsec.mapper;

import com.sqldesign.sqlsec.model.Company;
import com.sqldesign.sqlsec.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CompanyMapper {

    @Select("select count(*) from sqlsec.company where uid = #{uid}")
    public int isCompanyExist(User user);

    @Insert("insert into sqlsec.company (uid,companyName,address,phone,principal,companyIntro) values(#{uid},#{companyName},#{address},#{phone},#{principal},#{companyIntro})")
    public int addCompany(Company company);
    @Update("update sqlsec.company set companyName = #{companyName},address = #{address},phone=#{phone},principal=#{principal},companyIntro=#{companyIntro} where uid = #{uid}")
    public int updateCompany(Company company);
    @Select("select * from sqlsec.company where uid = #{uid}")
    public Company getCompanyByUid(int uid);
}
