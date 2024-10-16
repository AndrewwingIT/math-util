package com.andrew.mathutil.core.test;

import com.andrew.mathutil.core.MathUtility;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilityTest {
//Test case structure: ID, description, Steps/Procedures
    //                      Expected Value, Status (Passed, Failed)
    //                      BugID(Bugzilla, Jira)

    //Test case #4: check getFactorial() with n = -1 -2 -3 -4 -5 21 22 23 24
    @Test
    public void testFactorialGiveRightArgumentMinus5ThrowException() {
        //MathUtility.getFactorial(-5);

        assertThrows(IllegalArgumentException.class, () -> {MathUtility.getFactorial(-1);});
        assertThrows(IllegalArgumentException.class, () -> {MathUtility.getFactorial(-2);});
        assertThrows(IllegalArgumentException.class, () -> {MathUtility.getFactorial(-3);});
        assertThrows(IllegalArgumentException.class, () -> {MathUtility.getFactorial(-4);});
        assertThrows(IllegalArgumentException.class, () -> {MathUtility.getFactorial(-5);});
        assertThrows(IllegalArgumentException.class, () -> {MathUtility.getFactorial(21);});
        assertThrows(IllegalArgumentException.class, () -> {MathUtility.getFactorial(22);});
        assertThrows(IllegalArgumentException.class, () -> {MathUtility.getFactorial(23);});
        assertThrows(IllegalArgumentException.class, () -> {MathUtility.getFactorial(24);});
        assertThrows(IllegalArgumentException.class, () -> {MathUtility.getFactorial(25);});
    }//thấy ngoại lệ mừng rơi nước mắt vì hàm thiết kế rằng đưa số âm thì ngoại lệ phải đc ném ra
    // vậy nếu hàm ném ngoại lệ đúng như kì vọng th phải xanh

    //Test case #3 (gộp): check getFactorial() with n = 2 3 4 5 6
    @Test
    public void testFactorialGiveRightArgumentReturnWell(){
        assertEquals(1, MathUtility.getFactorial(0));
        assertEquals(1, MathUtility.getFactorial(1));
        assertEquals(2, MathUtility.getFactorial(2));
        assertEquals(6, MathUtility.getFactorial(3));
        assertEquals(24, MathUtility.getFactorial(4));
        assertEquals(120, MathUtility.getFactorial(5));
        assertEquals(720, MathUtility.getFactorial(6));
    }//bad smells = đoạn code bị bốc mùi (Robert C.Martin) - Clean Code
    //code bị lặp lại, trộn lộn xộn test data và lệnh kiểm thử
    //ta cần tinh chỉnh, tối ưu code: REFACTOR.


    @Test
    //Test case #2: check getFactorial() with n = 1;
    public void testFactorialGiveRightArgument1ReturnWell(){
        long expectedValue = 1;
        long actualValue = MathUtility.getFactorial(1);

        //so sánh 2 giá trị này
        assertEquals(expectedValue, actualValue);
    }

    @Test
    //Test case #1: check getFactorial() with n = 0;
    public void testFactorialGiveRightArgument0ReturnWell(){
        long expectedValue = 1;
        long actualValue = MathUtility.getFactorial(0);

        //so sánh 2 giá trị này
        assertEquals(expectedValue, actualValue);
    }

}