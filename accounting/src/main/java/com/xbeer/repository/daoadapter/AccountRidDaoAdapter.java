package com.xbeer.repository.daoadapter;

import org.apache.ibatis.annotations.Insert;
import org.springframework.context.annotation.Primary;

import com.xbeer.repository.mybatis.AccountRid;
import com.xbeer.repository.mybatis.dao.AccountRidMapper;


@Primary
public interface AccountRidDaoAdapter extends AccountRidMapper  {


  @Insert({
    "insert into t_account_rid (acct_id, rid)",
    "values (#{acctId,jdbcType=VARCHAR}, #{rid,jdbcType=BIGINT}) "
    + "ON DUPLICATE KEY UPDATE rid =  #{rid,jdbcType=BIGINT}"
    + ""
})
int insertOrIncr(AccountRid record);

}
