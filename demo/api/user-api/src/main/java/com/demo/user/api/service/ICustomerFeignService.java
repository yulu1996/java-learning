package com.demo.user.api.service;

import com.demo.user.api.dto.CustomerDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "user")
@Api
public interface ICustomerFeignService {

  @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
  @ApiOperation(value = "根据客户id查询客户信息", notes = "根据客户id查询客户信息")
  CustomerDTO getCustomerById(@PathVariable(value = "id") String id);
}
