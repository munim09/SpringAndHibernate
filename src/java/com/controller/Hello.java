/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.naveed.Data;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author user
 */
@Controller
public class Hello {
    @RequestMapping(value="/test",method=RequestMethod.GET)
    public ModelAndView index(ModelMap map){
          
        Data data=new Data();
        
        data.addMember();
        
        map.addAttribute("data", "test data");
        return new ModelAndView("newjsp");
        //return "main";
    }
    
    @RequestMapping(value="/mem",method=RequestMethod.GET)
    public ModelAndView viewMember(ModelMap map){
          
        Data data=new Data();
        
        //data.addMember();
        data.viewMember();
        
        map.addAttribute("data", "test data");
        return new ModelAndView("newjsp");
        //return "main";
    }
    @RequestMapping(value="/addUser",method=RequestMethod.GET)
    public ModelAndView addUserDetails(ModelMap map){
          
        Data data=new Data();
        
        //data.addMember();
        data.addUser();
        
        map.addAttribute("data", "test data");
        return new ModelAndView("newjsp");
        //return "main";
    }
    
    @RequestMapping(value="/addWheeler",method=RequestMethod.GET)
    public ModelAndView addWheeler(ModelMap map){
          
        Data data=new Data();
        
        //data.addMember();
        data.addWheeler();
        
        map.addAttribute("data", "test data");
        return new ModelAndView("newjsp");
        //return "main";
    }
    
    @RequestMapping(value="/viewUser",method = RequestMethod.GET)
    public ModelAndView viewUser(ModelMap map){
        Data data=new Data();
       data.viewUser();
       map.addAttribute("data","test data");
       return new ModelAndView("newjsp");
    }
}
