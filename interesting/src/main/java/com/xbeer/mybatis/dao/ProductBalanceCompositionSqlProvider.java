package com.xbeer.mybatis.dao;

import com.xbeer.mybatis.model.ProductBalanceCompositionKey;
import org.apache.ibatis.jdbc.SQL;

public class ProductBalanceCompositionSqlProvider {

    public String insertSelective(ProductBalanceCompositionKey record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_product_balance_composition");
        
        if (record.getProductId() != null) {
            sql.VALUES("product_id", "#{productId,jdbcType=VARCHAR}");
        }
        
        if (record.getBalaCompId() != null) {
            sql.VALUES("bala_comp_id", "#{balaCompId,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }
}