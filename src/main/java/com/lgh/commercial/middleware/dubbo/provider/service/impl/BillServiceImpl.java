package com.lgh.commercial.middleware.dubbo.provider.service.impl;

import com.lgh.commercial.middleware.dubbo.provider.service.BillService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class BillServiceImpl implements BillService {
    @Override
    public String submitBill() {
        return "test";
    }
}
