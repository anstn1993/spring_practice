package com.moonsoo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BeanScopeTest {
    //동일성(identity): 주소의 동일(==)
    //동등성(equals): 주소는 다르지만 각 주소에 있는 데이터들의 값이 동일(equals())

    @Test
    public void testIdentity() {
        A a1 = new A(1, "a");
        A a2 = a1;
        assertTrue(a1 == a2);
    }

    @Test
    public void testEquals() {
        A a1 = new A(1, "a");
        A a2 = new A(1, "a");
        A a3 = new A(2, "b");
        assertTrue(a1.equals(a2));
        assertFalse(a1.equals(a3));
    }
}

@EqualsAndHashCode
@AllArgsConstructor
class A {
    private int num;
    private String str;

}