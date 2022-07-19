package com.TTS.helloworld;

//add @Controller annotation | behaves as a ctlr | can dispatch web request
//create method to handle web request
//specify what address of web request
//respond to what endpoint
//specify what HTTP type
//web response GET POST PUT ....etc


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class GreetingController {


    @RequestMapping(value="/cats")
    public String greeting(Model model) {
    //Model variables are used
        //to pass info btw model code and view code

        //ingo that comes from my prog to the web site
        //it will be stored  in model variable.
    model.addAttribute("coolvariable",78);
    return "mywebpage";
    }

}





}
