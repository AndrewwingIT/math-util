package com.andrew.mathutil.core.test;

import com.andrew.mathutil.core.MathUtility;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilityDDTTest {
    //CASE ĐANG DDC TEST ĐÃ ĐỦ HAY CHƯA, VÌ NÓ RẤT DỄ THẤY DO DATA NẰM RIÊNG
    //GIÚP NGUYÊN LÝ Pesticide paradox

    //Bộ data đưua vào test sẽ để riêng ở 1 hàm PUBLIC STATUs
    //hàm này trả về 1 mảng các con số âm < 0  hoặc lớn hơn 20, nó là ~ n gây ra Exception khi ta xài hàm getF()
    public static Integer[] initWrongDataSet(){
        return new Integer[]{-1, -2, -3, -4, -5, -100, -1000, 21, 22, 23, 100};
    }

    //Test case #....: check if getFactorial() throws IllegalArgumentException
    @ParameterizedTest
    @MethodSource("initWrongDataSet")
    public void testFactorialGivenWrongArgumentsThrowException(int n) {
        assertThrows(IllegalArgumentException.class, () -> {
            MathUtility.getFactorial(n);
        });
    }

    //Test case #... :  check getFactorial() with right argument and run well
    //                                        n = 0 1 2 3 4... 18 19 20
    public static Object[][] initRightDataSet() {
        return new Object[][]{{0, 1},
                              {1, 1},
                              {2, 2},
                              {3, 6},
                              {4, 24},
                              {5, 120},
                              {6, 720}
                              };
    }

    @ParameterizedTest
    @MethodSource("initRightDataSet")
    public void testFactorialGivenRightArgumentsRunWell(int n, long expected) {
        assertEquals(expected, MathUtility.getFactorial(n));
    }
}