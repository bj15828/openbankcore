package com.xbeer.mybatis.dao;

import com.xbeer.mybatis.model.ProductBalanceCompositionKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface ProductBalanceCompositionMapper {
    @Delete({
        "delete from t_product_balance_composition",
        "where product_id = #{productId,jdbcType=VARCHAR}",
          "and bala_comp_id = #{balaCompId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(ProductBalanceCompositionKey key);

    @Insert({
        "insert into t_product_balance_composition (product_id, bala_comp_id)",
        "values (#{productId,jdbcType=VARCHAR}, #{balaCompId,jdbcType=VARCHAR})"
    })
    int insert(ProductBalanceCompositionKey record);

    @InsertProvider(type=ProductBalanceCompositionSqlProvider.class, method="insertSelective")
    int insertSelective(ProductBalanceCompositionKey record);
}