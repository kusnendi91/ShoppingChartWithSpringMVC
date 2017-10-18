/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kusnendi;

import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/deleted/{productId}")
public class DeleteController {

    @RequestMapping
    public String deleted(@PathVariable("productId") Integer productId, HttpSession session) {
        List<Products> item = (List<Products>) session.getAttribute("baseCart");
        int temp = 0;
        for (int i = 0; i < item.size(); i++) {
            if (Objects.equals(item.get(i).getProductId(), productId)) {
                temp = i;
            }
        }
        item.remove(temp);
        return "deleted";
    }
}
