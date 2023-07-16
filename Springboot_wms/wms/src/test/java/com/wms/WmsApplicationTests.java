package com.wms;

import com.wms.entity.Menu;
import com.wms.service.MenuService;
import com.wms.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WmsApplicationTests {
    @Autowired
    UserService userService;
    @Autowired
    private MenuService menuService;
    @Test
    void contextLoads() {
        List<Menu> menus=menuService.lambdaQuery().like(Menu::getMenuRight,1).list();
    }
}
