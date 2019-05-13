package com.zzj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzj.domain.Book;
import com.zzj.mapper.BookMapper;

/**
 * 
 * 一句话注释
 * 
 * @author 张志坚
 * @version Bessky V100R001 2019年5月8日
 * @since Bessky V100R001C00
 */
@Controller
@RequestMapping(value = "/bessky")
public class HelloController
{
    @Autowired
    private BookMapper bookMapper;
    @ResponseBody
    @RequestMapping(value="/getName",method=RequestMethod.GET)
    public String hello()
    {
        Book book = bookMapper.selectByPrimaryKey(1);
        return book.getBookName();
    }

    @RequestMapping("/")
    public String index(ModelMap map)
    {
        map.addAttribute("host", "http://blog.didispace.com");
        return "index";
    }

}