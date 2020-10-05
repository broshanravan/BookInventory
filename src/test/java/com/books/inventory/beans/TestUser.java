package com.books.inventory.beans;

import com.books.inventory.enums.UserRole;
import org.junit.Test;

public class TestUser {
    @Test
    public void testParametrizedConstructor(){
        User bruce = new User(1, "Bruce", "Roshanravan", "broshanravan", UserRole.Admin);
        assert 1 == bruce.getUserId();
        assert "Bruce".equalsIgnoreCase(bruce.getFirstName());
        assert "Roshanravan".equalsIgnoreCase(bruce.getSurname());
        assert bruce.getUserRole()== UserRole.Admin;
    }

    @Test
    public void testMutators(){

        User laleh = new User();

        laleh.setFirstName("Laleh");
        laleh.setSurname("Yazdi");
        laleh.setUserId(2);
        laleh.setUserName("ylaleh");

        assert "Laleh".equalsIgnoreCase(laleh.getFirstName());
        assert"Yazdi".equalsIgnoreCase(laleh.getSurname());
        assert 2 == laleh.getUserId();
        assert "ylaleh".equalsIgnoreCase(laleh.getUserName());


    }
}
