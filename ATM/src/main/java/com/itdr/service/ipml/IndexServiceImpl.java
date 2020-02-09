package com.itdr.service.ipml;

import com.itdr.dao.IndexDao;
import com.itdr.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
@Transactional
public class IndexServiceImpl implements IndexService {
    @Autowired
    private IndexDao indexDao;
    @Autowired
    private TransactionTemplate tt;

    @Override
    public String tm(String aname, String bname, int money) {
        //参数合法性判断，金额不能超过为负数和0
        //判断B账户是否存在
        //从A账户扣钱
        int i = indexDao.updateByName(aname,money);

        //给B账户加钱
        int i2 = indexDao.updateByName2(bname,money);

        if(i<0 || i2<0){
            return "转账失败！";
        }
        return "转账成功！";
    }

    static boolean bol = false;
    @Override
    public void tm2(String aname, String bname, int money) {
        //匿名内部实现类
        tt.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                //从A账户扣钱
                int i = indexDao.updateByName(aname,money);

                //给B账户加钱
                int i2 = indexDao.updateByName2(bname,money);

                if(i ==1 && i2 == 1){
                    bol = true;
                }
            }
        });
    }



}
