package com.baobaotao.advisor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * @author Administrator
 */
@Aspect
public class EnableSellerAspect {
    @DeclareParents(value = "com.baobaotao.advisor.Waiter", defaultImpl = Seller.class)
    public BaseSeller seller;
}