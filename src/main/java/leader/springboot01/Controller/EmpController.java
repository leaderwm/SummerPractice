package leader.springboot01.Controller;

import leader.springboot01.Pojo.Emp;
import leader.springboot01.Pojo.PageBean;
import leader.springboot01.Pojo.Result;
import leader.springboot01.Service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @param name
     */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("分页查询, 参数: {},{},{},{},{},{}",page,pageSize,name,gender,begin,end);

        PageBean pageBean = empService.page(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }

    /**
     * 批量删除
     * @param ids
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除操作, ids:{}",ids);
        empService.delete(ids);
        return Result.success();
    }

    /**
     * 新增员工
     * @param emp
     */
    @PostMapping
    public Result add(@RequestBody Emp emp){
        log.info("新增员工, emp:{}",emp);
        empService.add(emp);
        return Result.success();
    }

    /**
     * 根据id查询员工
     * @param id
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("查询员工, id:{}",id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    /**
     * 更新员工
     * @param emp
     */
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("更新员工, emp:{}",emp);
        empService.update(emp);
        return Result.success();
    }
}
