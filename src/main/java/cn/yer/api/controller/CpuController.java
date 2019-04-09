package cn.yer.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/test")
@Api("api")
public class CpuController {

    @ApiOperation(value = "分页查询cpu", notes = "分页查询")
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String queryCpus(@RequestParam String page) {
        return page;
    }

}
