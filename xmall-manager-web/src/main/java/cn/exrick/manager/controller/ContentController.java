package cn.exrick.manager.controller;

import cn.exrick.common.pojo.DataTablesResult;
import cn.exrick.common.pojo.Result;
import cn.exrick.common.utils.ResultUtil;
import cn.exrick.content.service.ContentService;
import cn.exrick.manager.pojo.TbContent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "内容列表信息")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @GetMapping(value = "/content/list/{cid}")
    @ApiOperation(value = "通过cid获得内容列表")
    public DataTablesResult getContentByCid(@PathVariable Long cid){

        DataTablesResult result=contentService.getContentListByCid(cid);
        return result;
    }

    @PostMapping(value = "/content/add")
    @ApiOperation(value = "添加内容")
    public Result<Object> addContent(@ModelAttribute TbContent tbContent){

        contentService.addContent(tbContent);
        return new ResultUtil<Object>().setData(null);
    }

    @PostMapping(value = "/content/update")
    @ApiOperation(value = "编辑内容")
    public Result<Object> updateContent(@ModelAttribute TbContent tbContent){

        contentService.updateContent(tbContent);
        return new ResultUtil<Object>().setData(null);
    }

    @DeleteMapping(value = "/content/del/{id}")
    @ApiOperation(value = "删除内容")
    public Result<Object> addContent(@PathVariable Long id){

        contentService.deleteContent(id);
        return new ResultUtil<Object>().setData(null);
    }
}
