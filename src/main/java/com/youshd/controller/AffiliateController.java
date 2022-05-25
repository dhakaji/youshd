package com.youshd.controller;

import com.youshd.request.OrderStatus;
import com.youshd.response.EarningResponse;
import com.youshd.services.AffiliationService;
import com.youshd.services.DummyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@ControllerAdvice
public class AffiliateController {

    @Autowired
    private AffiliationService affiliationService;

    @Autowired
    private DummyDataService dummyDataService;

    private static final String YES = "yes";
    private static final String NO = "no";
    private static final String ANGELA = "angela";
    private static final String BOB = "bob";
    private static final String MARIA = "maria";
    private static final String MEGGIEB = "meggieb";
    private static final String JIMI = "jimi";
    private static final String HENDRIX = "hendrix";
    private static final String NUSRAT = "nusrat";


    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("orderStatus", new OrderStatus());
//        dummyDataService.addProduct();
//        dummyDataService.addUsers();
        dummyDataService.addDummyData();
        return "Home.jsp";
    }

//    @GetMapping(value = "/")
//    public String welcome(Map<String, Object> model) {
//        model.put("orderStatus", new OrderStatus());
//        return "home";
//    }

    @RequestMapping(value = "/getEarnings", method = RequestMethod.GET)
    public String getEarnings(Model model, @ModelAttribute("orderStatus")OrderStatus orderStatus) {
//        dummyDataService.addDummyData();
        if(YES.equals(orderStatus.getAngela().toLowerCase())) dummyDataService.cancelOrder(ANGELA);
        if(YES.equals(orderStatus.getMaria().toLowerCase())) dummyDataService.cancelOrder(MARIA);
        if(YES.equals(orderStatus.getBob().toLowerCase())) dummyDataService.cancelOrder(BOB);
        if(YES.equals(orderStatus.getMeggieb().toLowerCase())) dummyDataService.cancelOrder(MEGGIEB);
        if(YES.equals(orderStatus.getHendrix().toLowerCase())) dummyDataService.cancelOrder(HENDRIX);
        if(YES.equals(orderStatus.getNusrat().toLowerCase())) dummyDataService.cancelOrder(NUSRAT);
        if(YES.equals(orderStatus.getJimi().toLowerCase())) dummyDataService.cancelOrder(JIMI);
        model.addAttribute("responseList", affiliationService.getAllEarnings());
//        dummyDataService.removeData();
        return "Home.jsp";
    }

    @GetMapping("/getEarning/{userId}")
    public ResponseEntity<EarningResponse> getEarning(@PathVariable int userId) {
        EarningResponse earningResponse = affiliationService.getUserEarning(userId);
        return new ResponseEntity<>(earningResponse, HttpStatus.OK);
    }

}
