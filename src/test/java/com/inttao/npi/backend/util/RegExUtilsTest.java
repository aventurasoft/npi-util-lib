package com.inttao.npi.backend.util;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
class RegExUtilsTest {

    @Test
    public void test1() {

        BigDecimal val1 =  RegExUtils.extractPercentage("123.45%");
        assertNotNull(val1);
        log.info(val1.toString());


    }
    @Test
    public void test2() {
        assert(RegExUtils.isNumeric("123"));
    }

    @Test
    public void test3() {
        String result = RegExUtils.extractDecimal("123.56");
        assertNotNull(result);
        log.info(result);

    }

}
