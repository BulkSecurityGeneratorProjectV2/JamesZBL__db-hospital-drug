/*
 * Copyright 2018 JamesZBL
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package me.zbl.app.controller;

import me.zbl.app.domain.DrugInDO;
import me.zbl.app.domain.DrugOutDO;
import me.zbl.app.service.DrugOutService;
import me.zbl.common.utils.PageWrapper;
import me.zbl.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 药品出库
 *
 * @author JamesZBL
 * @email 1146556298@qq.com
 * @date 2018-05-08
 */
@Controller
public class DrugOutController {

  @Autowired
  private DrugOutService service;

  /**
   * 药品出库页面
   */
  @GetMapping("/inventory/drugout")
  public String drugInPage() {
    return "app/inventory/drug-out";
  }

  /**
   * 药品出库登记
   */
  @GetMapping("/inventory/out")
  public String drugInAddPage() {
    return "app/inventory/out";
  }

  /**
   * 入库记录列表
   *
   * @param params 查询参数
   */
  @ResponseBody
  @GetMapping("/inventory/listout")
  public PageWrapper list(@RequestParam Map<String, Object> params) {
    Query query = new Query(params);
    List<DrugOutDO> list = service.list(query);
    return new PageWrapper(list, service.count());
  }
}
