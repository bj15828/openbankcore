package com.xbeer.mybatis.dao;

import com.xbeer.mybatis.model.BalanceComposition;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface BalanceCompositionMapper {
    @Delete({
        "delete from t_balance_composition",
        "where bala_comp_id = #{balaCompId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String balaCompId);

    @Insert({
        "insert into t_balance_composition (bala_comp_id, name, ",
        "value_date, interest_rate_id, ",
        "is_calc_compound)",
        "values (#{balaCompId,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{valueDate,jdbcType=DATE}, #{interestRateId,jdbcType=VARCHAR}, ",
        "#{isCalcCompound,jdbcType=INTEGER})"
    })
    int insert(BalanceComposition record);

    @InsertProvider(type=BalanceCompositionSqlProvider.class, method="insertSelective")
    int insertSelective(BalanceComposition record);

    @Select({
        "select",
        "bala_comp_id, name, value_date, interest_rate_id, is_calc_compound",
        "from t_balance_composition",
        "where bala_comp_id = #{balaCompId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="bala_comp_id", property="balaCompId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="value_date", property="valueDate", jdbcType=JdbcType.DATE),
        @Result(column="interest_rate_id", property="interestRateId", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_calc_compound", property="isCalcCompound", jdbcType=JdbcType.INTEGER)
    })
    BalanceComposition selectByPrimaryKey(String balaCompId);

    @UpdateProvider(type=BalanceCompositionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BalanceComposition record);

    @Update({
        "update t_balance_composition",
        "set name = #{name,jdbcType=VARCHAR},",
          "value_date = #{valueDate,jdbcType=DATE},",
          "interest_rate_id = #{interestRateId,jdbcType=VARCHAR},",
          "is_calc_compound = #{isCalcCompound,jdbcType=INTEGER}",
        "where bala_comp_id = #{balaCompId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(BalanceComposition record);
}