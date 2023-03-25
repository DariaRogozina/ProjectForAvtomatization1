package org.example.lesson4;


import org.example.lesson4.MyException;
        import org.example.lesson4.Triangle;
        import org.junit.jupiter.api.Assertions;
        import org.junit.jupiter.api.Test;
        import org.junit.jupiter.params.ParameterizedTest;
        import org.junit.jupiter.params.provider.CsvSource;

public class TriangleTest {

    @Test
    void test() throws MyException {
        Triangle triangle = new Triangle();
        Assertions.assertEquals(6,triangle.areaCalculation(3,4,5));
        Assertions.assertThrows(MyException.class,()-> triangle.areaCalculation(-10,20,20));
    }

    @ParameterizedTest
    @CsvSource({ "3,4,5,6","10, 20,20,96.825"})
    void testWithCsvSource(int a, int b,int c, int result) throws MyException {
        Triangle triangle = new Triangle();
        Assertions.assertEquals(result,triangle.areaCalculation(a,b,c));

    }

    @ParameterizedTest
    @CsvSource({ "-10,20,20","-100, 200,200","1,-2,2"})
    void testWithCsvSourceN(int a, int b, int c) throws MyException {
        Triangle triangle = new Triangle();
        Assertions.assertThrows(MyException.class,()-> triangle.areaCalculation(a,b, c));




    }
}