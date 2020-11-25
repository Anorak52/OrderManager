package org.example.controller;

import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public String orderList(Model model) {
        model.addAttribute("allOrder", orderService.allOrder());
        return "order";
    }

    @PostMapping("/order")
    public String deleteOrder(@RequestParam(required = true, defaultValue = "" ) Long orderId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            orderService.deleteOrder(orderId);
        }
        return "redirect:/order";
    }

    //----Upd order
    @RequestMapping(method = RequestMethod.GET, value = "/{orderId}/edit")
    public String editProduct(@PathVariable long orderId)
    {
        orderService.mergeWithExistingAndUpdate(orderId);
        return "redirect:/order";
    }

    @GetMapping("/order/gt/{orderId}")
    public String gtUser(@PathVariable("orderId") Long orderId, Model model) {
        model.addAttribute("allOrders", orderService.orderGetList(orderId));
        return "order";
    }
}
