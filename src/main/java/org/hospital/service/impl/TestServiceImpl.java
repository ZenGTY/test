package org.hospital.service.impl;

import org.hospital.service.TestService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/10/12.
 */
@Service
public class TestServiceImpl implements TestService {

    public String test() {
        return "test";
    }

}
