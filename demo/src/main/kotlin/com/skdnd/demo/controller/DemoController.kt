package com.skdnd.demo.controller

import com.skdnd.common.CommonUtil
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/demo")
class DemoController {

  @GetMapping
  suspend fun getDemo(): String {
    return CommonUtil.sayHi()
  }

  @GetMapping("/{id}")
  suspend fun getDemoDetails(
    @PathVariable id: String,
    @RequestParam(required = false) queryParam: String?,
    @RequestHeader(value = "headerParam", required = false) headerParam: String?
  ): String {
    return "ID: $id, Query Param: $queryParam, Header Param: $headerParam"
  }

  @PostMapping
  suspend fun postDemo(
    @RequestBody body: Map<String, Any>,
    @RequestHeader(value = "headerParam", required = false) headerParam: String?
  ): String {
    return "Body: $body, Header Param: $headerParam"
  }
}