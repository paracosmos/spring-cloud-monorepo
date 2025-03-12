package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.example.common.CommonUtil

@RestController
@RequestMapping("/demo")
class DemoController {

  @GetMapping
  fun getDemo(): String {
    return CommonUtil.sayHi()
  }
}